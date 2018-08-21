package plugin.click.button;

import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;

public class ScratchCardButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		Item items[] = new Item[3];

		if (button == 20016) {

		}

		if (button == 20021) {
			
		}
		if(button == 20026) {
			
		}

		return false;
	}
}