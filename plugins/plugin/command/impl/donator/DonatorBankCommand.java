package plugin.command.impl.donator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.position.Area;

/**
 * @author Adam_#6723
 */

public class DonatorBankCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		if (Area.inWilderness(player) && (!PlayerRight.isDeveloper(player))) {
			player.message("You cannot open the bank in the wilderness.");
		} else {
			player.bank.open();
		}
	}

	@Override
	public boolean canUse(Player player) {
		return (PlayerRight.isSupreme(player) || PlayerRight.isKing(player) || PlayerRight.isDeveloper(player));

	}

}
