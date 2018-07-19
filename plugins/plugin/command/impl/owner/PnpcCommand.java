package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.npc.definition.NpcDefinition;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendInputMessage;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.MessageColor;

/**
 * @author Adam_#6723
 */

public class PnpcCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		final String message = "That player was not valid, please re-select a player.";

		player.send(new SendInputMessage("Enter id", 10, input -> {
			if (player != null) {
				player.playerAssistant.transform(Integer.parseInt(input));
			}
			player.send(new SendMessage(
					player == null ? message
							: "You have turned " + player.getName() + " into "
									+ NpcDefinition.get(Integer.parseInt(input)).getName() + ".",
					MessageColor.DARK_BLUE));
		}));

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
