package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;

public class Commands implements Command {

	@Override
	public void execute(Player player, String[] command) {
       player.message("Beta Spawn commands");
       player.message("::find ITEMNAME (Example: ::find dragon");
       player.message("::item ITEMID ITEMAMOUNT(Example: ::item 12 200");
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
