package io.battlerune.content.halloffame;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendString;

/**
 * Handles displaying the users on the interface
 * 
 * @author hamza
 *
 */
public class FameBoardInterface {

	public static void open(FameBoard type, Player player) {
		player.interfaceManager.open(58500);
		switch (type) {

		case PVP:
			for (int index = 0; index < 80; index += 4) {
				for (int i = 0; i < PlayerKillingBoard.player.size(); i++) {
					player.send(new SendString(PlayerKillingBoard.player.get(i).getRights(), 58532 + (index + 1)));
					player.send(
							new SendString(PlayerKillingBoard.player.get(i).getUsername(), 58532 + (index + 2)));
					player.send(new SendString(PlayerKillingBoard.player.get(i).getKills(), 58532 + (index + 3)));
				}
			}
			break;
		case MISC:
			for(int i = 0; i < PlayerKillingBoard.player.size(); i++) {
 					player.message("["+i+"]Data - " + PlayerKillingBoard.player.get(i).getRights() + 
 							" : " + PlayerKillingBoard.player.get(i).getUsername() + " : " + PlayerKillingBoard.player.get(i).getKills());
			}
			break;
		default:
			break;
		}
	}
}
