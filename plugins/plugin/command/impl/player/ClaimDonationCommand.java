package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class ClaimDonationCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		new java.lang.Thread() {
			public void run() {
				try {
					com.everythingrs.donate.Donation[] donations = com.everythingrs.donate.Donation.donations(
							"d6yzms44avukb49h1232j4i99pf19m99i3uqugiaspdshtui19wfjv364piqs8tbb0yyn3rt",
							player.getUsername());
					if (donations.length == 0) {
						player.send(
								new SendMessage("You currently don't have any items waiting. You must donate first!"));
						return;
					}
					if (donations[0].message != null) {
						player.send(new SendMessage(donations[0].message));
						return;
					}
					if (player.inventory.getFreeSlots() <= 5) {
						player.message("You need more inventory space to claim your donation!");
					}
					for (com.everythingrs.donate.Donation donate : donations) {
						player.inventory.add(new Item(donate.product_id, donate.product_amount));
					}
					World.sendMessage("<col=CF2192>[Donation]</col> <col="+player.right.getColor()+ "> "
							+ "" +player.getUsername()+ " </col> <col=CF2192> has just donated, thank you! </col>");
					player.send(new SendMessage("Thank you for donating!"));
				} catch (Exception e) {
					player.send(new SendMessage("Api Services are currently offline. Please check back shortly"));
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
