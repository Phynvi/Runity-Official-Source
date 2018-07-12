package plugin.click.button;

import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;
import io.battlerune.net.packet.out.SendURL;

/**
 * 
 * @author Adam_#6723
 *
 */

public class PlayerGuideInterfacePlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		if (button == -9485) {
	        player.send(new SendString("Information", 56006, true));
	        player.send(new SendString("Difficulty: Easy", 56007, true));
	        player.send(new SendString("N/A", 56008, true));
	        player.send(new SendString("Main Currency?", 56013, true));
	        player.send(new SendString("Where Can I Spend The These Tickets?", 56014, true));

	        player.send(new SendString("Our economy is built by the players. \\nWe have introduced 1Bill and 500 Mill Tickets."
	        + "\\nMonsters all over runity drop the tickets \\nYou can also gain these tickets in bulks \\nfrom Mystery boxes and donating."      		
	        		, 56012, true));
	        player.send(new SendString("These tickets can be spent at \\nvarious shops all over runity \\nbut mainly spent at the rare store \\nCustoms store and PVM store."
	        		, 56017, true));


		}

		if (button == -9484) {
	      //MONEY MAKING GUIDE BUTTON.
			player.send(new SendURL("INSERT MONEY MAKING GUIDE ON YOUTUBE HERE."));
		}

		if (button == -9483) {
	        player.send(new SendString("Mulla Related", 56006, true));
	        player.send(new SendString("Medium", 56007, true));
	        player.send(new SendString("200B P/H", 56008, true));
	        player.send(new SendString("Be a fucking retarded netherland\\n and suck dick all day.", 56012, true));

		}
		
		
		/** Closes the interface! **/
		if(button == -23034) {
			player.interfaceManager.close();
		}

		return false;
	}
	
	
}
