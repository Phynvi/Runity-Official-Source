package io.battlerune.content.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import plugin.command.impl.donator.DZoneCommand;
import plugin.command.impl.donator.DonatorBankCommand;
import plugin.command.impl.donator.DonatorYellCommand;
import plugin.command.impl.donator.PortalsZoneCommand;
import plugin.command.impl.moderator.JailCommand;
import plugin.command.impl.moderator.MuteCommand;
import plugin.command.impl.moderator.PrivateZoneCommand;
import plugin.command.impl.moderator.TeletoCommand;
import plugin.command.impl.moderator.TeletomeCommand;
import plugin.command.impl.moderator.UnjailCommand;
import plugin.command.impl.moderator.UnmuteCommand;
import plugin.command.impl.owner.AllToMeCommand;
import plugin.command.impl.owner.AnimationCommand;
import plugin.command.impl.owner.ArenaSpawnCommand;
import plugin.command.impl.owner.DeveloperInstanceCommand;
import plugin.command.impl.owner.DownCommand;
import plugin.command.impl.owner.EventBossInterfaceHide;
import plugin.command.impl.owner.EventBossInterfaceShow;
import plugin.command.impl.owner.EventBossSystem;
import plugin.command.impl.owner.FindCommand;
import plugin.command.impl.owner.GalvekSpawnCommand;
import plugin.command.impl.owner.GiveAllCommand;
import plugin.command.impl.owner.GodCommand;
import plugin.command.impl.owner.GraphicCommand;
import plugin.command.impl.owner.InterfaceCommand;
import plugin.command.impl.owner.ItemCommand;
import plugin.command.impl.owner.MasterCommand;
import plugin.command.impl.owner.MiniMeCommand;
import plugin.command.impl.owner.NpcCommand;
import plugin.command.impl.owner.ObjectCommand;
import plugin.command.impl.owner.PlantFlowerCommand;
import plugin.command.impl.owner.PlayerGuideCommand;
import plugin.command.impl.owner.PnpcCommand;
import plugin.command.impl.owner.RandomEvent;
import plugin.command.impl.owner.ReloadCommand;
import plugin.command.impl.owner.RemovePlayerTask;
import plugin.command.impl.owner.SpawnCustomCommand;
import plugin.command.impl.owner.SpecCommand;
import plugin.command.impl.owner.TeleCommand;
import plugin.command.impl.owner.UpCommand;
import plugin.command.impl.owner.UpdateCommand;
import plugin.command.impl.player.AnswerTriviaCommand;
import plugin.command.impl.player.ArenaZoneCommand;
import plugin.command.impl.player.BarrowsCommand;
import plugin.command.impl.player.CashOutCommand;
import plugin.command.impl.player.Commands;
import plugin.command.impl.player.DiceCommand;
import plugin.command.impl.player.DiscordCommand;
import plugin.command.impl.player.DonateCommand;
import plugin.command.impl.player.DropInterfaceCommand;
import plugin.command.impl.player.DropSimulatorCommand;
import plugin.command.impl.player.DropsCommand;
import plugin.command.impl.player.DuelArenaCommand;
import plugin.command.impl.player.Easts;
import plugin.command.impl.player.EmptyInventoryCommand;
import plugin.command.impl.player.FameBoardCommand;
import plugin.command.impl.player.ForumCommand;
import plugin.command.impl.player.GambleCommand;
import plugin.command.impl.player.GdzCommand;
import plugin.command.impl.player.Helpcommand;
import plugin.command.impl.player.HomeCommand;
import plugin.command.impl.player.MageBankCommand;
import plugin.command.impl.player.PlayerCountCommand;
import plugin.command.impl.player.PouchCommand;
import plugin.command.impl.player.ShopCommand;
import plugin.command.impl.player.SkillAreaCommand;
import plugin.command.impl.player.SkullCommand;
import plugin.command.impl.player.SlayerTaskCommand;
import plugin.command.impl.player.StaffCommand;
import plugin.command.impl.player.StuckCommand;
import plugin.command.impl.player.Tier1Teleport;
import plugin.command.impl.player.Tier2Teleport;
import plugin.command.impl.player.Tier3Teleport;
import plugin.command.impl.player.Tier4Teleport;
import plugin.command.impl.player.TrainZone;
import plugin.command.impl.player.VaultCommand;
import plugin.command.impl.player.VoteCommand;
import plugin.command.impl.player.Wests;

