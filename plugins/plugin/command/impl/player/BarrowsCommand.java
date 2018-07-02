package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class BarrowsCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		Teleportation.teleport(player, Config.BARROWS, 20, () -> {
            player.send(new SendMessage("@or2@Welcome to Barrows, " + player.getName() + "!"));
            player.send(new SendMessage("@red@Goodluck with grinding!"));
       });
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
