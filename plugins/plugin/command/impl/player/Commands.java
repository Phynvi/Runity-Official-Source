package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

/**
 * 
 * @author Adam_#6723
 *
 */
public class Commands implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		player.send(new SendString("", 37113));
		player.send(new SendString("", 37107));
		player.send(new SendString("Runity Commands", 37103));
		player.send(new SendString("::home - teleports the player home.", 37111));
	
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