/**
 * Stores Commands
 * 
 * @author Nerik#8690
 *
 */
public class CommandManager {

	public static Map<String[], Command> plugin = new HashMap<>();
	public static Map<String, Command> plugin_input = new HashMap<>();

	public static void load() {
		/*
		 * @Player Commands
		 */
		plugin.put(new String[] { "easts" }, new Easts());
		plugin.put(new String[] { "testcom", "command" }, new Commands());
		plugin.put(new String[] { "plant" }, new PlantFlowerCommand());
		plugin.put(new String[] { "home", "hom" }, new HomeCommand());
		plugin.put(new String[] { "train", "training" }, new TrainZone());
		plugin.put(new String[] { "tele" }, new TeleCommand());
		plugin.put(new String[] { "tier1", "tierone" }, new Tier1Teleport());
		plugin.put(new String[] { "tier2", "tiertwo" }, new Tier2Teleport());
		plugin.put(new String[] { "tier3", "tierthree" }, new Tier3Teleport());
		plugin.put(new String[] { "tier4", "tierfour" }, new Tier4Teleport());
		plugin.put(new String[] { "pouch" }, new PouchCommand());
		plugin.put(new String[] { "fameboard", "fame" }, new FameBoardCommand());
		plugin.put(new String[] { "shops", "store", "shop", "stores" }, new ShopCommand());
		plugin.put(new String[] { "drops", "drop", "droplist", "droptable" }, new DropsCommand());
		plugin.put(new String[] { "simulate", "simulator", "dropsim" }, new DropSimulatorCommand());
		plugin.put(new String[] { "vote" }, new VoteCommand());
		plugin.put(new String[] { "dice", "dp" }, new DiceCommand());
		plugin.put(new String[] { "skull" }, new SkullCommand());
		plugin.put(new String[] { "duel", "duelarena" }, new DuelArenaCommand());
		plugin.put(new String[] { "barrows" }, new BarrowsCommand());
		plugin.put(new String[] { "skill", "skillingarea" }, new SkillAreaCommand());
		plugin.put(new String[] { "donate", "webstore" }, new DonateCommand());
		plugin.put(new String[] { "vault", "vaultamount" }, new VaultCommand());
		plugin.put(new String[] { "drops", "drop" }, new DropInterfaceCommand());
		plugin.put(new String[] { "gamble", "gamblezone" }, new GambleCommand());
		plugin.put(new String[] { "arena", "arenazone" }, new ArenaZoneCommand());
		plugin.put(new String[] { "cashout", "pins" }, new CashOutCommand());
		plugin.put(new String[] { "help", "helpp" }, new Helpcommand());
		plugin.put(new String[] { "answer", "trivia" }, new AnswerTriviaCommand());
		plugin.put(new String[] { "staff", "staffonline" }, new StaffCommand());
		plugin.put(new String[] { "forums", "website" }, new ForumCommand());
		plugin.put(new String[] { "discord", "discords" }, new DiscordCommand());
		plugin.put(new String[] { "stuck", "stucks" }, new StuckCommand());
		plugin.put(new String[] { "wests", "west" }, new Wests());
		plugin.put(new String[] { "mb", "magebank" }, new MageBankCommand());
		plugin.put(new String[] { "gd", "gdz" }, new GdzCommand());
		plugin.put(new String[] { "slayertask", "task" }, new SlayerTaskCommand());
		plugin.put(new String[] { "players", "online" }, new PlayerCountCommand());
		plugin.put(new String[] { "empty", "emptyinventory" }, new EmptyInventoryCommand());
		/*
		 * @Donator Command
		 */

		plugin.put(new String[] { "bank", "banks" }, new DonatorBankCommand());
		plugin.put(new String[] { "donatorzone", "dzone" }, new DZoneCommand());
		plugin.put(new String[] { "portals", "portalzone" }, new PortalsZoneCommand());
		plugin.put(new String[] { "yell", "shout" }, new DonatorYellCommand());

		
		/**
		 * @Moderator/Helper Commands
		 */
		
		plugin.put(new String[] { "mute", "mutee" }, new MuteCommand());
		plugin.put(new String[] { "unmute", "unmutee" }, new UnmuteCommand());
		plugin.put(new String[] { "jail", "jaill" }, new JailCommand());
		plugin.put(new String[] { "unjail", "unjaill" }, new UnjailCommand());
		plugin.put(new String[] { "privatezone", "staffzone" }, new PrivateZoneCommand());
		plugin.put(new String[] { "teleto", "t2", "tele2" }, new TeletoCommand());
		plugin.put(new String[] { "teletome", "t2m", "tele2me" }, new TeletomeCommand());

		/*
		 * @Owner, @Developer Commands
		 */
		plugin.put(new String[] { "item" }, new ItemCommand());
		plugin.put(new String[] { "master" }, new MasterCommand());
		plugin.put(new String[] { "instance" }, new DeveloperInstanceCommand());
		plugin.put(new String[] { "spawncustoms" }, new SpawnCustomCommand());
		plugin.put(new String[] { "master", "max" }, new MasterCommand());
		plugin.put(new String[] { "find", "finditem" }, new FindCommand());
		plugin.put(new String[] { "anim", "animation" }, new AnimationCommand());
		plugin.put(new String[] { "gfx", "graphic" }, new GraphicCommand());
		plugin.put(new String[] { "spec", "special" }, new SpecCommand());
		plugin.put(new String[] { "pnpc", "transform" }, new PnpcCommand());
		plugin.put(new String[] { "up", "high" }, new UpCommand());
		plugin.put(new String[] { "down", "low" }, new DownCommand());
		plugin.put(new String[] { "god", "beast" }, new GodCommand());
		plugin.put(new String[] { "interface", "int" }, new InterfaceCommand());
		plugin.put(new String[] { "npc", "spawnnpc" }, new NpcCommand());
		plugin.put(new String[] { "guide", "openguide" }, new PlayerGuideCommand());
		plugin.put(new String[] { "obj", "object" }, new ObjectCommand());
		plugin.put(new String[] { "arenas", "spawnarena" }, new ArenaSpawnCommand());
		plugin.put(new String[] { "galveks", "spawngalvek" }, new GalvekSpawnCommand());
		plugin.put(new String[] { "event", "system" }, new EventBossSystem());
		plugin.put(new String[] { "show", "showboss" }, new EventBossInterfaceShow());
		plugin.put(new String[] { "hide", "hideboss" }, new EventBossInterfaceHide());
		plugin.put(new String[] { "minime" }, new MiniMeCommand());
		plugin.put(new String[] { "giveall", "give" }, new GiveAllCommand());
		plugin.put(new String[] { "update", "udpateserver" }, new UpdateCommand());
		//plugin.put(new String[] { "reload", "reloadserver" }, new ReloadCommand());
		plugin.put(new String[] { "removetask", "slayer" }, new RemovePlayerTask());
		plugin.put(new String[] { "randomevent", "randomeven" }, new RandomEvent());
		plugin.put(new String[] { "teleall", "all2me" }, new AllToMeCommand());

		
		for (Entry<String[], Command> map : plugin.entrySet()) {
			for (int i = 0; i < map.getKey().length; i++) {
				plugin_input.put(map.getKey()[i], map.getValue());
			}
		}

		System.out.println("[Commands] Loaded " + plugin.size() + " Commands");
	}
}
