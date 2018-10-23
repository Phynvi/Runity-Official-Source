package plugin.command.impl.player;

import io.battlerune.Config;
import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.Spellbook;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class AncientsCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		player.spellbook = Spellbook.ANCIENT;
		player.interfaceManager.setSidebar(Config.MAGIC_TAB, player.spellbook.getInterfaceId());
		player.sendMessage("You have switched your magics to ancients..");
		player.sendMessage("points="+player.getReferralPoints());

	}

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		return PlayerRight.isDeveloper(player);
	}

}
