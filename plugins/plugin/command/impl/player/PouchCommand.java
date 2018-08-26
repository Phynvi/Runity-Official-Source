package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Area;
import io.battlerune.net.packet.out.SendInputAmount;

/**
 * @author Adam_#6723
 */

public class PouchCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		if (player.getCombat().isUnderAttack() || player.getCombat().isAttacking() || Area.inWilderness(player)
				|| Area.inWilderness(player) || Area.inWildernessCourse(player) || Area.inWildernessResource(player)) {
			player.message("You cannot access your Vault whilst in combat! or in the wilderness!");
		} else {

			player.send(new SendInputAmount("Enter the amount of coins you want to withdraw:", 10,
					input -> player.bankVault.withdraw(Long.parseLong(input))));
		}
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
}
