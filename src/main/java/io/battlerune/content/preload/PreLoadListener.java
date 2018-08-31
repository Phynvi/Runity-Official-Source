package io.battlerune.content.preload;

import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.containers.equipment.Equipment;
import io.battlerune.game.world.items.containers.inventory.Inventory;

public interface PreLoadListener {

	/**
	 * Preset name
	 * @return
	 */
	String getPreset();
	
	/**
	 * Equipment
	 * @return All Equipments for the selected preset
	 */
	Item[] getEquipment();
	
	/**
	 * 
	 * @return All Inventory items for the selected preset
	 */
	Item[] getInventory();
	
}
