package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.Animation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

public class AnimationCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		int id = Integer.parseInt(parts[1]);
		player.animate(new Animation(id));
		player.send(new SendMessage("Performing animation = " + id));

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
