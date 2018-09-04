package io.battlerune.game.world.entity.mob.npc.dropchance;

/**
 * 
 * @author Nerik
 *
 */

public enum DropChanceData {

	/**
	 * (1300 / 100) [STANDARD] -> 13
	 * 
	 * (13 * getRate([EXAMPLE 50])) -> 650
	 * 
	 * (1300 - 650) -> 650 
	 * 
	 * Random roll on 650
	 * 
	 */

	//TODO ROW I & ELITE TORVA
	RING_OF_WEALTH(2572, 10), SOULSETPIECE(13693, 9),
	SOULSETPIECE1(13696, 9), SOULSETPIECE2(13695, 9),
	SOULSETPIECE3(17158, 9), SOULSETPIECE4(13692, 9),
	ROWI(12785, 12),
	LIME_WHIP(21225, 20),
	 DEATH_KATANA(11642, 15),
	 MAGMA_AXE(13687, 10),
	;


	private int itemId;
	private int modifier;

	DropChanceData(int itemId, int modifier) {
		this.itemId = itemId;
		this.modifier = modifier;
	}

	public int getItemId() {
		return itemId;
	}

	public int getModifier() {
		return modifier;
	}

}
