package io.battlerune.game.world.entity.mob.npc.dropchance;

/**
 * 
 * @author Nerik
 *
 */

public enum DropChanceData {

	// TODO ROW I & ELITE TORVA
	RING_OF_WEALTH(2572, 6, 10), SOULSETPIECE(13693, 7, 15), SOULSETPIECE1(13696, 7, 15), SOULSETPIECE2(13695, 7, 15),
	SOULSETPIECE4(13692, 7, 15), ROWI(12785, 4, 12), LIME_WHIP_U(21292, 6, 23), LIME_WHIP(21225, 6, 20),
	DEATH_KATANA(11642, 8, 35), MAGMA_AXE(13687, 7, 10), RING_50(21752, 10, 50), RING_25(20005, 6, 25),
	CAPE_50(9074, 5, 50), KARTH_RING_15(13814, 9, 15), NECK_14(21143, 9, 15), RING_14(21081, 9, 15),
	Dark1(13710, 5, 10), dark2(13714, 5, 10), dark3(13715, 5, 10), dark4(13805, 5, 10), dark5(13816, 5, 10),
	dark6(13711, 5, 5), CHI_HELM(13703, 4, 12), CHI_BODY(13704, 4, 12), CHI_LEGS(13705, 4, 12), owl_head(34, 3, 13),
	owl_plate(79, 3, 13), owl_legs(80, 3, 13), LAVABOW(13749, 7, 10), slayerhelm(21777, 4, 15),
	slayerbody(22123, 4, 15), slayerlegs(21954, 4, 15), slayerkite(21895, 4, 15), SAM_HELM(20049, 3, 4),
	VITUR(22325, 7, 25),
	SILVER_CHAIN(13689, 5, 5),
	ETO1(3078, 2, 5),
	ETO2(3074, 2, 5),
	ETO3(3075, 2, 5),
	ETO4(3073, 2, 5),
	SWORD_HEARTS(13708, 2, 5),

	SAM_PLATE(13284, 3, 4), SAM_LEGS(20058, 3, 4), SAM_GLOVES(20055, 3, 4), SAM_BOOTS(20061, 3, 4);

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

	public int getlyingModifier() {
		return lyingmodifier;
	}

}
