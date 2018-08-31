package io.battlerune.content.presets;

import io.battlerune.game.world.items.Item;

public class Preset {

	protected String name;
	protected Item[] equipment;
	protected Item[] inventory;

	public Preset(String name, Item[] equipment, Item[] inventory) {
		this.name = name;
		this.equipment = equipment;
		this.inventory = inventory;
	}
	
	public String getName() {
		return name;
	}

	public Item[] getEquipment() {
		return equipment;
	}

	public Item[] getInventory() {
		return inventory;
	}
}
