package io.battlerune.content.command;

import java.util.*;
import java.util.Map.Entry;

import plugin.command.impl.donator.*;
import plugin.command.impl.moderator.*;
import plugin.command.impl.owner.*;
import plugin.command.impl.player.*;

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
		PLUGIN.putIfAbsent(new String[] { "thread" }, new ThreadCommand());
		PLUGIN.putIfAbsent(new String[] { "ancients" }, new AncientsCommand());
		PLUGIN.putIfAbsent(new String[] { "maxhit" }, new MaxStatusCommand());
		PLUGIN.putIfAbsent(new String[] { "changepassword" }, new ChangePassword());
		PLUGIN.putIfAbsent(new String[] { "easts" }, new Easts());
		PLUGIN.putIfAbsent(new String[] { "commands", "command" }, new Commands());
		PLUGIN.putIfAbsent(new String[] { "home", "hom" }, new HomeCommand());
		PLUGIN.putIfAbsent(new String[] { "train", "training" }, new TrainZone());
		PLUGIN.putIfAbsent(new String[] { "pouch" }, new PouchCommand());
		PLUGIN.putIfAbsent(new String[] { "shops", "shop", }, new ShopCommand());
		PLUGIN.putIfAbsent(new String[] { "drops", "drop", "droplist", "droptable" }, new DropsCommand());
		PLUGIN.putIfAbsent(new String[] { "simulate", "simulator" }, new DropSimulatorCommand());
		PLUGIN.putIfAbsent(new String[] { "vote" }, new VoteCommand());
		PLUGIN.putIfAbsent(new String[] { "skull" }, new SkullCommand());
		PLUGIN.putIfAbsent(new String[] { "duel", "duelarena" }, new DuelArenaCommand());
		PLUGIN.putIfAbsent(new String[] { "barrows" }, new BarrowsCommand());
		PLUGIN.putIfAbsent(new String[] { "skill", "skillingarea" }, new SkillAreaCommand());
		PLUGIN.putIfAbsent(new String[] { "claim", "donated" }, new ClaimDonationCommand());
		PLUGIN.putIfAbsent(new String[] { "donate", "store", "Store" }, new DonateCommand());
		PLUGIN.putIfAbsent(new String[] { "voted", "claimvote" }, new ClaimVote());
		PLUGIN.putIfAbsent(new String[] { "vault", "vaultamount" }, new VaultCommand());
		PLUGIN.putIfAbsent(new String[] { "drops", "drop" }, new DropInterfaceCommand());
		PLUGIN.putIfAbsent(new String[] { "gamble", "gamblezone" }, new GambleCommand());
		PLUGIN.putIfAbsent(new String[] { "arena", "arenazone" }, new ArenaZoneCommand());
		PLUGIN.putIfAbsent(new String[] { "testt", "test" }, new CashOutCommand());
		PLUGIN.putIfAbsent(new String[] { "help" }, new Helpcommand());
		PLUGIN.putIfAbsent(new String[] { "answer", "trivia" }, new AnswerTriviaCommand());
		PLUGIN.putIfAbsent(new String[] { "staff", "staffonline" }, new StaffCommand());
		PLUGIN.putIfAbsent(new String[] { "forums", "forum" }, new ForumCommand());
		PLUGIN.putIfAbsent(new String[] { "discord" }, new DiscordCommand());
		PLUGIN.putIfAbsent(new String[] { "stuck" }, new StuckCommand());
		PLUGIN.putIfAbsent(new String[] { "wests", "west" }, new Wests());
		PLUGIN.putIfAbsent(new String[] { "mb", "magebank" }, new MageBankCommand());
		PLUGIN.putIfAbsent(new String[] { "gd", "gdz" }, new GdzCommand());
		PLUGIN.putIfAbsent(new String[] { "slayertask", "task" }, new SlayerTaskCommand());
		PLUGIN.putIfAbsent(new String[] { "players", "online" }, new PlayerCountCommand());
		PLUGIN.putIfAbsent(new String[] { "empty", "emptyinventory" }, new EmptyInventoryCommand());
		PLUGIN.putIfAbsent(new String[] { "dusties", "dusti" }, new DustiesCommand());
		PLUGIN.putIfAbsent(new String[] { "key", "security" }, new KeyCommand());
		PLUGIN.putIfAbsent(new String[] { "galvek", "Galvek" }, new GalvekCommands());
		PLUGIN.putIfAbsent(new String[] { "es", "ed" }, new EZCommandZone());
		PLUGIN.putIfAbsent(new String[] { "barrowsfix", "bugfix" }, new BarrowsFix());
		PLUGIN.putIfAbsent(new String[] { "revs", "revcave" }, new RevenantCaveCommand());
		PLUGIN.putIfAbsent(new String[] { "giveaways", "giveaway"}, new YouTubeCommand());

		/*
		 * @Donator Command
		 */
		PLUGIN.putIfAbsent(new String[] { "sponsor", "sponsorstore" }, new SponsorStoreCommand());
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
		PLUGIN.putIfAbsent(new String[] { "bann", "ban", "ruin" }, new BanCommand());
		PLUGIN.putIfAbsent(new String[] { "unban", "unbann" }, new Unbancommand());
		PLUGIN.putIfAbsent(new String[] { "kick", "kickk" }, new KickCommand());
		PLUGIN.putIfAbsent(new String[] { "ipban", "ip" }, new IpbanCommand());
		PLUGIN.putIfAbsent(new String[] { "ipmute", "imute" }, new IpmuteCommand());
		


		/*
		 * @Owner, @Developer Commands
		 */
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
		PLUGIN.putIfAbsent(new String[] { "tele" }, new TeleCommand());
		PLUGIN.putIfAbsent(new String[] { "tele1" }, new TeleCommand1());
		PLUGIN.putIfAbsent(new String[] { "pos" }, new posCommand());

		PLUGIN.putIfAbsent(new String[] { "giverank" }, new GiveRankCommand());
		PLUGIN.putIfAbsent(new String[] { "Saveall", "saveall" }, new SaveAll());

		
		for (Entry<String[], Command> map : PLUGIN.entrySet()) {
			for (int i = 0; i < map.getKey().length; i++) {
				PLUGIN_INPUT.putIfAbsent(map.getKey()[i], map.getValue());
			}
		}

		System.out.println("[Commands] Loaded " + PLUGIN.size() + " Commands");
	}
}
