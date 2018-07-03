package io.battlerune.content.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import plugin.command.impl.player.ArenaZoneCommand;
import plugin.command.impl.player.BarrowsCommand;
import plugin.command.impl.player.CommandList;
import plugin.command.impl.player.DeveloperMasterCommand;
import plugin.command.impl.player.DiceCommand;
import plugin.command.impl.player.DonateCommand;
import plugin.command.impl.player.DropInterfaceCommand;
import plugin.command.impl.player.DropSimulatorCommand;
import plugin.command.impl.player.DropsCommand;
import plugin.command.impl.player.DuelArenaCommand;
import plugin.command.impl.player.FameBoardCommand;
import plugin.command.impl.player.GambleCommand;
import plugin.command.impl.player.HomeCommand;
import plugin.command.impl.player.PouchCommand;
import plugin.command.impl.player.ShopCommand;
import plugin.command.impl.player.SkillAreaCommand;
import plugin.command.impl.player.SkullCommand;
import plugin.command.impl.player.VaultCommand;
import plugin.command.impl.player.VoteCommand;

/**
 * Stores Commands
 * 
 * @author hamza
 *
 */
public class CommandManager {

	public static Map<String[], Command> plugin = new HashMap<>();
	public static Map<String, Command> plugin_input = new HashMap<>();

	public static void load() {
		/*
		 * @Player Commands
		 */
		plugin.put(new String[] { "home", "hom" }, new HomeCommand());
		plugin.put(new String[] { "pouch" }, new PouchCommand());
		plugin.put(new String[] { "commands", "command", "commandlist" }, new CommandList());
		plugin.put(new String[] { "fameboard", "fame" }, new FameBoardCommand());
		plugin.put(new String[] { "shops", "store", "shop", "stores" }, new ShopCommand());
		
		plugin.put(new String[] { "drops", "drop", "droplist", "droptable" }, new DropsCommand());
		plugin.put(new String[] { "simulate", "simulator", "dropsim" }, new DropSimulatorCommand());
		plugin.put(new String[] { "vote" }, new VoteCommand());
	    plugin.put(new String[] { "dice", "gamble", "dp" }, new DiceCommand());
		plugin.put(new String[] { "skull" }, new SkullCommand());
		
		plugin.put(new String[] { "duel", "duelarena" }, new DuelArenaCommand());
		plugin.put(new String[] { "barrows" }, new BarrowsCommand());
		plugin.put(new String[] { "skills", "skill", "skillarea", "sarea" }, new SkillAreaCommand());
		plugin.put(new String[] { "donate", "webstore" }, new DonateCommand());
		plugin.put(new String[] { "vault", "vaultamount" }, new VaultCommand());
		plugin.put(new String[] { "drops", "drop" }, new DropInterfaceCommand());
		plugin.put(new String[] { "gamble", "gamblezone", "gamblee" }, new GambleCommand());
		plugin.put(new String[] { "arena", "arenazone", "arena" }, new ArenaZoneCommand());


		/*
		 * @Developer Commands
		 */
		plugin.put(new String[] { "master", "masterr" }, new DeveloperMasterCommand());

		
	
		
		for (Entry<String[], Command> map : plugin.entrySet()) {
			for (int i = 0; i < map.getKey().length; i++) {
				plugin_input.put(map.getKey()[i], map.getValue());
			}
		}

		System.out.println("[Commands] Loaded " + plugin.size() + " Commands");
	}
}
