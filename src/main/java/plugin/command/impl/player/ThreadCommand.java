package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendURL;

/**
 * @author Teek
 * 
 * 9/13/2018 <01:28am>
 */
public class ThreadCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		System.out.println(command+" "+parts[0]);
		try {
			String url = "http://runity.io/forums/index.php?showtopic=" + String.valueOf(parts[1]);
			player.send(new SendURL(url));
			player.sendMessage("Opening URL: <col=0000ff>"+url);
		} catch (Exception e) {
			player.sendMessage("Failed to execute command.. trying using ::thread id");
		}
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
