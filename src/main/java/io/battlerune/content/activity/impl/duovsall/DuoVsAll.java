package io.battlerune.content.activity.impl.duovsall;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import io.battlerune.Config;
import io.battlerune.content.ActivityLog;
import io.battlerune.content.activity.Activity;
import io.battlerune.content.activity.ActivityListener;
import io.battlerune.content.activity.ActivityType;
import io.battlerune.content.activity.impl.duovsall.DuoVsAllData.WaveData;
import io.battlerune.content.activity.panel.ActivityPanel;
import io.battlerune.content.pet.PetData;
import io.battlerune.content.pet.Pets;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.ground.GroundItem;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

/** @author Adam_#6723 
 *  Handles the Double Threat Minigame!
 */

public class DuoVsAll extends Activity {

	/** The player in the All Vs One. */
	private  Player player;

	private  Player other;
	
	/** The activity completed flag. */
	private boolean completed;

	/** The time it took to complete the activity. */
	private long time;

	/** The amount of tokkuls the player has acquired. */
	private int rewards;

	/** A set of npcs in this activity. */
	public final Set<Npc> npcs = new HashSet<>();

	/** The current wave of this activity. */
	private DuoVsAllData.WaveData wave = DuoVsAllData.WaveData.WAVE_1;

	/** The combat listener to add for all mobs. */
	private final DuoVsAllCavesListener listener = new DuoVsAllCavesListener(this);

	/**
	 * Constructs a new {@code AllVsOne} object for a {@code player} and an
	 * {@code instance}.
	 */
	public DuoVsAll(Player player, int instance, Player other) {
		super(10, instance);
		this.player = player;
		this.other = other;
	}
	


	public static DuoVsAll create(Player player, Player other) {
		DuoVsAll minigame = new DuoVsAll(player, player.playerAssistant.instance(), other);

		player.move(new Position(3169, 4958, player.getHeight()));
		other.move(player.getPosition());
		
		ActivityPanel.update(player, -1, "Double Threat", "Activity Completion:", "Good Luck, " + player.getName() + "!");
		player.dialogueFactory.sendNpcChat(5567, "Welcome to the Double Threat, #name.",
				"There are a total of 69 waves, Galvek & Glod being the last.",
				"Use your activity panel (bottom left tab) for wave information.", "Good luck!").execute();
		
		ActivityPanel.update(other, -1, "Double Threat", "Activity Completion:", "Good Luck, " + other.getName() + "!");
		other.dialogueFactory.sendNpcChat(5567, "Welcome to the Double Threat, #name.",
				"There are a total of 69 waves, Galvek & Glod being the last.",
				"Use your activity panel (bottom left tab) for wave information.", "Good luck!").execute();
		
		minigame.time = System.currentTimeMillis();
		minigame.add(player);
		minigame.add(other);
		minigame.resetCooldown();
		return minigame;
	}
	
	public static int[] GENERATED_LOOT = { 22090, 22089, 22088, 22091 };

	public static void createRandomGroundItems(Player player) {
		if (Utility.random(1, 2) <= 1) {
			GroundItem.createGlobal(player, new Item(GENERATED_LOOT[Utility.random(GENERATED_LOOT.length)], 1),
					new Position(2558 + Utility.random(1, 15), 4960 + Utility.random(1, 15), player.getPosition().getHeight()));
			player.message("@red@ A Dragon piece key has been dropped in a random location!");
			player.message("@red@ Find all four pieces to make the key to complete this minigame!");
		}
	}

	/** Handles what happens to a mob when they die in the activity. */
	void handleDeath(Mob dead) {
		if (dead.isPlayer() && (dead.equals(player) || dead.equals(other) && other.isPlayer())) {
			finish();
			return;
		}
		if (dead.isNpc() && npcs.contains(dead)) {
			if (dead.id == 3162) {
				remove(dead);
				npcs.remove(dead);
				for (int index = 0; index < 2; index++) {
					Position position = new Position(dead.getX() + (index == 0 ? -1 : +1), dead.getY(),
							dead.getHeight());
					Npc roc = new Npc(763, position);
					add(roc);
					npcs.add(roc);
					roc.getCombat().attack(player);
					roc.getCombat().attack(other);
				}
				return;
			}

			npcs.remove(dead);
			remove(dead);
			rewards += Utility.random(3250, 5500);
			if (npcs.isEmpty()) {
				wave = DuoVsAllData.WaveData.getNext(wave.ordinal());
				if (wave == null) {
					completed = true;
					player.send(new SendMessage("You have finished the activity!"));
					other.send(new SendMessage("You have finished the activity!"));
				} else {
					player.send(new SendMessage("The next wave will commence soon."));
					other.send(new SendMessage("The next wave will commence soon."));
				}
				resetCooldown();
				return;
			}
		}
	}

	@Override
	protected void start() {
		if (wave == null) {
			finish();
			return;
		}
		if (player.locking.locked()) {
			return;
		}
		if (other.locking.locked()) {
			return;
		}

		Position spawn = new Position(3169, 4958, player.getHeight());
		Position[] boundaries = Utility.getInnerBoundaries(spawn, Utility.random(1, 8), Utility.random(1, 8));

		for (int id : wave.getMonster()) {
			Npc npc = new Npc(id, RandomUtils.random(boundaries));
			//npc.owner = player;
			add(npc);
			npcs.add(npc);
			npc.getCombat().attack(player);
			npc.face(player);
			player.face(npc.getPosition());
			
			npc.getCombat().attack(other);
			npc.face(other);
			other.face(npc.getPosition());
			npc.locking.unlock();
			//pause();
		}
		if (wave == WaveData.WAVE_7 || wave == WaveData.WAVE_11 || wave == WaveData.WAVE_15 || wave == WaveData.WAVE_23
				|| wave == WaveData.WAVE_25 || wave == WaveData.WAVE_32 || wave == WaveData.WAVE_40
				|| wave == WaveData.WAVE_45 || wave == WaveData.WAVE_50 || wave == WaveData.WAVE_55
				|| wave == WaveData.WAVE_60 || wave == WaveData.WAVE_67) {
			//createRandomGroundItems(player);
		}
		pause();
	}

