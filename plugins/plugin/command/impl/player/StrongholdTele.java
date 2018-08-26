package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class StrongholdTele implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Teleportation.teleport(player, Config.CHIMERA, 20, () -> {
			player.send(new SendMessage("@or2@Welcome to Chimera's Lair! Kill the demi-bosses for points!."));
		});
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
