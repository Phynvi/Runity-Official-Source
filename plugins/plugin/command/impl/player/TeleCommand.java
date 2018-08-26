package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Jordan
 *
 */
public class TeleCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		int x = Integer.parseInt(parts[1]);
		int y = Integer.parseInt(parts[2]);
		int z = Integer.parseInt(parts[3]);
		AdamIndianTeleporter.adamindianteleporter(player, x, y, z);
		player.send(new SendMessage("You have teleported to: " + x + ", " + y + ", " + z));
	}

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("I just tried to do something silly!");
		return false;
	}
}
