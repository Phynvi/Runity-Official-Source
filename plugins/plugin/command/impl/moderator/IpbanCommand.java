package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.punishments.PunishmentExecuter;
import io.battlerune.net.packet.out.SendMessage;

public class IpbanCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1].replaceAll("_", " "));

		World.search(name.toString()).ifPresent(other -> {
			if (PunishmentExecuter.IPBanned(other.lastHost)) {
				player.send(new SendMessage(
						"Player " + other.getUsername() + "'s IP is already banned. Command logs written."));
				return;
			}
			final String bannedIP = other.lastHost;
			PunishmentExecuter.addBannedIP(bannedIP);
			player.send(new SendMessage(
					"Player " + other.getUsername() + "'s IP was successfully banned. Command logs written."));
			for (Player playersToBan : World.getPlayers()) {
				if (playersToBan == null) {
					continue;
				}
				if (playersToBan.lastHost == bannedIP) {
					World.queueLogout(playersToBan);
					if (other.getUsername() != playersToBan.getUsername()) {
						player.send(new SendMessage("Player " + playersToBan.getUsername()
								+ " was successfully IPBanned. Command logs written."));
					}
				}
			}
		});

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
