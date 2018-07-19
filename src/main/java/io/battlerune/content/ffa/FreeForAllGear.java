package io.battlerune.content.ffa;

import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.containers.equipment.EquipmentType;

/**
 * Handles the storing of the free for all setups
 * 
 * @author Harryl / Nerik#8690
 *
 */
public enum FreeForAllGear {

	DHAROK(new int[][] { { EquipmentType.WEAPON.getSlot(), 4151, 1 } }, new Item[] { new Item(1, 1) }),

	HYBRID(new int[][] { { EquipmentType.WEAPON.getSlot(), 4151, 1 } }, new Item[] { new Item(1, 1) });

	private int[][] gear;
	private Item[] inventory;

	FreeForAllGear(int[][] gear, Item[] inventory) {
		this.gear = gear;
		this.inventory = inventory;
	}

	public int[][] getGear() {
		return gear;
	}

	public Item[] getInventory() {
		return inventory;
	}

}
