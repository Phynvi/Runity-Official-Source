package plugin.command.impl.owner;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class NpcCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		int id = Integer.parseInt(parts[1]);
		Npc npc = new Npc(id, player.getPosition(), Config.NPC_WALKING_RADIUS);
		npc.walk = false;
		npc.register();

		if (id == 3080) {
			npc.skills.setNpcMaxLevel(3, 99_999);
			npc.locking.lock();
		}
		if (id == 2267 || id == 2266 || id == 2265) {
			npc.locking.lock();
		}
		if (id == 2075) {
			npc.skills.setNpcMaxLevel(3, 800);
		}
		player.send(new SendMessage("Npc " + id + " has been spawned."));

	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
