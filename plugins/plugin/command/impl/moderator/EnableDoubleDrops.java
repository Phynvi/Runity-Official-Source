package plugin.command.impl.moderator;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.punishments.PunishmentExecuter;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class EnableDoubleDrops implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Config.DOUBLE_DROPS = true;
		World.sendBroadcast(60, "[DAILY SERVER EVENTS] Double Drops Is Now Activated for 1 Hours!", false);
	}

	
	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isPriviledged(player);
	}

}
