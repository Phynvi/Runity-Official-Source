package io.battlerune.content.freeforall.impl;

import io.battlerune.content.freeforall.FreeForAll;
import io.battlerune.content.freeforall.FreeForAllType;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendFadeScreen;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendMinimapState;
import io.battlerune.net.packet.out.SendMinimapState.MinimapState;
import io.battlerune.util.Utility;

public class FreeForAllLobbyTask {

	protected Player player;

	public FreeForAllLobbyTask(Player player) {
		this.player = player;
	}

	private Position[] location = {new Position(3323, 4948, 0), new Position(3323, 4970, 0)};
	
	public void execute() {
		if (!getRestrictions()) {
			return;
		}

		player.send(new SendFadeScreen("You are teleporting to Free For All!", 1, 4));
		player.send(new SendMinimapState(MinimapState.HIDDEN));
		World.schedule(4, () -> {
			Teleportation.teleport(player, new Position(3292, 4958, 0));
			player.send(new SendMinimapState(MinimapState.NORMAL));
			player.send(new SendMessage("Welcome to the Free For All lobby!"));
			FreeForAll.KEY_MAP.putIfAbsent(player, FreeForAllType.LOBBY);
			FreeForAll.lobbyCount++;
			player.interfaceManager.openWalkable(23111);

		});

	}

	private boolean getRestrictions() {
		if (FreeForAll.gameStarted) {
			player.send(new SendMessage("@red@ There is currently a game running!"));
			return false;
		}
		if (player.inventory.getFreeSlots() < 28) {
			player.send(new SendMessage("@red@ You are not allowed to bring in any items!"));
			return false;
		}
		if (player.equipment.getFreeSlots() < 14) {
			player.send(new SendMessage("@red@ You are not allowed to bring in any equipment!"));
			return false;
		}
		return true;
	}
}
