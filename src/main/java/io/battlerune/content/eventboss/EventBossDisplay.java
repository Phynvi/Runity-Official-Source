package io.battlerune.content.eventboss;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

/**
 * Idea is to display
 * @author Adam_#6723
 *
 */

public class EventBossDisplay {
	
	
	public static void display(Player player) {
		//Text content display
		for(EventBossData data : EventBossData.values()) {
		for (int i = 0; i < data.getContent().length; i++) {
			player.send(new SendString(data.getnpcName(), 45604, true));
			player.send(new SendString(data.getContent()[i], 45605 + i, true));
			if(i > 45617) {
				return;
			}
		}
	  }
	}


}
