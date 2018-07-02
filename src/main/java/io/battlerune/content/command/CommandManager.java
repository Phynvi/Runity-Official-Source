package io.battlerune.content.command;

import java.util.HashMap;
import java.util.Map;

import plugin.command.impl.player.CommandList;
import plugin.command.impl.player.FameBoardCommand;
import plugin.command.impl.player.HomeCommand;
import plugin.command.impl.player.PouchCommand;

/**
 * Stores Commands
 * 
 * @author hamza
 *
 */
public class CommandManager {

	public static Map<String, Command> plugin = new HashMap<>();

	public static void load() {
		// Player
		plugin.put("home", new HomeCommand());
		plugin.put("command", new CommandList());
		plugin.put("nigger", new FameBoardCommand());
		plugin.put("pouch", new PouchCommand());

		System.out.println("[Commands] Loaded " + plugin.size() + " Commands");
	}
}
