package io.battlerune.game.world.entity.mob.player;

import java.util.Arrays;
import java.util.Optional;

import io.battlerune.Config;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.data.LockType;
import io.battlerune.game.world.entity.mob.player.profile.Profile;
import io.battlerune.game.world.entity.mob.player.profile.ProfileRepository;

/**
 * Handles account security.
 *
 * @author Daniel
 */
public class AccountSecurity {

	/** The player instance. */
	private Player player;

	/** Constructs a new <code>AccountSecurity<code>. */
	AccountSecurity(Player player) {
		this.player = player;
	}

	/** Handles account login. */
	public void login() {
		String name = player.getName();
		String host = player.lastHost;

		if (!player.hostList.contains(host))
			player.hostList.add(host);

		ProfileRepository.put(new Profile(name, player.getPassword(), host, player.hostList, player.right));

		if (!AccountData.forName(name).isPresent()) {
			if (player.right == PlayerRight.MODERATOR || player.right == PlayerRight.OWNER
					|| player.right == PlayerRight.ADMINISTRATOR || player.right == PlayerRight.DEVELOPER) {
				player.right = PlayerRight.PLAYER;
				player.inventory.clear();
				player.equipment.clear();
				player.pkPoints = 0;
				player.skillingPoints = 0;
				player.bossPoints = 0;
				player.triviaPoints = 0;
				player.votePoints = 0;
				player.donation.setCredits(0);
				player.pestPoints = 0;
				player.kolodionPoints = 0;
				player.refferalpoint = 0;
				player.bank.clear();
				player.setVisible(true);
			} else if (PlayerRight.isDonator(player)) {
				player.setVisible(true);
				player.donation.updateRank(true);
			}
			return;
		}

		player.interfaceManager.close();
		AccountData account = AccountData.forName(name).get();
		player.setVisible(true);

		if (!Config.LIVE_SERVER || host.equals("127.0.0.1")) {
			return;
		}

		if (account.getName().equalsIgnoreCase(name)) {
			if ((account.getRight() == PlayerRight.OWNER || account.getRight() == PlayerRight.DEVELOPER)
					&& player.right != account.right)
				player.right = account.right;

			for (String hosts : account.getHost()) {
				if (host.equalsIgnoreCase(hosts))
					return;
			}

			if (account.getKey().isEmpty()) {
				return;
			}

			player.locking.lock(LockType.MASTER_WITH_COMMANDS);
			player.message(
					"<col=F03541>You have logged in with an un-authorized IP address. Your account was locked. Please");
			player.message("<col=F03541>enter your security key by command. ::key 12345");
			World.sendStaffMessage(
					"<col=E02828>[AccountSecurity] Un-recognized staff host address : " + player.getName() + ".");
		}
	}

	/** Holds all the account security data for the management team. */
	public enum AccountData {

		YVEZ(PlayerRight.MODERATOR, "Yvez", "963262", "24.207.242.241"),
		YURDLE(PlayerRight.ADMINISTRATOR, "Yurdle", "", "76.175.167.21", ""),
		LIL_FROG(PlayerRight.HELPER,  "Lilfrog", "052094", "", ""),
		SAPHIRA(PlayerRight.HELPER,  "Saphira", "052094", "", ""),
		ADAM(PlayerRight.DEVELOPER, "Adam", "23042000", "82.17.234.134"), 
		TEEK(PlayerRight.DEVELOPER, "Teek", "23042000", "86.28.217.152"), 
		JORDAN(PlayerRight.OWNER, "Jordan", "68510", "92.30.202.171", ""),
	//	MASON(PlayerRight.MANAGER, "Mason", "802111", "108.168.97.8"),
		SAGE(PlayerRight.GAMBLE_MANAGER, "Sage", "", "74.76.104.21"),
		MELON(PlayerRight.DONATION_MANAGER, "Melon", "9089", "115.249.154.50"),
       
		
		;
		private final String name;
		private final String key;
		private final PlayerRight right;
		private final String[] host;

		AccountData(PlayerRight right, String name, String key, String... host) {
			this.right = right;
			this.name = name;
			this.key = key;
			this.host = host;
		}

		public static Optional<AccountData> forName(String name) {
			return Arrays.stream(values()).filter(a -> a.name.equalsIgnoreCase(name)).findAny();
		}

		public String getName() {
			return name;
		}

		public PlayerRight getRight() {
			return right;
		}

		public String getKey() {
			return key;
		}

		public String[] getHost() {
			return host;
		}
	}
}
