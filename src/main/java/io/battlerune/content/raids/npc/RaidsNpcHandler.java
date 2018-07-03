package io.battlerune.content.raids.npc;

import java.util.HashMap;
import java.util.Map;

import io.battlerune.content.raids.npc.impl.LizardShaman;

public class RaidsNpcHandler {

	public static Map<RaidsNpcData, RaidsNpc> npcs = new HashMap<>();

	public static void load() {

		npcs.put(RaidsNpcData.LIZARD_SHAMAN, new LizardShaman());
	}
}
