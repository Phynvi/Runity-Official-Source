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
	private static final int TOTAL_REFFERALS = 1;

	public static void handleReferral(Player player) {

		player.send(new SendInputMessage("Who refered/Invited you to Runity? Mention them for free Donator Rank!", 20, input -> {
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
	/*	    if (other.lastHost.equalsIgnoreCase(refer.lastHost) || refer.lastHost.equalsIgnoreCase(other.lastHost)) {
				other.message("<col=FF0019>You were not rewarded since you share the same IP Address.");
				refer.message("<col=FF0019>You were not rewarded since you share the same IP Address.");
				return;
			}*/
		    other.totalRefferals += TOTAL_REFFERALS;
			other.refferalpoint += TOTAL_POINTS;
			other.sendMessage("You have been given " + TOTAL_POINTS + " for refering " + refer.getUsername() + ".");
			other.donation.setCredits(other.donation.getCredits() + 10);
			other.inventory.add(290, 1);
			other.sendMessage("You have been given 10 Donation Credits!");
			other.sendMessage("You have also been given an Inferno Box for reffering someone!");
		}
		refer.sendMessage("Thank you for setting a referal!");
		refer.refferalpoint += TOTAL_POINTS;
		refer.inventory.add(290, 1);
		refer.inventory.add(13190, 1);
		refer.donation.setCredits(100);
		refer.donation.setSpent(10);
		refer.sendMessage("You have recieved Inferno Box by Joining via an existing member on Runity!");
		refer.sendMessage("You have been given a referal  & Donator Rank, speak to ref to use these points");
        refer.sendMessage("Refer your friends over so you and them can both be given a referal point!");
        refer.sendMessage("Relog to update your rank!");
	}
}
