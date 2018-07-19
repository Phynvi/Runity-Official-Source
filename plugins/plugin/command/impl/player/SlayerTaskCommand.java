package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

public class SlayerTaskCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.message("You have " + player.slayer.getAmount() + " of " + player.slayer.getTask() + "!");
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
