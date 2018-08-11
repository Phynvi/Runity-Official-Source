package plugin.click.button;

import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

public class RuneliteAttackButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {

		if (button == 1772) {
			if (player.interfaceManager.getWalkable() != 34500) {
				player.interfaceManager.setWalkable(34500);
			}
		}

		if (button == 5860) {
			if (player.interfaceManager.getWalkable() != 34500) {
				player.interfaceManager.setWalkable(34500);
				player.send(new SendString("Punch", 34502, true)); // Attack Styles
			}
		}

		return false;
	}
}