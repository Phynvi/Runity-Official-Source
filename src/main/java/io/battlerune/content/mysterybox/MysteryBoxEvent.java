package io.battlerune.content.mysterybox;

import java.util.HashMap;
import java.util.Map;

import io.battlerune.content.mysterybox.impl.GoldMysteryBox;
import io.battlerune.content.mysterybox.impl.MegaMysteryBox;
import io.battlerune.content.mysterybox.impl.MysteryBox;
import io.battlerune.content.mysterybox.impl.PetMysteryBox;
import io.battlerune.content.mysterybox.impl.SilverMysteryBox;

/**
 * Mystery Box Event Listener
 * 
 * @author Nerik#8690
 *
 */
public class MysteryBoxEvent {

	public static final Map<MysteryBoxType, MysteryBoxListener> MYSTERY_BOX = new HashMap<>();

	static {

		MYSTERY_BOX.putIfAbsent(MysteryBoxType.MYSTERY_BOX, new MysteryBox());
		MYSTERY_BOX.putIfAbsent(MysteryBoxType.SILVER_MBOX, new SilverMysteryBox());
		MYSTERY_BOX.putIfAbsent(MysteryBoxType.GOLD_MBOX, new GoldMysteryBox());
		MYSTERY_BOX.putIfAbsent(MysteryBoxType.MEGA_MBOX, new MegaMysteryBox());
		MYSTERY_BOX.putIfAbsent(MysteryBoxType.PETMBOX, new PetMysteryBox());

	}
}
