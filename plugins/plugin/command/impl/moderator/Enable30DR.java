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

public class Enable30DR implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Config.DR_30_BOOST = true;
		World.sendBroadcast(60, "[DAILY SERVER EVENTS] 30% Drop Rate Boost Is Now Activated for 24 Hours!", false);
	}
	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isPriviledged(player);
	}

}
