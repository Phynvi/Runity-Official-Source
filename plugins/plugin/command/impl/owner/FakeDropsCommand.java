package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;

/**
 * 
 * @author Adam_#6723
 *
 */

public class FakeDropsCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1].replaceAll("_", " "));
		World.sendMessage("<col=BA383E>Runity: <col=" + player.right.getColor() + ">" + player.getName()
		+ " </col>has just received " + Utility.getAOrAn(name) + " <col=BA383E>" + name
		+ "</col>!");
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
