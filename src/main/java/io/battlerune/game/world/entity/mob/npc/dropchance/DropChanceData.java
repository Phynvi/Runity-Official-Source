package io.battlerune.game.world.entity.mob.npc.dropchance;

/**
 * 
 * @author Nerik
 *
 */

public enum DropChanceData {

	// TODO ROW I & ELITE TORVA 
	RING_OF_WEALTH(2572, 4, 10), 
	SOULSETPIECE(13693, 5, 15),
	SOULSETPIECE1(13696, 5, 15),
	SOULSETPIECE2(13695, 5, 15),
	SOULSETPIECE4(13692, 5, 15), 
	ROWI(12785, 2, 12), 
	LIME_WHIP_U(21292, 4, 23),
	LIME_WHIP(21225, 4, 20), 
	DEATH_KATANA(11642, 5, 35),
	MAGMA_AXE(13687, 5, 10),
	RING_50(21752, 8, 50),
	RING_25(20005, 4, 25),
	KARTH_RING_15(13814, 7, 15),
	NECK_14(21143, 7, 15),
	RING_14(21081, 7, 15),
	Dark1(13710, 3, 10),
	dark2(13714, 3, 10), 
	dark3(13715, 3, 10),
	dark4(13805, 3, 10),
	dark5(13816, 3, 10),
	dark6(13711, 3, 5),
	CHI_HELM(13703, 2, 5),
	CHI_BODY(13704, 2, 5),
	CHI_LEGS(13705, 2, 5),
	LAVABOW(13749, 5, 10),
    slayerhelm(21777, 2, 15),
    slayerbody(22123, 2, 15),
    slayerlegs(21954, 2, 15),
    slayerkite(21895, 2, 15),
	SAM_HELM(20049, 1, 2),
	SAM_PLATE(13284, 1, 2),
	SAM_LEGS(20058, 1, 2),
	SAM_GLOVES(20055, 1, 2),
	SAM_BOOTS(20061, 1, 2),
	
	;

	private int itemId;
	private int modifier;
	private int lyingmodifier;

	DropChanceData(int itemId, int modifier, int lyingmodifier) {
		this.itemId = itemId;
		this.modifier = modifier;
		this.lyingmodifier = lyingmodifier;
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
	
	public int getlyingModifier() {
		return lyingmodifier;
	}
	
	public void SetlyingMofidier(int lyingmodifier) {
		this.lyingmodifier = lyingmodifier;
	}

}
