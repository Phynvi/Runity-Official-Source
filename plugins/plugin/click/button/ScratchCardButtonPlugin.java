package plugin.click.button;

import java.util.Random;

import io.battlerune.content.scratchcard.ScratchCard;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendItemOnInterface;

public class ScratchCardButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		new ScratchCard(player).reveal(button);
		return false;
	}
}