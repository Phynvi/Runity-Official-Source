package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class ArenaZoneCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
        Teleportation.teleport(player, Config.ARENA_ZONE, 20, () -> {
   		// player.send(new SendFadeScreen("@or2@Entering The Arena Lair!", 1, 3));
            player.send(new SendMessage("Welcome To The Arena Zone, " + player.getName() + "!"));
        });
    }


	

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
}
        
