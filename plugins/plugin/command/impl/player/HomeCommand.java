package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.npc.dropchance.DropChanceHandler;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class HomeCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		//Teleportation.teleport(player, Config.DEFAULT_POSITION);
		player.send(new SendMessage(new DropChanceHandler(player).getRate()));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
}
