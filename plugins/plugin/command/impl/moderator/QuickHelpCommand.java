package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * 
 * @author Adam_#6723
 *
 */

public class QuickHelpCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
        World.sendMessage("@red@" + player.getName() +" @blu@is avaliable for any questions! feel free to PM Him!");
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
