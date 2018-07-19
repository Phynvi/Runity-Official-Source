package io.battlerune.content.raids.object;

import java.util.HashMap;
import java.util.Map;

import io.battlerune.content.raids.object.impl.LingTree;

public class RaidsObjectHandler {

	public static Map<RaidsObjectData, RaidsObject> objects = new HashMap<>();

	public static void load() {

		objects.put(RaidsObjectData.TREE, new LingTree());
	}
}
