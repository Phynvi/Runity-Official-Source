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

public class UnmuteCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1].replaceAll("_", " "));
		
		World.search(name.toString()).ifPresent(other -> {
				if (!PunishmentExecuter.muted(other.getUsername())) {
					player.send(new SendMessage("Player " + other.getUsername() + " is not muted!"));
					return;
				}
				PunishmentExecuter.unmute(other.getUsername());
				player.send(new SendMessage("Player " + other.getUsername() + " was successfully unmuted."));
				other.send(new SendMessage("@red@ You have been unmuted by " + player.getUsername()));
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
