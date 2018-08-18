package io.battlerune.content.mysterybox;

import java.util.HashMap;
import java.util.Map;

import io.battlerune.content.mysterybox.impl.MysteryBox;
import io.battlerune.content.mysterybox.impl.SilverMysteryBox;

/**
 * 
 * @author Nerik_gaylord
 *
 */
public class MysteryBoxEvent {

	public static final Map<MysteryBoxType, MysteryBoxListener> MYSTERY_BOX = new HashMap<>();
	
	public static void load() {
		
		MYSTERY_BOX.put(MysteryBoxType.MYSTERY_BOX, new MysteryBox());
		MYSTERY_BOX.put(MysteryBoxType.SILVER_MBOX, new SilverMysteryBox());
		
		System.out.println("[Mystery Box] Loaded " + MYSTERY_BOX.size() + " Mysery Box Plugins");

	}
}
