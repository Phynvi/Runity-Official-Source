package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;

public class StuckCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		World.sendStaffMessage("[STUCK]" + player.getName() + " Is Stuck!");
		player.message("Staff team have been alerted!");
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