	@Override
	public void finish() {
		cleanup();
		remove(player);
		player.move(new Position(3086, 3501, 0));
		remove(other);
		other.move(new Position(3086, 3501, 0));

		if (completed) {
			player.dialogueFactory.sendNpcChat(5567, "You have defeated Double Threat, I am most impressed!",
					"Please accept this gift, young thug.").execute();
			
			other.dialogueFactory.sendNpcChat(5567, "You have defeated Double Threat, I am most impressed!",
					"Please accept this gift, young thug.").execute();
			rewards += 20000;
			if(Config.DOUBLE_AVO_POINTS == true) {
	            player.inventory.addOrDrop(new Item(7775, rewards));
	            player.message("You've recieved double Tickets because of the daily server events!");
	            other.inventory.addOrDrop(new Item(7775, rewards));
	            other.message("You've recieved double Tickets because of the daily server events!");
			}
            player.inventory.addOrDrop(new Item(7775, rewards));
            other.inventory.addOrDrop(new Item(7775, rewards));

            
    		player.message("<img=8>You now have @red@" + rewards + " Double Threat Tickets!");
    		other.message("<img=8>You now have @red@" + rewards + " Double Threat Tickets!");

			player.inventory.addOrDrop(new Item(6855, 1));
			other.inventory.addOrDrop(new Item(6833, 1));

			player.send(new SendMessage("You have completed the Double Threat activity. Final time: @red@"
					+ Utility.getTime(time) + "</col>."));
			
			other.send(new SendMessage("You have completed the Double Threat activity. Final time: @red@"
					+ Utility.getTime(time) + "</col>."));
			player.activityLogger.add(ActivityLog.Double_Threat);
			other.activityLogger.add(ActivityLog.Double_Threat);
			player.setAllForOnePartner(null);
			other.setAllForOnePartner(null);
			return;
		}

		if (rewards <= 0)
			rewards = 6;
        player.inventory.addOrDrop(new Item(7775, rewards / 2));
		player.message("<img=9>You now have @red@" + rewards + " All Vs One Tickets!");
		player.message("bare in mind, your rewards have been halved since you died whilst in the minigame!");
		player.dialogueFactory.sendNpcChat(5567, "Better luck next time!", "Take these points as a reward.").execute();
		
        other.inventory.addOrDrop(new Item(7775, rewards / 2));
        other.message("<img=9>You now have @red@" + rewards + " All Vs One Tickets!");
        other.message("bare in mind, your rewards have been halved since you died whilst in the minigame!");
        other.dialogueFactory.sendNpcChat(5567, "Better luck next time!", "Take these points as a reward.").execute();
		player.setAllForOnePartner(null);
		other.setAllForOnePartner(null);
	}

	@Override
	public void cleanup() {
		ActivityPanel.clear(player);
		ActivityPanel.clear(other);
		if (!npcs.isEmpty())
			npcs.forEach(this::remove);
	}

	@Override
	public void update() {
		if (wave == null) {
			ActivityPanel.update(player, 100, "Double Threat", new Item(11642), "Congratulations, you have",
					"completed the Double Threat", "activity!");
			
			ActivityPanel.update(other, 100, "Double Threat", new Item(11642), "Congratulations, you have",
					"completed the Double Threat", "activity!");
			return;
		}
		int progress = (int) Utility.getPercentageAmount(wave.ordinal() + 1, DuoVsAllData.WaveData.values().length);
		if (progress >= 100 && !completed)
			progress = 99;
		ActivityPanel.update(player, progress, "Double Threat", new Item(11642),
				"</col>Wave: <col=FF5500>" + (wave.ordinal() + 1) + "/" + (DuoVsAllData.WaveData.values().length),
				"</col>Monsters Left: <col=FF5500>" + npcs.size(),
				"</col>Points Gained: <col=FF5500>" + Utility.formatDigits(rewards),
				"</col>Time: <col=FF5500>" + Utility.getTime());
		
		ActivityPanel.update(other, progress, "Double Threat", new Item(11642),
				"</col>Wave: <col=FF5500>" + (wave.ordinal() + 1) + "/" + (DuoVsAllData.WaveData.values().length),
				"</col>Monsters Left: <col=FF5500>" + npcs.size(),
				"</col>Points Gained: <col=FF5500>" + Utility.formatDigits(rewards),
				"</col>Time: <col=FF5500>" + Utility.getTime());
	}

	@Override
	public boolean canTeleport(Player player) {
		return true;
	}

	@Override
	public void onRegionChange(Player player) {
		if (!Area.inDuoVsAll(player) || !Area.inDuoVsAll(other)) {
			cleanup();
			remove(player);
			remove(other);
			player.send(new SendMessage("You have lost your current progress as you have teleported."));
			other.send(new SendMessage("You have lost your current progress as you have teleported."));
			other.setAllForOnePartner(null);
			player.setAllForOnePartner(null);
		}
	}

	@Override
	public void onLogout(Player player) {
		finish();
		remove(player);
		remove(other);
		player.setAllForOnePartner(null);
		other.setAllForOnePartner(null);
	}

	@Override
	public ActivityType getType() {
		return ActivityType.Double_Threat;
	}

	@Override
	public Optional<? extends ActivityListener<? extends Activity>> getListener() {
		return Optional.of(listener);
	}
}
