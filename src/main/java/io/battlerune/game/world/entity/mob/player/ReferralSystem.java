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
	
	private Player player;
	
	private Player reffered;
	
	private String refferedName;
	
	private static final int TOTAL_POINTS = 1;
	
	public ReferralSystem(Player player) {
		this.player = player;
	}

	public void handleReferral() {
		
		player.send(new SendInputMessage("Who refered you to Runity?", 20, input -> {
			try {
				reffered = World.getPlayerByName(input);
				refferedName = input;
				linkReferral();
			} catch (Exception e) {
				player.sendMessage("We were unable to link you with your referral!");
				System.err.println("User not online to link refferal.");
			}
		}));
	}

	private void linkReferral() {
		
		if (reffered == null) {//not online
			System.out.println("not online");
		} else if (!PlayerSerializer.saveExists(refferedName)) {
			System.out.println("no save for reffered");
			return;
		}	
		reffered.refferalpoint += TOTAL_POINTS;
		reffered.sendMessage("You have been given "+TOTAL_POINTS+" for refering "+player.getUsername()+".");
	}
}
