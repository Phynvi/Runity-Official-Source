package io.battlerune.content.preload;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

public class PreLoadManager {

	private Player player;
	private PreLoadData preload;

	public PreLoadManager(Player player, PreLoadData preload) {
		this.player = player;
		this.preload = preload;
	}

	public Player getPlayer() {
		return player;
	}

	public PreLoadData getPreload() {
		return preload;
	}

	public boolean getRequirements() {
		if (!getPlayer().bank.contains(new Item(995, 100_000))) {
			getPlayer().send(new SendMessage("You don't have 100K (100,000) in your bank!"));
			return false;
		}
		if (!getPlayer().inventory.isEmpty()) {
			getPlayer().send(new SendMessage("Please bank all your inventory items!"));
			return false;
		}
		if (!getPlayer().equipment.isEmpty()) {
			getPlayer().send(new SendMessage("Please bank all your equipment!"));
			return false;
		}
		return true;
	}

	public void execute() {
		getPlayer().dialogueFactory.sendOption("Spawn preload [100K]", () -> {
			spawn();
		}, "Cancel", () -> {
			player.dialogueFactory.clear();
		}).execute();
	}

	private void spawn() {
		if (!getRequirements()) {
			return;
		}

		player.inventory.remove(new Item(995, 100_000));
		
		player.equipment.manualWearAll(getPreload().getEquipment());
		
		for (int i = 0; i < getPreload().getInventory().length; i++) {
			player.inventory.add(getPreload().getInventory()[i]);
		}

		player.equipment.refresh();
		player.inventory.refresh();
		
		player.send(new SendMessage("You have succesfully spawned a preload!"));
	}
}
