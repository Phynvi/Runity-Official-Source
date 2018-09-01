package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility.SpawnData1;
import io.battlerune.game.world.entity.mob.player.Player;

public class GalvekCommandss implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		SpawnData1 galvekpos = GalvekUtility.spawn;
		Teleportation.teleport(player, galvekpos.getPosition());
		player.message("You have teleported to Galvek");
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
