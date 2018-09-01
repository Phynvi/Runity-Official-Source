package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class Unbancommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		StringBuilder name = new StringBuilder(parts[0].replaceAll("_", " "));


		World.search(name.toString()).ifPresent(other -> {
			//other.punishment.unBan();
			player.message("@red@Player has been unbanned");
		});

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
