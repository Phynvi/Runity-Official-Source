package io.battlerune.content.presets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.entity.mob.player.Player;

public class PresetManager {

	private Player player;
	private Preset preset;

	public PresetManager(Player player) {
		this.player = player;
	}
	
	public PresetManager(Player player, Preset preset) {
		this.player = player;
		this.preset = preset;
	}

	public void save() {
		try (FileWriter writer = new FileWriter(SAVE_PATH + player.getUsername() + ".json")) {

			Gson builder = new GsonBuilder().setPrettyPrinting().create();
			JsonObject object = new JsonObject();

			object.addProperty("preset-name", preset.getName());
			object.add("equipment", builder.toJsonTree(preset.getEquipment()));
			object.add("inventory", builder.toJsonTree(preset.getInventory()));
			
			writer.write(builder.toJson(object));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		try (FileReader fileReader = new FileReader(SAVE_PATH + player.getUsername() + ".json")) {
            JsonParser fileParser = new JsonParser();
            Gson builder = new GsonBuilder().create();
            JsonObject reader = (JsonObject) fileParser.parse(fileReader);
            
            
            if(reader.has("preset-name")
            		&& reader.has("equipment") && reader.has("inventory")) {
            	PRESETS[0] = new Preset(reader.get("preset-name").getAsString(),
            			builder.fromJson(reader.get("equipment").getAsJsonArray(), Item[].class), 
            			builder.fromJson(reader.get("inventory").getAsJsonArray(), Item[].class));
            }
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private final Preset[] PRESETS = new Preset[8];
	private final String SAVE_PATH = "./data/content/presets/";
}
