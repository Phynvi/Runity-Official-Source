package io.battlerune.content.skill.impl.herblore;

import java.util.Arrays;

import io.battlerune.game.world.items.Item;

public enum UnfinishedPotion implements Potion {
	GUAM_POTION(91, 249, 1, 50.0), MARRENTILL_POTION(93, 251, 5, 75.0), TARROMIN_POTION(95, 253, 12, 100.0),
	HARRALANDER_POTION(97, 255, 22, 125.0), RANARR_POTION(99, 257, 30, 150.0), TOADFLAX_POTION(3002, 2998, 34, 175.0),
	SPIRIT_WEED_POTION(12181, 12172, 40, 200.0), IRIT_POTION(101, 259, 45, 225.0), WERGALI_POTION(14856, 14854, 1, 250.0),
	AVANTOE_POTION(103, 261, 50, 275.0), KWUARM_POTION(105, 263, 55, 300.0), SNAPDRAGON_POTION(3004, 3000, 63, 325.0),
	CADANTINE_POTION(107, 265, 66, 350.0), LANTADYME(2483, 2481, 69, 375.0), DWARF_WEED_POTION(109, 267, 72, 400.0),
	TORSTOL_POTION(111, 269, 78, 425.0);

	private final int product;
	private final Item[] ingredients;
	private final int level;
	public final double experience;

	UnfinishedPotion(int product, int ingredient, int level, double experience) {
		this.product = product;
		this.ingredients = new Item[] { new Item(227), new Item(ingredient) };
		this.level = level;
		this.experience = experience;
	}

	public static UnfinishedPotion get(Item use, Item with) {
		for (final UnfinishedPotion potion : values()) {
			if (potion.ingredients[0].equals(use) && potion.ingredients[1].equals(with)
					|| potion.ingredients[1].equals(use) && potion.ingredients[0].equals(with)) {
				return potion;
			}
		}
		return null;
	}

	@Override
	public int getAnimation() {
		return -1;
	}

	@Override
	public Item[] getIngredients() {
		return Arrays.copyOf(ingredients, ingredients.length);
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public Item getProduct() {
		return new Item(product);
	}
	
	@Override
	public double getExperience() {
		return experience;
	}

	@Override
	public String toString() {
		return "UnfinishedPotion[product: " + getProduct() + ", level: " + level + ", ingredients: "
				+ Arrays.toString(ingredients) + "]";
	}
}