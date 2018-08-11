package plugin.command.impl.donator;

import io.battlerune.content.Yell;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */
public class DonatorYellCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		try {
			final String message = String.format(command[1]);
			Yell.yell(player, message.toString().trim());
		} catch (final Exception e) {
			player.send(new SendMessage("@or2@Invalid yell format, syntax: -messsage"));
		}
	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDonator(player) || PlayerRight.isSuper(player) || PlayerRight.isExtreme(player)
				|| PlayerRight.isElite(player) || PlayerRight.isKing(player) || PlayerRight.isSupreme(player)) {
			return true;
		} else {
			player.speak("I just tried to do something silly!");
			return false;
		}
	}

}
