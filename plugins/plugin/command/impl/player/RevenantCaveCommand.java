package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * @author Adam_#6723
 */

public class RevenantCaveCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Teleportation.teleport(player, Config.REV_CAVES);
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
