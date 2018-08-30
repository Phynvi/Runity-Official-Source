package io.battlerune.content.presets;

import io.battlerune.game.world.items.containers.equipment.Equipment;
import io.battlerune.game.world.items.containers.inventory.Inventory;

public enum PresetData implements PresetListener {

	MAXED_MELEE {

		@Override
		public String getPreset() {
			return "126 Melee";
		}

		@Override
		public Equipment[] getEquipment() {
			return new Equipment[] {
			
			};
		}

		@Override
		public Inventory[] getInventory() {
			return new Inventory[] {
			
			};
		}
		
	};
}
