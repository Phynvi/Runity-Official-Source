package plugin.command.impl.owner;

import io.battlerune.content.activity.randomevent.impl.MimeEvent;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * @author Adam_#6723
 */

public class RandomEvent implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1]);

		World.search(name.toString()).ifPresent(MimeEvent::create);
		player.message("Remember command use; ::randomevent daniel");

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}
}
