package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishment;
import io.battlerune.net.packet.out.SendMessage;

public class IpmuteCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = parts[1].replaceAll("_", " ");

		World.search(name.toString()).ifPresent(other -> {
			if (PlayerPunishment.IPBanned(other.lastHost)) {
				player.send(new SendMessage("Player " + other.getUsername() + " already has an active ip mute."));
				return;
			}

			PlayerPunishment.addToFile("./data/content/punishements/IPMutes.txt", other.lastHost);
			World.kickPlayer(other.getUsername());
			player.send(new SendMessage("@red@Player " + other.getUsername() + " has been ip muted!"));
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
