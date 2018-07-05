package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendURL;

public class DiscordCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		player.send(new SendURL("https://discord.gg/mjgpDZN"));
		player.send(new SendMessage("Launching Runity Discord."));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
