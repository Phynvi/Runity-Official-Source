package plugin.command.impl.player;

import io.battlerune.content.activity.impl.allvsone.AllVsOne;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * @author Adam_#6723
 */

public class CashOutCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		
		AllVsOne.create(player);
	/*	World.sendStaffMessage(
				"[CASHOUT] " + player.getName() + "Would Like to Cash out! If you're a moderator+ Teleport to him!");
		World.sendStaffMessage("[CASHOUT] " + "They are only allowed to Cash out Pins, and NOTHING ELSE!");
		World.sendStaffMessage(
				"[CASHOUT] " + "You are allowed to take upto 10% fee for middlemanning the trade! on 07 only!");
		player.message("You have alerted all Staff Members that you'd like to cash out your Runity GP for 07!");
		player.message("Friendly Reminder, you can only cash out on the 16th and 30Th of every month!");
		player.message("[NOTE] Only Moderators+ can Middleman the Cash outs! And no rank lower is allowed to do so.");
*/
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
