package io.battlerune.content.presets;

import io.battlerune.game.world.items.containers.equipment.Equipment;
import io.battlerune.game.world.items.containers.inventory.Inventory;

public interface PresetListener {

	/**
	 * Preset name
	 * @return
	 */
	String getPreset();
	
	/**
	 * Equipment
	 * @return All Equipments for the selected preset
	 */
	Equipment[] getEquipment();
	
	/**
	 * 
	 * @return All Inventory items for the selected preset
	 */
	Inventory[] getInventory();
	
}
