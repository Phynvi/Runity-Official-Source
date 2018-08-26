package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * 
 * @author Adam_#6723
 *
 */

public class UpdateCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		int time = Integer.parseInt(parts[1]);
		World.update(time, false);

	}

	@Override
	public boolean canUse(Player player) {
		
		  if (!PlayerRight.isDeveloper(player)) { 
			  player.speak("Hey everyone, i just tried doing something silly."); 
			  return false; 
			  
			  }
		else {
			
		return true;
		
		}
	}

}
