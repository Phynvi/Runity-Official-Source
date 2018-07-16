package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;

public class ItemCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		int itemId = Integer.parseInt(command[1]);
		int amount = Integer.parseInt(command[2]);
		player.inventory.add(new Item(itemId, amount));
		player.message("[Item Spawner] Added " + amount + " [Amount] : " + itemId + " [Item id]");

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
