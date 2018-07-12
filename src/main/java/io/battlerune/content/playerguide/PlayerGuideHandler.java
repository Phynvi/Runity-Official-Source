package io.battlerune.content.playerguide;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

public class PlayerGuideHandler {

	/**
	 * Main Method, anything that is needed to appear on the interface should be
	 * called on here.
	 * 
	 * @param player
	 */
	public void open(Player player) {
		sendGuideNames(player);
		player.interfaceManager.open(56000);

	}

	/**
	 * Send's the strings to the interface.
	 * 
	 * @param player
	 */
	public void sendGuideNames(Player player) {
		for (int i = 0; i < PlayerGuideNames.values().length; i++) {
			player.send(new SendString(PlayerGuideNames.values()[i].name().replaceAll("_", " "), 56051 + i, true));
		}

	}
}
