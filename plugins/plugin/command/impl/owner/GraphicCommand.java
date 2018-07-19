package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.Graphic;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class GraphicCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		int id = Integer.parseInt(command[1]);
		player.graphic(new Graphic(id));
		player.send(new SendMessage("Performing graphic = " + id));

	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}

}
