package io.battlerune.content.freeforall.impl;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class FreeForAllLobbyTask {

	protected Player player;

	public FreeForAllLobbyTask(Player player) {
		this.player = player;
	}

	public void execute() {
		if(getRestrictions()) {
			return;
		}
	}

	private boolean getRestrictions() {
		if(player.inventory.getFreeSlots() < 28) {
			player.send(new SendMessage("@red@ You are not allowed to bring in any items!"));
			return false;
		}
		if(player.equipment.getFreeSlots() < 14) {
			player.send(new SendMessage("@red@ You are not allowed to bring in any equipment!"));
			return false;
		}
		return true;
	}
}
