package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.MessageColor;

public class PlayerCountCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		player.send(new SendMessage("There are currently " + World.getPlayerCount() + " players playing Runity!",
				MessageColor.RED));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
