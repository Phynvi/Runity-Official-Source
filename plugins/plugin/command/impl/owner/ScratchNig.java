package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.content.scratchcard.ScratchCard;
import io.battlerune.game.world.entity.mob.player.Player;

public class ScratchNig implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		new ScratchCard(player).display();
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
