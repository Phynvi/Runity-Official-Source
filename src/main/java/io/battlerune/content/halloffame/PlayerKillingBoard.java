package io.battlerune.content.halloffame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * Handles the loading and fetching data for the player killing board statistics
 * 
 * @author hamza
 *
 */
public class PlayerKillingBoard {

	public static List<Player> player = new ArrayList<>();

	public static void main(String[] args) {
		player.clear();
		load();
	}

	public static void load() {
		File char_dir = new File("./data/profile/save/");
		File[] chars = char_dir.listFiles();

		for (int i = 0; i < chars.length; i++) {
			if (!player.contains(
					World.getPlayerBySlot(getPlayerIndex(chars[i].getName().toString().replaceAll(".json", ""))).get())
					&& !World.getPlayerBySlot(getPlayerIndex(chars[i].getName().toString().replaceAll(".json", "")))
							.get().isBot
					&& World.getPlayerBySlot(getPlayerIndex(chars[i].getName().toString().replaceAll(".json", "")))
							.get() != null) {
				player.add(World.getPlayerBySlot(getPlayerIndex(chars[i].getName().toString().replaceAll(".json", "")))
						.get());
			}
		}

		System.out.println("Loaded " + player.size() + " Player [Pvp board] data!");
	}

	private static int getPlayerIndex(String player) {
		try (FileReader fileReader = new FileReader("./data/profile/save/" + player + ".json")) {
			JsonParser fileParser = new JsonParser();
			JsonObject reader = (JsonObject) fileParser.parse(fileReader);

			if (reader.has("player-index")) {
				return reader.get("player-index").getAsInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
