package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

public class MyposCommand implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		player.message("Position X [" + player.getPosition().getX() + "]" + "- Y [" + player.getPosition().getY()
				+ "] - Z [" + player.getPosition().getHeight() + "]");
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
