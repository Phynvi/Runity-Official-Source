package plugin.click.button;

import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;

public class ExamineButtonPlugin extends PluginContext {
	
	
	@Override
	protected boolean onClick(Player player, int button) {
		if(button == -13390 ) {
			player.interfaceManager.close();
			return true;
		}
		
		return false;
	}
	

}
