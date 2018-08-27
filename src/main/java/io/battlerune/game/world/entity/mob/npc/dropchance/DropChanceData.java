package io.battlerune.game.world.entity.mob.npc.dropchance;

/**
 * 
 * @author Nerik
 *
 */

public enum DropChanceData {

	/**
	 * 0.9% = 1300 - 130 = 1170 what it does is. 0.9 = 1300 - 130% (which is 10% of
	 * 1300).
	 * 
	 * so 0.8 would be 1300 - 260 = 260 = 20% of 1300.
	 * 
	 * so 0.7 would be 1300 - 390 = 910. 360 = 30% of 1300.
	 */

	RING_OF_WEALTH(2572, 0.9, DropChanceItemData.EQUIPMENT), SOULSETPIECE(13693, 0.8, DropChanceItemData.EQUIPMENT),
	SOULSETPIECE1(13696, 0.7, DropChanceItemData.EQUIPMENT), SOULSETPIECE2(13695, 0.6, DropChanceItemData.EQUIPMENT),
	SOULSETPIECE3(17158, 0.5, DropChanceItemData.EQUIPMENT), SOULSETPIECE4(13692, 0.4, DropChanceItemData.EQUIPMENT);

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
