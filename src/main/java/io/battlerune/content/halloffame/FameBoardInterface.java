package io.battlerune.content.halloffame;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

/**
 * Handles displaying the users on the interface
 * @author hamza
 *
 */
public class FameBoardInterface {

	public static void open(FameBoard type, Player player) {
		player.interfaceManager.open(58500);
		switch (type) {

		case PVP:
			for (int index = 0; index < PlayerKillingBoard.player.size(); index += 4) {
				player.send(new SendString(PlayerKillingBoard.player.get(index).right, 58532 + (index + 1)));
				player.send(new SendString(PlayerKillingBoard.player.get(index).getUsername(), 58532 + (index + 2)));
				player.send(new SendString(PlayerKillingBoard.player.get(index).kill, 58532 + (index + 3)));
			}
			break;
		default:
			break;
		}
	}
}
