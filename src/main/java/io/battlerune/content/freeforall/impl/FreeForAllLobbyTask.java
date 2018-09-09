package io.battlerune.content.freeforall.impl;

import io.battlerune.content.freeforall.FreeForAll;
import io.battlerune.content.freeforall.FreeForAllType;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;

public class FreeForAllLobbyTask {

	
	protected Player player;

	public FreeForAllLobbyTask(Player player) {
		this.player = player;
	}

	public void execute() {
		if(!getRestrictions()) {
			return;
		}
		
		Teleportation.teleport(player, new Position(1, 1, 1));
		player.send(new SendMessage("Welcome to the Free For All lobby!"));
		FreeForAll.KEY_MAP.putIfAbsent(player, FreeForAllType.LOBBY);
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
