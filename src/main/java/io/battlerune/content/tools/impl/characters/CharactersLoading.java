package io.battlerune.content.tools.impl.characters;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CharactersLoading {

	static List<String> players = new ArrayList<>();

	public static void load() {
		Path path = Paths.get("./data/profile/save/");
		File[] chars = path.toFile().listFiles();

		for (int i = 0; i < chars.length; i++) {
			String name = chars[i].getName().replaceAll(".json", "");
			if (players.contains(name)) {
				continue;
			}
			players.add(name);
		}

		System.out.println("[Control Panel] Added " + players.size() + " players!");
	}

	public static List<String> getPlayers() {
		return players;
	}
}
