package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.punishments.PunishmentExecuter;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class MuteCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1].replaceAll("_", " "));

		World.search(name.toString()).ifPresent(other -> {
			if (PunishmentExecuter.muted(other.getUsername())) {
				player.send(new SendMessage("Player " + other.getUsername() + " already has an active mute."));
				return;
			}
			PunishmentExecuter.mute(other.getUsername());
			player.send(new SendMessage("Player " + other.getUsername() + " was successfully muted."));
			World.kickPlayer(other.getUsername());
			player.send(new SendMessage("You have been muted by " + player.getUsername() + "."));
		});

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
