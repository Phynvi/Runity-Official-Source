package plugin.command.impl.donator;

import io.battlerune.content.activity.impl.allvsone2.AllVsOne2;
import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class DZoneCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		//Teleportation.teleport(player, Config.DONATOR_ZONE);
		//player.send(new SendMessage("You have teleported to the Donator Zone!"));
		AllVsOne2.create(player);
	}

	@Override
	public boolean canUse(Player player) {
		return (PlayerRight.isDonator(player) || PlayerRight.isKing(player) || PlayerRight.isSupreme(player) || PlayerRight.isExtreme(player)
				|| PlayerRight.isElite(player) || PlayerRight.isDeveloper(player));
	}

}
