package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;

public class TeleCommand implements Command {

	@Override
	public void execute(Player player, String[] parts) {

		Teleportation.teleport(player, new Position(Integer.parseInt(parts[1]),
				Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
		
		player.message("You have teleported to : " + parts[1] + " - " + parts[2] + " - " + parts[3]);
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
