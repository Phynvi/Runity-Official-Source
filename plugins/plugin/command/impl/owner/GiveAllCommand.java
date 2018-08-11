package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class GiveAllCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		/*
		 * int itemId = Integer.parseInt(command[1]); int amount =
		 * Integer.parseInt(command[2]); World.sendItem(itemId, amount);
		 */
		int itemId = Integer.parseInt(command[1]);
		int amount = Integer.parseInt(command[2]);
		for (Player players : World.getPlayers()) {
			if (players != null) {
				players.inventory.add(new Item(itemId, amount));
				Item starterbox = new Item(itemId);
				players.send(new SendMessage("You have all received a " + starterbox.getName() + " From Adam!"));
				players.send(new SendMessage(
						"@lre@This is a token of appreciation from Adam himself, for being loyal players!"));
			}
		}
	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, I just tried to do something silly!");
		return false;
	}

}
