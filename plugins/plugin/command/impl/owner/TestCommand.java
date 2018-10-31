package plugin.command.impl.owner;

import io.battlerune.content.activity.impl.duovsall.DuoVsAll;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class TestCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		   Player other = player.getAllForOnePartner();
		   //new DuoVsAll(player, player.playerAssistant.instance(), other).create();
		
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
