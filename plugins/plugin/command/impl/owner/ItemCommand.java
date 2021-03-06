package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;

public class ItemCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		try {
			int itemId = Integer.parseInt(parts[1]);
			int amount = Integer.parseInt(parts[2]);
			player.inventory.add(new Item(itemId, amount));
			player.message("[Item Spawner] Added " + amount + " [Amount] : " + itemId + " [Item id]");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Catched ArrayIndexOutOfBounds, ::item command, inproper use of it.");
			player.message("Inproper use of the command do... ::item ItemID Amount (e.g ::item 6199 1)");
		}

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
