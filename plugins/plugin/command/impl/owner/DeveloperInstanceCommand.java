package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class DeveloperInstanceCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.message("instance is " + player.instance);
	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, I just tried to do something silly!");
		return false;
	}

}
