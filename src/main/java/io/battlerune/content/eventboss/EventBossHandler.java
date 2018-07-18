package io.battlerune.content.eventboss;

import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility;
import io.battlerune.game.world.entity.mob.player.Player;

public class EventBossHandler {
	
	
	public static void showBoss(Player player) {
		if(GalvekUtility.activated == true) {
			EventBossDisplay.display(player);
			player.sendTeleportButton();
		}

	}

}
