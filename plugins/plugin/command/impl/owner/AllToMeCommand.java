package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class AllToMeCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Position position = player.getPosition().copy();
		World.getPlayers().forEach(players -> {
			if (!players.equals(player)) {
				players.move(position);
				players.send(new SendMessage("You have been mass teleported by " + player.getName()));
			}
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
