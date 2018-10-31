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
		case -9466:
			player.send(new SendURL("https://runity.io/forums/topic/173-most-efficient-crafting-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9465:
			player.send(new SendURL("https://runity.io/forums/topic/172-most-efficient-smithing-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9464:
			player.send(new SendURL("https://runity.io/forums/topic/171-most-efficient-fletching-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9463:
			player.send(new SendURL("https://runity.io/forums/topic/170-most-efficient-firemaking-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9462:
			player.send(new SendURL("https://runity.io/forums/topic/169-most-efficient-herblore-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9461:
			player.send(new SendURL("https://runity.io/forums/topic/168-most-efficient-thieving-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9460:
			player.send(new SendURL("https://runity.io/forums/topic/167-most-efficient-cooking-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9459:
			player.send(new SendURL("https://runity.io/forums/topic/166-most-efficient-woodcutting-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9458:
			player.send(new SendURL("https://runity.io/forums/topic/165-most-efficient-agility-guide/"));
			player.message("@red@ Opening All Vs One V2! credits to : Mason");
		break;
		case -9457:
			player.send(new SendURL("https://runity.io/forums/topic/218-beginners-guide/"));
			player.message("@red@ Opening Starter Guide credits to : Genesis");
			break;
		}
		return false;
	}
}
