package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class posCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		player.message("You have teleported to : " + player.getPosition().getX() + " - " + player.getPosition().getY()
				+ " - " + player.getPosition().getHeight());
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
