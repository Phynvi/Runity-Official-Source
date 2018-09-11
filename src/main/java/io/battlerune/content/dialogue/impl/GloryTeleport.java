package io.battlerune.content.dialogue.impl;

import io.battlerune.content.dialogue.*;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.containers.equipment.Equipment;

/**
 * 
 * @author Teek
 *
 * 9/11/2018 - 08:39am
 */
public class GloryTeleport extends Dialogue {

	private Player player;
	
	private int itemId;
	
	private boolean fromNecklas;
	
	
	
	public GloryTeleport(Player player, int itemId, boolean fromNecklas) {
		this.player = player;
		this.itemId = itemId;
		this.fromNecklas = fromNecklas;
	}

	@Override
	public void sendDialogues(DialogueFactory factory) {
		factory.sendOption("Edgeville", null, "Karamja", null);
	}
	
	private void handle() {
		Item neck = player.equipment.get(Equipment.AMULET_SLOT);
		//TODO
		if (fromNecklas) {
		   if (neck != null) {
			   if (neck.getId() > 1704)
			       neck.setId(neck.getId() - 2);
		   }
		}
	}
}