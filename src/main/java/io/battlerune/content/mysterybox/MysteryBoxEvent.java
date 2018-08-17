package io.battlerune.content.mysterybox;

import java.util.HashMap;
import java.util.Map;

import io.battlerune.content.mysterybox.impl.MysteryBox;

public class MysteryBoxEvent {

	public static final Map<MysteryBoxType, MysteryBoxListener> MYSTERY_BOX = new HashMap<>();
	
	static {
		
		MYSTERY_BOX.put(MysteryBoxType.MYSTERY_BOX, new MysteryBox());
	}
}
