package plugin.click.button;

import io.battlerune.content.scratchcard.ScratchCard;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;

public class ScratchCardButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		switch (button) {

		case 20016:
		case 20021:
		case 20026:
		case 20033:
		case 20037:
			new ScratchCard(player).reveal(button);
			break;
		}
		return false;
	}
}