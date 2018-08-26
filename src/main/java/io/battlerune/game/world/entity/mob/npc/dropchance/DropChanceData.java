package io.battlerune.game.world.entity.mob.npc.dropchance;

/**
 * 
 * @author Nerik 
 *
 */


public enum DropChanceData {

	RING_OF_WEALTH(2572, 0.01, DropChanceItemData.EQUIPMENT);

	private int itemId;
	private double modifier;
	private DropChanceItemData type;

	DropChanceData(int itemId, double modifier, DropChanceItemData type) {
		this.itemId = itemId;
		this.modifier = modifier;
		this.type = type;
	}

	public int getItemId() {
		return itemId;
	}

	public double getModifier() {
		return modifier;
	}

	public DropChanceItemData getType() {
		return type;
	}

}
