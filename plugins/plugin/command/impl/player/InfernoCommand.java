package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * @author Adam_#6723
 */

public class InfernoCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
        //Inferno.create(player);
		player.message("Inferno isn't released yet, still under construction!");
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
}
