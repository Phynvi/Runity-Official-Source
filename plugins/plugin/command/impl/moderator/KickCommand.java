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

public class KickCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1]);
		World.kickPlayer(p -> p.getName().equalsIgnoreCase(name));
		player.send(new SendMessage("@or2@You have kicked " + name + "!"));
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
