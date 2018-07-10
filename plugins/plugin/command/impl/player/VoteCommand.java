package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendURL;

/**
 * @author Adam_#6723
 */

public class VoteCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		 player.send(new SendURL("https://www.runity.io/vote"));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
