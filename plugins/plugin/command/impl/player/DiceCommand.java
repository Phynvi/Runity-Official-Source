package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.clanchannel.channel.ClanChannelHandler;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class DiceCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
		 Teleportation.teleport(player, Config.DICE_ZONE, 20, () -> {
             player.send(new SendMessage("@or2@Welcome to Gamble, " + player.getName() + "!"));
             player.send(new SendMessage("@red@Make sure you record at ALL times"));
             player.send(new SendMessage("@red@No refunds will be given out without any kind of video proof"));
             ClanChannelHandler.connect(player, "Dice");
             player.message("You've attempted to join Dice clan chat.");
             
		 });
	}

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
