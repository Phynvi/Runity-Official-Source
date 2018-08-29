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
public class PortalsZoneCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		Teleportation.teleport(player, Config.PORTAL_ZONE);
		player.send(new SendMessage("You have teleported to the Portal Zone!"));
	}

	@Override
	public boolean canUse(Player player) {
		return (PlayerRight.isDonator(player) || PlayerRight.isKing(player) || PlayerRight.isSupreme(player) || PlayerRight.isExtreme(player)
				|| PlayerRight.isElite(player) || PlayerRight.isDeveloper(player));
	}

}
