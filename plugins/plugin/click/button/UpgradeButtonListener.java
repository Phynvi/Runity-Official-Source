package plugin.click.button;

import io.battlerune.content.upgrading.UpgradeListener;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;

public class UpgradeButtonListener extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		switch(button) {
		
		case -17251:
			new UpgradeListener(player).execute();
			return true;
		}
		return false;
	}
}
