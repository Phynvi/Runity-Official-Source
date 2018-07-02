package plugin.command.impl.player;

import io.battlerune.content.DropSimulator;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

public class DropSimulatorCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		DropSimulator.open(player);
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
