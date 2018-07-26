package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;



/**
 * 
 * @author Adam_#6723
 *
 */

public class StaffZoneCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
        Teleportation.teleport(player, new Position(2602, 3874, 0));
        player.send(new SendMessage("@or2@Welcome to the staffzone, " + player.getName() + "."));
      }

      

	
	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isManagement(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}

}
