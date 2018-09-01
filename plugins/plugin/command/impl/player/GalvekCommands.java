package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility.SpawnData1;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class GalvekCommands implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		SpawnData1 galvekpos = GalvekUtility.spawn;

		player.dialogueFactory.sendOption("@red@Teleport me [Wilderness]", () -> {

			if (galvekpos != null) {
				Teleportation.teleport(player, galvekpos.getPosition());
				player.message("You have teleported to Galvek");
			} else {
				player.send(new SendMessage("@red@There is currently no galvek event running!"));
			}

		}, "Cancel", () -> {

			player.dialogueFactory.clear();
		}).execute();
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
