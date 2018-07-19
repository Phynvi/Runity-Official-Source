package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class GodCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.skills.setLevel(0, 1500);
		player.skills.setLevel(1, 1500);
		player.skills.setLevel(2, 1500);
		player.skills.setLevel(3, 1500);
		player.skills.setLevel(4, 1500);
		player.send(new SendMessage("You are now in god mode my nigga, cherish it whilst you can."));
	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, I just tried to do something silly!");
		return false;
	}

}
