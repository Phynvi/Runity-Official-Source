package io.battlerune.game.world.entity.mob.player;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.persist.PlayerSerializer;
import io.battlerune.net.packet.out.SendInputMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class ReferralSystem {

	private static final int TOTAL_POINTS = 1;

	public static void handleReferral(Player player) {

		player.send(new SendInputMessage("Who refered you to Runity?", 20, input -> {
			try {
				linkReferral(player, input);
			} catch (Exception e) {
				player.sendMessage("We were unable to link you with your referral!");
				System.err.println("User not online to link refferal.");
			}
		}));
	}

	private static void linkReferral(Player refer, String referalName) {

		if (!PlayerSerializer.saveExists(referalName) || referalName == null || referalName.isEmpty()) 
			return;

		Player other = World.getPlayerByName(referalName);

		if (other == null) {
			try {
				Player p = PlayerSerializer.loadPlayer(referalName);
				p.setRefferalPoints(p.getReferralPoints() + 1);
				PlayerSerializer.saveOffline(p);
			} catch (Exception e) {
				System.out.println("error loading player..");
				return;
			}
		} else {
			other.refferalpoint += TOTAL_POINTS;
			other.sendMessage("You have been given " + TOTAL_POINTS + " for refering " + refer.getUsername() + ".");
		}
		refer.sendMessage("Thank you for setting a referal!");
	}
}
