package io.battlerune.content.preload;

import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.containers.equipment.Equipment;
import io.battlerune.game.world.items.containers.inventory.Inventory;

public enum PreLoadData implements PreLoadListener {

	MAXED_MELEE(-23029) {

		@Override
		public String getPreset() {
			return "126 Melee";
		}

		@Override
		public Item[] getEquipment() {
			return new Item[] { new Item(10828), new Item(1712), new Item(4355), new Item(4587), new Item(1127),
					new Item(8850), new Item(1079), new Item(3105), new Item(2250), new Item(7461) };
		}

		@Override
		public Item[] getInventory() {
			return new Item[] { new Item(12695), new Item(3024, 2), new Item(9075, 80), new Item(1215), new Item(3024),
					new Item(6685), new Item(560, 40), new Item(391, 3), new Item(557, 200), new Item(391, 12),
					new Item(3144, 3) };
		}

	};

	private int buttonId;

	PreLoadData(int buttonId) {
		this.buttonId = buttonId;
	}

	public int getButtonId() {
		return buttonId;
	}

}
