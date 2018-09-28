package io.battlerune.content.upgrading;

import io.battlerune.game.world.items.Item;

/**
 * Upgrade Data Storage
 * @author Nerik#8690
 *
 */
public enum UpgradeData {

	LIME_WHIP(new Item(21225, 1), new Item(21292, 1), new Item(21820, 500), 0.25);
	
	private Item item_input, item_reward, etharRequirement;
	private double chance;

	UpgradeData(Item item_input, Item item_reward, Item etharRequirement, double chance) {
		this.item_input = item_input;
		this.item_reward = item_reward;
		this.etharRequirement = etharRequirement;
		this.chance = chance;
	}

	public Item getItemInput() {
		return item_input;
	}

	public Item getItemReward() {
		return item_reward;
	}

	public Item getEtharRequirement() {
		return etharRequirement;
	}

	public double getChance() {
		return chance;
	}
	
	public static Item[] ITEMS = new Item[] {LIME_WHIP.getItemReward()};

}
