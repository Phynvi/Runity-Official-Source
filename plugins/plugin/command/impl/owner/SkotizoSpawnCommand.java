package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.skotizo.SkotizoUtility;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * @author Adam_#6723r
 */

public class SkotizoSpawnCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		SkotizoUtility.generateSpawn();
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
