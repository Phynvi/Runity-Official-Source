package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.halloffame.FameBoard;
import io.battlerune.content.halloffame.FameBoardInterface;
import io.battlerune.content.halloffame.PlayerKillingBoard;
import io.battlerune.game.world.entity.mob.player.Player;

public class FameBoardCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		PlayerKillingBoard.load();
		// FameBoardInterface.open(FameBoard.PVP, player);
		FameBoardInterface.open(FameBoard.MISC, player);
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
