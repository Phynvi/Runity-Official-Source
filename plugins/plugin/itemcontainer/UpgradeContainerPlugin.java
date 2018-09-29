package plugin.itemcontainer;

import io.battlerune.content.upgrading.UpgradeDisplay;
import io.battlerune.game.event.impl.ItemContainerContextMenuEvent;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;

public class UpgradeContainerPlugin extends PluginContext {

	@Override
	protected boolean firstClickItemContainer(Player player, ItemContainerContextMenuEvent event) {
		if (event.getInterfaceId() == 48275) {
			Item item = new Item(event.getRemoveId());
			new UpgradeDisplay(player, item).select();
			return true;
		}
		return false;
	}


}
