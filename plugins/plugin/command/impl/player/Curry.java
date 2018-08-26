package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Jordan
 *
 */
public class Curry implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		// TODO Auto-generated method stub
		player.send(new SendMessage("Adam fucks curry"));
	}

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		return true;
	}

}
