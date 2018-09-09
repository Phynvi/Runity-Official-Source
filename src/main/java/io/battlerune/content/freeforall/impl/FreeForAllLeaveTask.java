package io.battlerune.content.freeforall.impl;

import io.battlerune.Config;
import io.battlerune.content.freeforall.FreeForAll;
import io.battlerune.content.freeforall.FreeForAllType;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

public class FreeForAllLeaveTask {

	
	private Player player;
	private String type;

	public FreeForAllLeaveTask(Player player, String type) {
		this.player = player;
		this.type = type;
	}

	public void execute() {
		switch (type) {

		case "lobby":
			FreeForAll.KEY_MAP.remove(player, FreeForAllType.LOBBY);
			reset();
			Teleportation.teleport(player, Config.DEFAULT_POSITION);
			player.send(new SendMessage("You have left the Free For All lobby!"));
			break;
		case "game":
			player.send(new SendMessage("You can't do this right now!"));
			break;
		case "logout":
			FreeForAll.KEY_MAP.remove(player);
			reset();
			Teleportation.teleport(player, Config.DEFAULT_POSITION);
			break;
		case "death":
			FreeForAll.KEY_MAP.remove(player, FreeForAllType.GAME);
			reset();
			Teleportation.teleport(player, Config.DEFAULT_POSITION);
			player.send(new SendMessage("You have lost the Free For All game!"));
			break;
		case "end":
			FreeForAll.KEY_MAP.remove(player, FreeForAllType.GAME);
			reset();
			Teleportation.teleport(player, Config.DEFAULT_POSITION);
			player.send(new SendMessage("You have won the free for all game!"));
			World.sendMessage("[Free For All] " + player.getUsername() + " has won the free for all game!");
			player.inventory.add(new Item(995, 10000));
			break;
		}
	}

	private void reset() {
		player.equipment.clear();
		player.inventory.clear();
		player.equipment.refresh();
		player.inventory.refresh();
	}
}
