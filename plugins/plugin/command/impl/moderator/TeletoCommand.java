package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class TeletoCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		final String name = String.format(parts[1]);

		if (World.search(name).isPresent()) {
			final Player target = World.search(name).get();
			player.move(target.getPosition());
			player.instance = target.instance;
		} else {
			player.send(new SendMessage("@or2@The player '" + name + "' @or2@either doesn't exist, or is offline."));
		}

	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isManagement(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}

}
