package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

public class CommandList implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.send(new SendString("Commands List", 37103));
		player.send(new SendString("", 37107));

		String[] commands = { "Nigger", "Nigger2" };

		for (int i = 0; i < 50; i++) {
			player.send(new SendString(commands[i], i + 37111));
		}
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
