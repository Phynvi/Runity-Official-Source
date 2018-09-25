package io.battlerune.content.upgrading;

import io.battlerune.game.world.items.Item;

public enum Upgrade {

	ABYSSAL_WHIP(new Item[] {new Item(995, 50_000), new Item(4151, 1)}, new Item(1, 1), 0.25),
	LIME_WHIP(new Item[] {new Item(21225, 1), new Item(21292, 1)}, new Item(21820, 500), 0.25);

	private Item[] items;
	private Item etharRequirement; 
	private double chance;

	Upgrade(Item[] items, Item etharRequirement, double chance) {
		this.items = items;
		this.etharRequirement = etharRequirement;
		this.chance = chance;
	}

	public Item[] getReward() {
		return items;
	}

	public Item getEtharRequirement() {
		return etharRequirement;
	}
	
	public double getChance() {
		return chance;
	}

}
