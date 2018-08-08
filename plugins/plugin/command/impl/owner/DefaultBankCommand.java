package plugin.command.impl.owner;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;

/**
 * @author Adam_#6723 test
 */

public class DefaultBankCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.bank.clear();
		player.bank.addAll(Config.BANK_ITEMS);
		System.arraycopy(Config.TAB_AMOUNT, 0, player.bank.tabAmounts, 0, Config.TAB_AMOUNT.length);
		player.bank.shift();
		player.message("Spawned! Normal RS Items.");
	}



	@Override
	public boolean canUse(Player player) {
/*		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;*/
		return true;
	}
}
