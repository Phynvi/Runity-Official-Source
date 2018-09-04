package plugin.command.impl.moderator;

import io.battlerune.content.activity.impl.JailActivity;
import io.battlerune.content.command.Command;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishementData;
import io.battlerune.game.world.entity.mob.player.requests.PlayerPunishment;
import io.battlerune.net.packet.out.SendInputMessage;
import io.battlerune.net.packet.out.SendMessage;

public class BanCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = parts[1].replaceAll("_", " ");
		
		World.search(name.toString()).ifPresent(other -> {
			if (PlayerPunishment.banned(other.getUsername())) {
				player.send(new SendMessage("Player " + other + " already has an active ban."));
	            return;
	        }
			
			PlayerPunishment.addToFile("./data/content/punishements/Bans.txt", other.getUsername());
			World.kickPlayer(other.getUsername());
			PlayerPunishment.init();
			player.send(new SendMessage("@red@Player " + other + " has been banned!"));
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
