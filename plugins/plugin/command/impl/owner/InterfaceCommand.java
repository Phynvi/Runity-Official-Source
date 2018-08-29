package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.MessageColor;

/**
 * @author Adam_#6723
 */

public class InterfaceCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		int id = Integer.parseInt(parts[1]);
		player.interfaceManager.open(id);
		player.send(new SendMessage("Opening interface: " + id, MessageColor.LIGHT_PURPLE));

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
