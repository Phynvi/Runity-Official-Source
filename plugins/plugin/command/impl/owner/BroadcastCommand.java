package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * 
 * @author Adam_#6723
 *
 */

public class BroadcastCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		try {
			final String input = String.format(parts[1]);
			World.sendBroadcast(1, input, true);
		} catch (ArrayIndexOutOfBoundsException e) {
			player.message("Invalid use of the command do ::broadcast 'input message'.");
		}
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
