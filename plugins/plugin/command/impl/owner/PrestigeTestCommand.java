package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.content.prestige.Prestige;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class PrestigeTestCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		Prestige prestige = new Prestige(player);
		
	if(player.skills.isMaxed()) {
	}

	}
	

	

	@Override
	public boolean canUse(Player player) {
		if(PlayerRight.isDeveloper(player)) {
		return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}
}
