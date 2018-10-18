package plugin.command.impl.moderator;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * 
 * @author Adam_#6723
 *
 */

public class DoubleAVO implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Config.DOUBLE_AVO_POINTS = true;
		World.sendBroadcast(60,"[DAILY SERVER EVENTS] Double Tickets at AvO Minigame Is Now Activated for 24 Hours!", false);
	}
	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
