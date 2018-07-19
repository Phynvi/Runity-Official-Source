package plugin.command.impl.owner;

import io.battlerune.content.combat.cannon.CannonFireAction;
import io.battlerune.content.command.Command;
import io.battlerune.content.eventboss.EventBossHandler;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * @author Adam_#6723
 */

public class EventBossSystem implements Command {

	@Override
	public void execute(Player player, String[] command) {
		World.schedule(new EventBossHandler());
	}
	

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}

}
