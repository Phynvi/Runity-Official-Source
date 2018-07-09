package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;
/**
 * 
 * @author Jordan
 *
 */
public class Tier4Teleport implements Command {

	@Override
	public void execute(Player player, String[] parts) {
		// TODO Auto-generated method stub
		Teleportation.teleport(player, Config.TIER_4_ZONE);
		player.send(new SendMessage("You have teleported to Tier 4!"));
	}

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		return true;
	}

}
