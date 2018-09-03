package plugin.command.impl.donator;

import io.battlerune.content.command.Command;
import io.battlerune.content.store.Store;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.position.Area;

/**
 * @author Adam_#6723
 */

public class SponsorStoreCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		if (Area.inWilderness(player) && (!PlayerRight.isDeveloper(player)) || player.getCombat().inCombat()) {
			player.message("You cannot open the store in the wilderness.");
		} else {
			Store.STORES.get("Sponsor Store").open(player);
		}
	}

	@Override
	public boolean canUse(Player player) {
		return (PlayerRight.isDonator(player) || PlayerRight.isKing(player) || PlayerRight.isSupreme(player) || PlayerRight.isExtreme(player)
				|| PlayerRight.isElite(player) || PlayerRight.isDeveloper(player));

	}

}
