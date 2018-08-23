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
import plugin.command.impl.owner.BroadcastCommand;
import plugin.command.impl.owner.DefaultBankCommand;
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
import plugin.command.impl.owner.JusticarSpawnCommand;
import plugin.command.impl.owner.KillCommand;
import plugin.command.impl.owner.MasterCommand;
import plugin.command.impl.owner.MiniMeCommand;
import plugin.command.impl.owner.NpcCommand;
import plugin.command.impl.owner.ObjectCommand;
import plugin.command.impl.owner.PlantFlowerCommand;
import plugin.command.impl.owner.PlayerGuideCommand;
import plugin.command.impl.owner.PnpcCommand;
import plugin.command.impl.owner.RandomEvent;
import plugin.command.impl.owner.RemovePlayerTask;
import plugin.command.impl.owner.ScratchNig;
import plugin.command.impl.owner.SkotizoSpawnCommand;
import plugin.command.impl.owner.SpawnCustomCommand;
import plugin.command.impl.owner.SpecCommand;
import plugin.command.impl.owner.TeleCommand;
import plugin.command.impl.owner.UpCommand;
import plugin.command.impl.owner.UpdateCommand;
import plugin.command.impl.player.AnswerTriviaCommand;
import plugin.command.impl.player.ArenaZoneCommand;
import plugin.command.impl.player.BarrowsCommand;
import plugin.command.impl.player.CashOutCommand;
import plugin.command.impl.player.ClaimDonationCommand;
import plugin.command.impl.player.Commands;
import plugin.command.impl.player.DiceCommand;
import plugin.command.impl.player.DiscordCommand;
import plugin.command.impl.player.DonateCommand;
import plugin.command.impl.player.DropInterfaceCommand;
import plugin.command.impl.player.DropSimulatorCommand;
import plugin.command.impl.player.DropsCommand;
import plugin.command.impl.player.DuelArenaCommand;
import plugin.command.impl.player.DustiesCommand;
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

	public static final Map<String[], Command> PLUGIN = new HashMap<>();
	public static final Map<String, Command> PLUGIN_INPUT = new HashMap<>();

	public static void load() {
		/*
		 * @Player Commands
		 */
		PLUGIN.put(new String[] { "easts" }, new Easts());
		PLUGIN.put(new String[] { "testcom", "command" }, new Commands());
		PLUGIN.put(new String[] { "plant" }, new PlantFlowerCommand());
		PLUGIN.put(new String[] { "home", "hom" }, new HomeCommand());
		PLUGIN.put(new String[] { "train", "training" }, new TrainZone());
		PLUGIN.put(new String[] { "tele" }, new TeleCommand());
		PLUGIN.put(new String[] { "tier1", "tierone" }, new Tier1Teleport());
		PLUGIN.put(new String[] { "tier2", "tiertwo" }, new Tier2Teleport());
		PLUGIN.put(new String[] { "tier3", "tierthree" }, new Tier3Teleport());
		PLUGIN.put(new String[] { "tier4", "tierfour" }, new Tier4Teleport());
		PLUGIN.put(new String[] { "pouch" }, new PouchCommand());
		PLUGIN.put(new String[] { "fameboard", "fame" }, new FameBoardCommand());
		PLUGIN.put(new String[] { "shops", "store", "shop", "stores" }, new ShopCommand());
		PLUGIN.put(new String[] { "drops", "drop", "droplist", "droptable" }, new DropsCommand());
		PLUGIN.put(new String[] { "simulate", "simulator", "dropsim" }, new DropSimulatorCommand());
		PLUGIN.put(new String[] { "vote" }, new VoteCommand());
		PLUGIN.put(new String[] { "dice", "dp" }, new DiceCommand());
		PLUGIN.put(new String[] { "skull" }, new SkullCommand());
		PLUGIN.put(new String[] { "duel", "duelarena" }, new DuelArenaCommand());
		PLUGIN.put(new String[] { "barrows" }, new BarrowsCommand());
		PLUGIN.put(new String[] { "skill", "skillingarea" }, new SkillAreaCommand());
		PLUGIN.put(new String[] { "donate", "webstore" }, new DonateCommand());
		PLUGIN.put(new String[] { "vault", "vaultamount" }, new VaultCommand());
		PLUGIN.put(new String[] { "drops", "drop" }, new DropInterfaceCommand());
		PLUGIN.put(new String[] { "gamble", "gamblezone" }, new GambleCommand());
		PLUGIN.put(new String[] { "arena", "arenazone" }, new ArenaZoneCommand());
		PLUGIN.put(new String[] { "cashout", "pins" }, new CashOutCommand());
		PLUGIN.put(new String[] { "help", "helpp" }, new Helpcommand());
		PLUGIN.put(new String[] { "answer", "trivia" }, new AnswerTriviaCommand());
		PLUGIN.put(new String[] { "staff", "staffonline" }, new StaffCommand());
		PLUGIN.put(new String[] { "forums", "website" }, new ForumCommand());
		PLUGIN.put(new String[] { "discord", "discords" }, new DiscordCommand());
		PLUGIN.put(new String[] { "stuck", "stucks" }, new StuckCommand());
		PLUGIN.put(new String[] { "wests", "west" }, new Wests());
		PLUGIN.put(new String[] { "mb", "magebank" }, new MageBankCommand());
		PLUGIN.put(new String[] { "gd", "gdz" }, new GdzCommand());
		PLUGIN.put(new String[] { "slayertask", "task" }, new SlayerTaskCommand());
		PLUGIN.put(new String[] { "players", "online" }, new PlayerCountCommand());
		PLUGIN.put(new String[] { "empty", "emptyinventory" }, new EmptyInventoryCommand());
		PLUGIN.put(new String[] { "dusties", "dusti" }, new DustiesCommand());
		PLUGIN.put(new String[] { "testdonation", "donatings" }, new ClaimDonationCommand());

		/*
		 * @Donator Command
		 */

		PLUGIN.put(new String[] { "bank", "banks" }, new DonatorBankCommand());
		PLUGIN.put(new String[] { "donatorzone", "dzone" }, new DZoneCommand());
		PLUGIN.put(new String[] { "portals", "portalzone" }, new PortalsZoneCommand());
		PLUGIN.put(new String[] { "yell", "shout" }, new DonatorYellCommand());

		/**
		 * @Moderator/Helper Commands
		 */

		PLUGIN.put(new String[] { "mute", "mutee" }, new MuteCommand());
		PLUGIN.put(new String[] { "unmute", "unmutee" }, new UnmuteCommand());
		PLUGIN.put(new String[] { "jail", "jaill" }, new JailCommand());
		PLUGIN.put(new String[] { "unjail", "unjaill" }, new UnjailCommand());
		PLUGIN.put(new String[] { "privatezone", "staffzone" }, new PrivateZoneCommand());
		PLUGIN.put(new String[] { "teleto", "t2", "tele2" }, new TeletoCommand());
		PLUGIN.put(new String[] { "teletome", "t2m", "tele2me" }, new TeletomeCommand());

		/*
		 * @Owner, @Developer Commands
		 */
		PLUGIN.put(new String[] { "scratch"}, new ScratchNig());
		PLUGIN.put(new String[] { "item" }, new ItemCommand());
		PLUGIN.put(new String[] { "master" }, new MasterCommand());
		PLUGIN.put(new String[] { "instance" }, new DeveloperInstanceCommand());
		PLUGIN.put(new String[] { "customs" }, new SpawnCustomCommand());
		PLUGIN.put(new String[] { "defaultbank" }, new DefaultBankCommand());
		PLUGIN.put(new String[] { "master", "max" }, new MasterCommand());
		PLUGIN.put(new String[] { "find", "finditem" }, new FindCommand());
		PLUGIN.put(new String[] { "anim", "animation" }, new AnimationCommand());
		PLUGIN.put(new String[] { "gfx", "graphic" }, new GraphicCommand());
		PLUGIN.put(new String[] { "spec", "special" }, new SpecCommand());
		PLUGIN.put(new String[] { "pnpc", "transform" }, new PnpcCommand());
		PLUGIN.put(new String[] { "up", "high" }, new UpCommand());
		PLUGIN.put(new String[] { "down", "low" }, new DownCommand());
		PLUGIN.put(new String[] { "god", "beast" }, new GodCommand());
		PLUGIN.put(new String[] { "interface", "int" }, new InterfaceCommand());
		PLUGIN.put(new String[] { "npc", "spawnnpc" }, new NpcCommand());
		PLUGIN.put(new String[] { "guide", "openguide" }, new PlayerGuideCommand());
		PLUGIN.put(new String[] { "obj", "object" }, new ObjectCommand());
		PLUGIN.put(new String[] { "arenas", "spawnarena" }, new ArenaSpawnCommand());
		PLUGIN.put(new String[] { "galveks", "spawngalvek" }, new GalvekSpawnCommand());
		PLUGIN.put(new String[] { "justicars", "spawnjusticar" }, new JusticarSpawnCommand());
		PLUGIN.put(new String[] { "skotizos", "spanwskotizo" }, new SkotizoSpawnCommand());
		PLUGIN.put(new String[] { "event", "system" }, new EventBossSystem());
		PLUGIN.put(new String[] { "show", "showboss" }, new EventBossInterfaceShow());
		PLUGIN.put(new String[] { "hide", "hideboss" }, new EventBossInterfaceHide());
		PLUGIN.put(new String[] { "minime" }, new MiniMeCommand());
		PLUGIN.put(new String[] { "giveall", "give" }, new GiveAllCommand());
		PLUGIN.put(new String[] { "update", "udpateserver" }, new UpdateCommand());
		// PLUGIN.put(new String[] { "reload", "reloadserver" }, new ReloadCommand());
		PLUGIN.put(new String[] { "removetask", "slayer" }, new RemovePlayerTask());
		PLUGIN.put(new String[] { "randomevent", "randomeven" }, new RandomEvent());
		PLUGIN.put(new String[] { "teleall", "all2me" }, new AllToMeCommand());
		PLUGIN.put(new String[] { "broadcast", "announcement" }, new BroadcastCommand());
		PLUGIN.put(new String[] { "kill", "killplayer" }, new KillCommand());

		for (Entry<String[], Command> map : PLUGIN.entrySet()) {
			for (int i = 0; i < map.getKey().length; i++) {
				PLUGIN_INPUT.put(map.getKey()[i], map.getValue());
			}
		}

		System.out.println("[Commands] Loaded " + PLUGIN.size() + " Commands");
	}
}
