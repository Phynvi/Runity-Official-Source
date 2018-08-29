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
import plugin.command.impl.player.KeyCommand;
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

	static {
		/*
		 * @Player Commands
		 */
		PLUGIN.putIfAbsent(new String[] { "easts" }, new Easts());
		PLUGIN.putIfAbsent(new String[] { "testcom", "command" }, new Commands());
		PLUGIN.putIfAbsent(new String[] { "plant" }, new PlantFlowerCommand());
		PLUGIN.putIfAbsent(new String[] { "home", "hom" }, new HomeCommand());
		PLUGIN.putIfAbsent(new String[] { "train", "training" }, new TrainZone());
		PLUGIN.putIfAbsent(new String[] { "tele" }, new TeleCommand());
		PLUGIN.putIfAbsent(new String[] { "tier1", "tierone" }, new Tier1Teleport());
		PLUGIN.putIfAbsent(new String[] { "tier2", "tiertwo" }, new Tier2Teleport());
		PLUGIN.putIfAbsent(new String[] { "tier3", "tierthree" }, new Tier3Teleport());
		PLUGIN.putIfAbsent(new String[] { "tier4", "tierfour" }, new Tier4Teleport());
		PLUGIN.putIfAbsent(new String[] { "pouch" }, new PouchCommand());
		PLUGIN.putIfAbsent(new String[] { "fameboard", "fame" }, new FameBoardCommand());
		PLUGIN.putIfAbsent(new String[] { "shops", "shop", }, new ShopCommand());
		PLUGIN.putIfAbsent(new String[] { "drops", "drop", "droplist", "droptable" }, new DropsCommand());
		PLUGIN.putIfAbsent(new String[] { "simulate", "simulator", "dropsim" }, new DropSimulatorCommand());
		PLUGIN.putIfAbsent(new String[] { "vote" }, new VoteCommand());
		PLUGIN.putIfAbsent(new String[] { "dice", "dp" }, new DiceCommand());
		PLUGIN.putIfAbsent(new String[] { "skull" }, new SkullCommand());
		PLUGIN.putIfAbsent(new String[] { "duel", "duelarena" }, new DuelArenaCommand());
		PLUGIN.putIfAbsent(new String[] { "barrows" }, new BarrowsCommand());
		PLUGIN.putIfAbsent(new String[] { "skill", "skillingarea" }, new SkillAreaCommand());
		PLUGIN.putIfAbsent(new String[] { "claim", "donated" }, new ClaimDonationCommand());
		PLUGIN.putIfAbsent(new String[] { "donate", "store", "Donate", "Store" }, new ClaimDonationCommand());

		PLUGIN.putIfAbsent(new String[] { "vault", "vaultamount" }, new VaultCommand());
		PLUGIN.putIfAbsent(new String[] { "drops", "drop" }, new DropInterfaceCommand());
		PLUGIN.putIfAbsent(new String[] { "gamble", "gamblezone" }, new GambleCommand());
		PLUGIN.putIfAbsent(new String[] { "arena", "arenazone" }, new ArenaZoneCommand());
		PLUGIN.putIfAbsent(new String[] { "cashout", "pins" }, new CashOutCommand());
		PLUGIN.putIfAbsent(new String[] { "help", "helpp" }, new Helpcommand());
		PLUGIN.putIfAbsent(new String[] { "answer", "trivia" }, new AnswerTriviaCommand());
		PLUGIN.putIfAbsent(new String[] { "staff", "staffonline" }, new StaffCommand());
		PLUGIN.putIfAbsent(new String[] { "forums", "website" }, new ForumCommand());
		PLUGIN.putIfAbsent(new String[] { "discord", "discords" }, new DiscordCommand());
		PLUGIN.putIfAbsent(new String[] { "stuck", "stucks" }, new StuckCommand());
		PLUGIN.putIfAbsent(new String[] { "wests", "west" }, new Wests());
		PLUGIN.putIfAbsent(new String[] { "mb", "magebank" }, new MageBankCommand());
		PLUGIN.putIfAbsent(new String[] { "gd", "gdz" }, new GdzCommand());
		PLUGIN.putIfAbsent(new String[] { "slayertask", "task" }, new SlayerTaskCommand());
		PLUGIN.putIfAbsent(new String[] { "players", "online" }, new PlayerCountCommand());
		PLUGIN.putIfAbsent(new String[] { "empty", "emptyinventory" }, new EmptyInventoryCommand());
		PLUGIN.putIfAbsent(new String[] { "dusties", "dusti" }, new DustiesCommand());
		PLUGIN.putIfAbsent(new String[] { "testdonation", "donatings" }, new ClaimDonationCommand());
		PLUGIN.putIfAbsent(new String[] { "key", "security" }, new KeyCommand());


		/*
		 * @Donator Command
		 */

		PLUGIN.putIfAbsent(new String[] { "bank", "banks" }, new DonatorBankCommand());
		PLUGIN.putIfAbsent(new String[] { "donatorzone", "dzone" }, new DZoneCommand());
		PLUGIN.putIfAbsent(new String[] { "portals", "portalzone" }, new PortalsZoneCommand());
		PLUGIN.putIfAbsent(new String[] { "yell", "shout" }, new DonatorYellCommand());

		/**
		 * @Moderator/Helper Commands
		 */

		PLUGIN.putIfAbsent(new String[] { "mute", "mutee" }, new MuteCommand());
		PLUGIN.putIfAbsent(new String[] { "unmute", "unmutee" }, new UnmuteCommand());
		PLUGIN.putIfAbsent(new String[] { "jail", "jaill" }, new JailCommand());
		PLUGIN.putIfAbsent(new String[] { "unjail", "unjaill" }, new UnjailCommand());
		PLUGIN.putIfAbsent(new String[] { "privatezone", "staffzone" }, new PrivateZoneCommand());
		PLUGIN.putIfAbsent(new String[] { "teleto", "t2", "tele2" }, new TeletoCommand());
		PLUGIN.putIfAbsent(new String[] { "teletome", "t2m", "tele2me" }, new TeletomeCommand());

		/*
		 * @Owner, @Developer Commands
		 */
		PLUGIN.putIfAbsent(new String[] { "scratch" }, new ScratchNig());
		PLUGIN.putIfAbsent(new String[] { "item" }, new ItemCommand());
		PLUGIN.putIfAbsent(new String[] { "master" }, new MasterCommand());
		PLUGIN.putIfAbsent(new String[] { "instance" }, new DeveloperInstanceCommand());
		PLUGIN.putIfAbsent(new String[] { "customs" }, new SpawnCustomCommand());
		PLUGIN.putIfAbsent(new String[] { "defaultbank" }, new DefaultBankCommand());
		PLUGIN.putIfAbsent(new String[] { "master", "max" }, new MasterCommand());
		PLUGIN.putIfAbsent(new String[] { "find", "finditem" }, new FindCommand());
		PLUGIN.putIfAbsent(new String[] { "anim", "animation" }, new AnimationCommand());
		PLUGIN.putIfAbsent(new String[] { "gfx", "graphic" }, new GraphicCommand());
		PLUGIN.putIfAbsent(new String[] { "spec", "special" }, new SpecCommand());
		PLUGIN.putIfAbsent(new String[] { "pnpc", "transform" }, new PnpcCommand());
		PLUGIN.putIfAbsent(new String[] { "up", "high" }, new UpCommand());
		PLUGIN.putIfAbsent(new String[] { "down", "low" }, new DownCommand());
		PLUGIN.putIfAbsent(new String[] { "god", "beast" }, new GodCommand());
		PLUGIN.putIfAbsent(new String[] { "interface", "int" }, new InterfaceCommand());
		PLUGIN.putIfAbsent(new String[] { "npc", "spawnnpc" }, new NpcCommand());
		PLUGIN.putIfAbsent(new String[] { "guide", "openguide" }, new PlayerGuideCommand());
		PLUGIN.putIfAbsent(new String[] { "obj", "object" }, new ObjectCommand());
		PLUGIN.putIfAbsent(new String[] { "arenas", "spawnarena" }, new ArenaSpawnCommand());
		PLUGIN.putIfAbsent(new String[] { "galveks", "spawngalvek" }, new GalvekSpawnCommand());
		PLUGIN.putIfAbsent(new String[] { "justicars", "spawnjusticar" }, new JusticarSpawnCommand());
		PLUGIN.putIfAbsent(new String[] { "skotizos", "spanwskotizo" }, new SkotizoSpawnCommand());
		PLUGIN.putIfAbsent(new String[] { "show", "showboss" }, new EventBossInterfaceShow());
		PLUGIN.putIfAbsent(new String[] { "hide", "hideboss" }, new EventBossInterfaceHide());
		PLUGIN.putIfAbsent(new String[] { "giveall", "give" }, new GiveAllCommand());
		PLUGIN.putIfAbsent(new String[] { "update", "udpateserver" }, new UpdateCommand());
		PLUGIN.putIfAbsent(new String[] { "removetask", "slayer" }, new RemovePlayerTask());
		PLUGIN.putIfAbsent(new String[] { "randomevent", "randomeven" }, new RandomEvent());
		PLUGIN.putIfAbsent(new String[] { "teleall", "all2me" }, new AllToMeCommand());
		PLUGIN.putIfAbsent(new String[] { "broadcast", "announcement" }, new BroadcastCommand());
		PLUGIN.putIfAbsent(new String[] { "kill", "killplayer" }, new KillCommand());

		for (Entry<String[], Command> map : PLUGIN.entrySet()) {
			for (int i = 0; i < map.getKey().length; i++) {
				PLUGIN_INPUT.putIfAbsent(map.getKey()[i], map.getValue());
			}
		}

		System.out.println("[Commands] Loaded " + PLUGIN.size() + " Commands");
	}
}
