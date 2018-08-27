package io.battlerune.content.eventboss;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.battlerune.game.world.World;

/**
 * Event boss manager
 * 
 * @author Nerik#8690
 *
 */
public class EventBossManager {

	private static Map<String, EventBoss> event = new HashMap<>();

	private static void put(String key, EventBoss value) {
		if (!event.containsKey(key)) {
			event.put(key, value);
		}
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
