package plugin.command.impl.player;

import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;

public class AdamIndianTeleporter {
	public static void adamindianteleporter(Player player, int x, int y, int z) {
		Teleportation.teleport(player, new Position(x, y, z));
		player.send(new SendMessage("You have teleported to Tier 1!"));
	}
}
