package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;

/**
 * @author Adam_#6723
 */

public class HomeCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		for(int i = 0; i < 600; i++) {
			player.bank.add(new Item(i + 1, 1));
			player.bank.refresh();
		}
		
		//Teleportation.teleport(player, Config.DEFAULT_POSITION);
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
}
