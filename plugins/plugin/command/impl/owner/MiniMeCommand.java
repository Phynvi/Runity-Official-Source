package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMiniMeData;

public class MiniMeCommand implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		player.send(new SendMiniMeData(11056));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
