package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class SaveAll implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		World.save();
		World.sendMessage("[SAVE] You're player files have been safely saved, this is to prevent rollbacks.");
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
