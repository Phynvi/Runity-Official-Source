package plugin.click.button;

import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendURL;

/**
 * 
 * @author Adam_#6723
 *
 */

public class GuideClickingPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		switch (button) {
	
		case -9472:
			player.send(new SendURL("https://runity.io/forums/topic/162-most-efficient-prayer-guide"));
			player.message("@red@ Opening Prayer Guide! credits to : Mason");
			break;
		case -9471:
			player.send(new SendURL("https://runity.io/forums/topic/161-most-efficient-fishing-guide"));
			player.message("@red@ Opening Fishing Guide! credits to : Mason");

			break;
		case -9470:
			player.send(new SendURL("https://runity.io/forums/topic/160-most-efficient-runecrafting-guide"));
			player.message("@red@ Opening Runecrafting Guide! credits to : Mason");
			break;
		case -9469:
				player.send(new SendURL("https://runity.io/forums/topic/159-most-efficient-mining-guide"));
				player.message("@red@ Opening Mining Guide! credits to : Mason");
			break;
		case -9468:
			player.send(new SendURL("https://runity.io/forums/topic/153-all-vs-one-waves/"));
			player.message("@red@ Opening All Vs One! credits to : Mason");
		break;
		case -9467:
			player.send(new SendURL("https://runity.io/forums/topic/155-all-vs-one-v2-waves/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		}
		return false;
	}
}
