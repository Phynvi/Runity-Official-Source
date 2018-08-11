package io.battlerune.content.eventboss;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.battlerune.game.task.Task;
import io.battlerune.game.world.World;

public class EventBossManager extends Task {

	public EventBossManager() {
		super(1);
	}

	public static Map<String, EventBoss> event = new HashMap<>();

	public static void put(String key, EventBoss value) {
		if (!event.containsKey(key)) {
			event.put(key, value);
		}
	}

	@Override
	protected void execute() {

	}

	public static void start(String key, int timer) {
		if (event.containsKey(key)) {
			World.getPlayers().forEach(player -> {
				if (player != null) {
					player.sendTeleportButton();
					for (Entry<String, EventBoss> data : event.entrySet()) {
						player.sendTeleportButtonNpc(data.getValue().getNpcId());
					}
				}
			});
		}
	}
}
