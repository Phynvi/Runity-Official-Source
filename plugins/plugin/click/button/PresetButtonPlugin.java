package plugin.click.button;

import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendURL;

public class PresetButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		switch (button) {
		
		}
		return false;
	}
}
