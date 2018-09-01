package io.battlerune.content.logger.impl;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import io.battlerune.content.logger.LoggerListener;
import io.battlerune.game.world.entity.mob.player.Player;

public class TradingLogger implements LoggerListener {

	private Date date = new Date();
	
	@Override
	public String getPath() {
		return "./data/content/logs";
	}

	@Override
	public void execute(Player player, Player other, String log) {
		Path path = Paths.get(getPath(), "Trading.json");
		File file = path.toFile();
		file.getParentFile().setWritable(true);
		
		if (!file.getParentFile().exists()) {
            try {
                file.getParentFile().mkdirs();
            } catch (SecurityException e) {
                System.out.println("Unable to create directory for player data!");
            }
        }
		
		try (FileWriter writer = new FileWriter(file)) {

			Gson builder = new GsonBuilder().setPrettyPrinting().create();
			JsonObject object = new JsonObject();

			object.addProperty("date", String.valueOf(date));
			object.addProperty("player-traded", other.getUsername());
			object.addProperty("player-name", player.getUsername());
			object.addProperty("trade-log", String.valueOf(log));
			
			writer.write(builder.toJson(object));
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
