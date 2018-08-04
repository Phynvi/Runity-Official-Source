package plugin.command.impl.donator;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */
public class DZoneCommand implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		// TODO Auto-generated method stub
		Teleportation.teleport(player, Config.DONATOR_ZONE);
		player.send(new SendMessage("You have teleported to the Donator Zone!"));
	}

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		if (PlayerRight.isDonator(player)) {
			return true;
		}
		player.speak("I just tried to do something silly!");
		return false;
	}

}
