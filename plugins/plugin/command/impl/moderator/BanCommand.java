package plugin.command.impl.moderator;

import java.util.Optional;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.punishments.PunishmentExecuter;
import io.battlerune.net.packet.out.SendMessage;

public class BanCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String playerToBan = String.format(parts[1].replaceAll("_", " "));

		Optional<Player> toBan = World.search(playerToBan.toString());
		
		if(toBan.isPresent()) {
			if (PunishmentExecuter.banned(toBan.get().getUsername())) {
				player.send(new SendMessage("Player " + toBan.get().getUsername() + " already has an active ban."));
				return;
			}
			PunishmentExecuter.ban(toBan.get().getUsername());
			player.send(new SendMessage("Player " + toBan.get().getUsername() + " was successfully banned"));
			World.kickPlayer(toBan.get().getUsername());
		} else {
			
		}
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
