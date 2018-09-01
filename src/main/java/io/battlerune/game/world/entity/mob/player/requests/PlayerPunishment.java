package io.battlerune.game.world.entity.mob.player.requests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import io.battlerune.game.world.entity.mob.player.Player;

/**
 * Handles the player punishment
 *
 * @author Nerik#8690
 */
public class PlayerPunishment {

	private Player player;
	private PlayerPunishementData type;

	public PlayerPunishment(Player player, PlayerPunishementData type) {
		this.player = player;
		this.type = type;
	}

	public void load() {
		try(BufferedReader reader = new BufferedReader(new FileReader(type.getPath()))) {
			
			reader.lines().forEach(line -> {
				if(line != null) {
					DATA.putIfAbsent(player.getUsername(), type);
				}
			});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(type.getPath()), true))) {
			writer.append(player.getUsername());
			writer.println();
			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, PlayerPunishementData> DATA = new HashMap<>();
	

}
