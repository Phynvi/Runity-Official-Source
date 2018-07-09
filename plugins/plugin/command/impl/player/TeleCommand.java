package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;

public class TeleCommand implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		int x = Integer.parseInt(parts[1]);
		int y = Integer.parseInt(parts[2]);
		int z = Integer.parseInt(parts[3]);

		Teleportation.teleport(player, new Position(x, y, z));
		player.send(new SendMessage("You have teleported to : " + x + ":" + y + ":" + z));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
