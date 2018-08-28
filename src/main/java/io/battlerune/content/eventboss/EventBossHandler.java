package io.battlerune.content.eventboss;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendString;

/**
 * Handles displaying the given npc data
 * @author Nerik#8690
 * 
 */

public class EventBossHandler {

	private Player player;
	private int npcId;

	public EventBossHandler(Player player, int npcId) {
		this.player = player;
		this.npcId = npcId;
	}

	public void display() {
		if (player.interfaceManager.isClear()) {
			for (EventBossData data : EventBossData.values()) {
				if (data.getNpcId() == npcId) {
					World.sendTeleportButton();
					World.sendTeleportButtonNpc(data.getNpcId());
					for (int i = 0; i < data.getContent().length; i++) {
						player.send(data.getContent()[i]);
					}
				}
			}
		}
	}

}