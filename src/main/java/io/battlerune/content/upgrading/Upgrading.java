package io.battlerune.content.upgrading;

import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.util.Utility;

/**
 * 
 * @author Adam_#6723 
 * The main class which handles upgrading.
 * TODO Assign this method onto an interface accordingly.
 */

public class Upgrading {
	
	public static void Upgrade(Player player) {
		DialogueFactory factory = new DialogueFactory(player);

		for(UpgradingData data : UpgradingData.values()) {
			if(!player.inventory.contains(data.getId())) {
				factory.sendNpcChat(6766, "");
				player.message("You do not have any item's to updgrade.");
				return;
			 }
			if(!player.inventory.contains(data.getPointsid(), data.getPointsrequired())) {
				player.message("You do not have any ether to updgrade.");
				return;
			}
		  if(Utility.random(1, 5000) <= 1) {
			  player.inventory.remove(data.getId(), 1);
			  player.inventory.remove(data.getPointsid(), data.getPointsrequired());
			  player.inventory.add(data.getUpgradedId(), 1);
			  player.message("You have been extremely lucky!!");
			  World.sendMessage(player.getName() + " Has been lucky and successfully upgraded their " + data.getItemname() + "!");
			  return;
		   } 
			   player.inventory.remove(data.getId(), 1);
			   player.inventory.remove(data.getPointsid(), data.getPointsrequired());
			   player.message("You have been unlucky on this occasion! and failed to upgrade " + data.getItemname() + "!");
		 
		}		
	}
	
	public static void NpcDialouge(DialogueFactory factory) {
		
	}
}
