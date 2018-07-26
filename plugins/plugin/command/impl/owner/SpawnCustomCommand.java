package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;

/**
 * @author Adam_#6723 test
 */

public class SpawnCustomCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.bank.addAll(CustomList());
		player.message("Spawned!");
	}

	public Item[] CustomList() {
		return new Item[] { new Item(21777), new Item(22123), new Item(21954), new Item(22099), new Item(22078),
				new Item(13189), new Item(13299), new Item(13206), new Item(13300), new Item(15177), new Item(10577),
				new Item(22301), new Item(22304), new Item(22307), new Item(15011), new Item(3273), new Item(3274),
				new Item(3275), new Item(15300), new Item(15307), new Item(15301), new Item(15302), new Item(15303),
				new Item(15304), new Item(15308), new Item(15309), new Item(15310), new Item(10860), new Item(10861), };
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
