package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class RevenantCaveCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		if (player.pet != null) {
			player.dialogueFactory
					.sendNpcChat(player.pet.id, "I'm sorry #name,", "but I can not enter the wilderness with you!")
					.execute();
			return;
		}
		if(player.inventory.containsAny(Config.NOT_ALLOWED) || player.equipment.containsAny(Config.NOT_ALLOWED)) {
			player.message("@red@You can no longer take custom's into the wilderness!");
			return;
		}
		player.dialogueFactory.sendOption("@red@Teleport me [Wilderness]", () -> {

				Teleportation.teleport(player, Config.REV_CAVES);
				player.message("You have teleported to Revenant Caves");

		}, "Cancel", () -> {

			player.dialogueFactory.clear();
		}).execute();
	}
	

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
