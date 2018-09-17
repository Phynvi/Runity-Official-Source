package io.battlerune.content.freeforall.impl;

import io.battlerune.content.freeforall.FreeForAll;
import io.battlerune.content.freeforall.FreeForAllType;
import io.battlerune.game.world.entity.mob.player.Player;

public class FreeForAllEndTask implements FreeForAllTask {

	@Override
	public void execute(Player player, String content) {
		if (FreeForAll.gameCount == 1) {
			FreeForAll.KEY_MAP.keySet().forEach(mob -> {
				if (mob != null) {
					if (FreeForAll.KEY_MAP.get(mob).equals(FreeForAllType.GAME)) {
						new FreeForAllLeaveTask(mob, "end").execute();
					}
				}
			});
		}
	}
}
