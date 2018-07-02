package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

public class SkullCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.skulling.skull();
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
