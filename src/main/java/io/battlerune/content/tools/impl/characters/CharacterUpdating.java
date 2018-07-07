package io.battlerune.content.tools.impl.characters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.battlerune.game.world.entity.mob.player.Player;

public class CharacterUpdating {

	public static void update(String type, Player player) {
		Path path = Paths.get("./data/profile/" + player.getUsername() + ".json");
		File p = path.toFile();

		try (FileReader read = new FileReader(p)) {
			JsonParser fileParser = new JsonParser();
			Gson builder = new GsonBuilder().create();
			JsonObject reader = (JsonObject) fileParser.parse(read);

			switch (type) {

			case "rights":

				if (reader.has("player-rights")) {

				}
				break;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
