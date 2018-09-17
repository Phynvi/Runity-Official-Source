package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.freeforall.impl.FreeForAllLobbyTask;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class FreeForAllLobbyCommand implements Command {

	
	@Override
	public void execute(Player player, String command, String[] parts) {
		new FreeForAllLobbyTask(player).execute();
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
	

}
