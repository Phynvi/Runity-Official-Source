package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.content.prestige.Prestige;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * @author Adam_#6723
 */

public class PrestigeTestCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Prestige prestige = new Prestige(player);

		if (player.skills.isMaxed()) {
		}

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}
}
