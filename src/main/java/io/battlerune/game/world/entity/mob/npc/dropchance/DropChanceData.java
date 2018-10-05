package io.battlerune.game.world.entity.mob.npc.dropchance;

/**
 * 
 * @author Nerik
 *
 */

public enum DropChanceData {

	// TODO ROW I & ELITE TORVA 
	RING_OF_WEALTH(2572, 10), 
	SOULSETPIECE(13693, 11),
	SOULSETPIECE1(13696, 13),
	SOULSETPIECE2(13695, 13),
	SOULSETPIECE4(13692, 13), 
	ROWI(12785, 12), 
	LIME_WHIP_U(21292, 17),
	LIME_WHIP(21225, 15), 
	DEATH_KATANA(11642, 20),
	MAGMA_AXE(13687, 10),
	RING_50(21752, 50),
	RING_25(20005, 25),
	KARTH_RING_15(13814, 15),
	NECK_14(21143, 15),
	RING_14(21081, 15),
	Dark1(13710, 7),
	dark2(13714, 7), 
	dark3(13715, 5),
	dark4(13805, 5),
	dark5(13816, 5),
	dark6(13711, 5),
	CHI_HELM(13703, 5),
	CHI_BODY(13704, 5),
	CHI_LEGS(13705, 5),
	LAVABOW(13749, 10),

	SAM_HELM(20049, 2),
	SAM_PLATE(13284, 2),
	SAM_LEGS(20058, 2),
	SAM_GLOVES(20055, 2),
	SAM_BOOTS(20061, 2),
	
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
	
	public void SetMofidier(int modifier) {
		this.modifier = modifier;
	}

}
