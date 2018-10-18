package io.battlerune.content.upgrading;

import io.battlerune.game.world.items.Item;

/**
 * Upgrade Data Storage
 * @author Nerik#8690
 * @edited Adam_#6723
 *
 */
public enum UpgradeData {

	LIME_WHIP(new Item(21225, 1), new Item(21292, 1), new Item(21820, 500), 0.10),
	ICE_KATANA(new Item(3273, 1), new Item(21294, 1), new Item(21820, 200), 0.35),
	SAMURAI_HELM(new Item(20035, 1), new Item(20049, 1), new Item(21820, 250), 0.35),
	SAMURAI_PLATE(new Item(20038, 1), new Item(13284, 1), new Item(21820, 250), 0.35),
	SAMURAI_LEGS(new Item(20044, 1), new Item(20058, 1), new Item(21820, 250), 0.35),
	SAMURAI_BOOTS(new Item(20047, 1), new Item(20061, 1), new Item(21820, 250), 0.35),
	SAMURAI_GLOVES(new Item(20041, 1), new Item(20055, 1), new Item(21820, 250), 0.35),
	ELITE_SS(new Item(13719, 1), new Item(13722, 1), new Item(21820, 250), 0.35),
	MAGMA_AXE(new Item(13687, 1), new Item(13833, 1), new Item(21820, 300), 0.25),
	GLAIVE(new Item(11063, 1), new Item(17160, 1), new Item(21820, 500), 0.25),
	PHOENIX_BOW(new Item(3274, 1), new Item(13831, 1), new Item(21820, 500), 0.25),
	LAVABOW(new Item(13831, 1), new Item(13749, 1), new Item(21820, 500), 0.10),
	
	BRONZE_MBOX(new Item(6199, 1), new Item(12955, 1), new Item(21820, 200), 0.50),
	SILVER_MBOX(new Item(12955, 1), new Item(11739, 1), new Item(21820, 250), 0.40),
	GOLD_MBOX(new Item(11739, 1), new Item(6508, 1), new Item(21820, 300), 0.25),
	ALLVSONE2(new Item(290, 1), new Item(6833, 1), new Item(21820, 350), 0.25),
	ALLVSONE3(new Item(6833, 1), new Item(6830, 1), new Item(21820, 400), 0.10),
	;

	
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
	
	public static Item[] ITEMS = new Item[] {
			LIME_WHIP.getItemReward(), 
			ICE_KATANA.getItemReward(),
			SAMURAI_HELM.getItemReward(),
			SAMURAI_PLATE.getItemReward(),
			SAMURAI_LEGS.getItemReward(),
			SAMURAI_BOOTS.getItemReward(),
			SAMURAI_GLOVES.getItemReward(),
			MAGMA_AXE.getItemReward(),
			GLAIVE.getItemReward(),
			ELITE_SS.getItemReward(),
			PHOENIX_BOW.getItemReward(),
			LAVABOW.getItemReward(),
			BRONZE_MBOX.getItemReward(),
			SILVER_MBOX.getItemReward(),
			GOLD_MBOX.getItemReward(),
			ALLVSONE2.getItemReward(),
			ALLVSONE3.getItemReward(),
	};

}
