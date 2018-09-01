package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishementData;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishment;

public class BanCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		String name = parts[1].replaceAll("_", " ");

		World.search(name.toString()).ifPresent(other -> {
			new PlayerPunishment(other, PlayerPunishementData.BAN).execute();
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
