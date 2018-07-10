package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;

/**
 * @author Adam_#6723
 */

public class SpawnCustomCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.inventory.addAll(CustomList());
		player.message("Spawned 1x Dragon Slayer Set");
		player.message("Spawned 1x Zaros Set");

	}
	
	public Item[] CustomList() {
		return new Item[] { new Item(21777), new Item(22123), new Item(21954), new Item(22099), new Item(22078),
		};
	}
	

	@Override
	public boolean canUse(Player player) {
		if(PlayerRight.isDeveloper(player)) {
		return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}
}
