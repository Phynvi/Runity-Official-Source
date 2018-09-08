package io.battlerune.content.freeforall;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.battlerune.content.freeforall.impl.FreeForAllTask;
import io.battlerune.game.task.Task;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * Free For All Main File
 * @author Nerik#8690
 *
 */
public class FreeForAll extends Task {

	private int tick;

	public FreeForAll() {
		super(1);
		this.tick = 0;
	}

	@Override
	protected void execute() {
		switch (tick) {
		case 1800:
			World.sendMessage("Free for all is starting");
			break;
		}
		tick++;
	}

	private void appendTask(FreeForAllTask task, FreeForAllType type) {
		KEY_MAP.keySet().forEach(player -> {
			if (player != null) {
				if (task != null) {
					if (KEY_MAP.get(player).equals(type)) {
						task.execute(player);
					}
				}
			}
		});
	}

	private Map<Player, FreeForAllType> KEY_MAP = new HashMap<Player, FreeForAllType>();
}
