package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class ClaimDonationCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
	/*	new java.lang.Thread() {
			public void run() {
				try {
					com.everythingrs.donate.Donation[] donations = com.everythingrs.donate.Donation.donations(
							"q4rhr25th8khv9615x19ssjoret8cj0nrfk23xho17iaspds4i4vi00n01sb8irza2fzsmgf1or",
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
					for (com.everythingrs.donate.Donation donate : donations) {
						player.inventory.add(new Item(donate.product_id, donate.product_amount));
					}
					player.send(new SendMessage("Thank you for donating!"));
				} catch (Exception e) {
					player.send(new SendMessage("Api Services are currently offline. Please check back shortly"));
					e.printStackTrace();
				}
			}
		}.start();*/
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
