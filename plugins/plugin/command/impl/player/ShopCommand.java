package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * @author Adam_#6723
 */

public class ShopCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		 Teleportation.teleport(player, Config.STORES_POSITION);
         player.message("Here you will find all the stores that are irrelavant to take space up at home");	
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
