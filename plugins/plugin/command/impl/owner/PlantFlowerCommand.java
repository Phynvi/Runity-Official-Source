package plugin.command.impl.owner;

import io.battlerune.content.activity.impl.flowerpoker.FlowerHandler;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

public class PlantFlowerCommand implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		FlowerHandler flower = new FlowerHandler(player);
		flower.plantFlower();
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
