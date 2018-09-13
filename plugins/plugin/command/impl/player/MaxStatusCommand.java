package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class MaxStatusCommand implements Command {
	
	@Override
	public void execute(Player player, String command, String[] parts) {
		player.sendMessage("Your Max Hits below...");
		player.send(new SendMessage("Melee: " + getHit(player, CombatType.MELEE)));
		player.send(new SendMessage("Range: " + getHit(player, CombatType.RANGED)));
		player.send(new SendMessage("Magic: " + getHit(player, CombatType.MAGIC)));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
	
	private int getHit(Player player, CombatType type) {
		return player.playerAssistant.getMaxHit(player, type);	
	}
}
