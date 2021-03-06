package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * 
 * @author Adam_#6723
 *
 */

public class RemovePlayerTask implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		try {
			final String name = String.format(parts[1]);
			World.search(name.toString()).ifPresent(other -> {
				other.slayer.setTask(null);
				other.slayer.setAmount(0);
				other.message("Your slayer task was reset.");
				player.message("Remember command use; ::removetask daniel");
			});

		} catch (ArrayIndexOutOfBoundsException e) {
			player.message("its used like this ::removetask playername, (e.g. ::removetask adam)");
			System.out.println("");
		}

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}
}
