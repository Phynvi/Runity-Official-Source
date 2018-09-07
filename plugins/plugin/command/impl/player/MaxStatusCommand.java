package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class MaxStatusCommand implements Command {

	private enum TYPE { RANGE, MELEE };
	
	@Override
	public void execute(Player player, String command, String[] parts) {
		player.send(new SendMessage("Adam got hit, Melee: " + getHit(player, TYPE.MELEE)));
		player.send(new SendMessage("Adam got hit, Range: " + getHit(player, TYPE.RANGE)));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
	
	private int getHit(Player player, TYPE type) {
		switch(type) {
		case MELEE:
			return player.playerAssistant.getMaxHit(player, CombatType.MELEE);
		case RANGE:
			return player.playerAssistant.getMaxHit(player, CombatType.RANGED);	
		}
		return 0;
	}
}
