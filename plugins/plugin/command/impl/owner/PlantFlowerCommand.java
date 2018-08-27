package plugin.command.impl.owner;

import io.battlerune.content.activity.impl.flowerpoker.FlowerHandler;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class PlantFlowerCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		FlowerHandler flower = new FlowerHandler(player);
		flower.plantFlower();
	}

	@Override
	public boolean canUse(Player player) {

		if (!PlayerRight.isDeveloper(player)) {
			player.speak("Hey everyone, i just tried doing something silly.");
			return false;

		} else {

			return true;

		}
	}

}
