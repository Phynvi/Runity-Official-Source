package plugin.command.impl.moderator;

import io.battlerune.content.activity.impl.JailActivity;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishementData;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishment;

/**
 * 
 * @author Adam_#6723
 *
 */

public class JailCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1].replaceAll("_", " "));

		World.search(name.toString()).ifPresent(other -> {
			JailActivity.create(other);
			new PlayerPunishment(other, PlayerPunishementData.JAIL).execute();
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
