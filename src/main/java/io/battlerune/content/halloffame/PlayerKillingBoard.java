package io.battlerune.content.halloffame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.battlerune.game.world.entity.mob.player.PlayerRight;

/**
 * Handles the loading and fetching data for the player killing board statistics
 * 
 * @author hamza
 *
 */
public class PlayerKillingBoard {

	static List<FameBoardPlayer> player = new ArrayList<FameBoardPlayer>();
	static List<FameBoardPlayer> ordered_players = new ArrayList<FameBoardPlayer>();

	public static void main(String[] args) {
		load();

	}

	public static void load() {
		File dir = new File("./data/profile/save/");
		File[] chars = dir.listFiles();
		String name;

		for (int i = 0; i < chars.length; i++) {
			name = chars[i].getName().replaceAll(".json", "");
			for (int j = 0; j < player.size(); j++) {
				if (player.get(j).getUsername().equalsIgnoreCase(name)) {
					player.remove(j);
				}
			}
			player.add(new FameBoardPlayer(getPlayerRank(name), name, getPlayerKills(name)));
		}
		System.out.println("Added " + player.size() + " Players to the database!");

	}

	private static FameBoardPlayer getOrderedList() {
		return Collections.max(player, new FameBoardComparer());
	}

	private static PlayerRight getPlayerRank(String username) {
		try (FileReader fileReader = new FileReader("./data/profile/save/" + username + ".json")) {
			JsonParser fileParser = new JsonParser();
			Gson builder = new GsonBuilder().create();
			JsonObject reader = (JsonObject) fileParser.parse(fileReader);

			if (reader.has("player-rights")) {
				return builder.fromJson(reader.get("player-rights"), PlayerRight.class);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static int getPlayerKills(String username) {
		try (FileReader fileReader = new FileReader("./data/profile/save/" + username + ".json")) {
			JsonParser fileParser = new JsonParser();
			Gson builder = new GsonBuilder().create();
			JsonObject reader = (JsonObject) fileParser.parse(fileReader);

			if (reader.has("kills")) {
				return reader.get("kills").getAsInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
