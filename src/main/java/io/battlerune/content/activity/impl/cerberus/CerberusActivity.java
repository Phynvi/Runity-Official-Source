package io.battlerune.content.activity.impl.cerberus;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import io.battlerune.Config;
import io.battlerune.content.achievement.AchievementHandler;
import io.battlerune.content.achievement.AchievementKey;
import io.battlerune.content.activity.Activity;
import io.battlerune.content.activity.ActivityType;
import io.battlerune.content.event.impl.ObjectInteractionEvent;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.Direction;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.npc.NpcDeath;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;


public class CerberusActivity extends Activity {

	private final Player player;
	public Npc cerberus = null;
	private boolean completed;
	public Set<Npc> ghosts = new HashSet<>();
	private final CerberusActivityListener listener = new CerberusActivityListener(this);

	private static final int CERBERUS = 5862;
	private static final Position CERBERUS_POS = new Position(1238, 1250);

	private CerberusActivity(Player player, int instance) {
		super(1, instance);
		this.player = player;
	}

	public static CerberusActivity create(Player player) {
		CerberusActivity minigame = new CerberusActivity(player, player.playerAssistant.instance());
		minigame.add(player);
		player.gameRecord.start();
		return minigame;
	}

	@Override
	public void onDeath(Mob mob) {
		if (mob.isPlayer() && mob.equals(player)) {
			player.send(new SendMessage("Better luck next time!"));
			cleanup();
			remove(player);
			return;
		}
		if (mob.isNpc() && mob.getNpc().id == CERBERUS) {
			World.schedule(new NpcDeath(mob.getNpc(), () -> {
				completed = true;
				finish();
			}));
			return;
		}
		super.onDeath(mob);
	}

	@Override
	public void add(Mob mob) {
		super.add(mob);
		if (mob.isNpc()) {
			if (mob.getNpc().id == CERBERUS) {
				cerberus = mob.getNpc();
			} else {
				ghosts.add(mob.getNpc());
			}
			mob.locking.lock();
		}
	}

	@Override
	public void remove(Mob mob) {
		if (!mob.isNpc()) {
			super.remove(mob);
			return;
		}
		int id = mob.getNpc().id;
		if (id == CERBERUS) {
			cerberus = null;
			 Teleportation.teleport(player, Config.DEFAULT_POSITION, 20, () -> {
                 player.send(new SendMessage("Welcome to the donator zone, " + player.getName() + "!"));
             });
		} else {
			ghosts.remove(mob.getNpc());
		}
		super.remove(mob);
	}

	@Override
	protected void start() {
		Npc npc = new Npc(CERBERUS, CERBERUS_POS);
		npc.face(player);
		npc.owner = player;
		add(npc);
		player.face(cerberus.getPosition());
		pause();
	}

	@Override
	public void onLogout(Player player) {
		player.move(Config.DEFAULT_POSITION);
		cleanup();
		finish();
	}

	@Override
	public void onRegionChange(Player player) {
		if (!Area.inCerberus(player)) {
			cleanup();
			finish();
		}
	}

	@Override
	public boolean canTeleport(Player player) {
		return true;
	}

	@Override
	public void finish() {
		cleanup();

		if (completed) {
			player.send(new SendMessage("Congratulations, you have killed the Cerberus."));
					//+ Utility.getTime(player.gameRecord.end(ActivityType.CERBERUS)) + "</col>."));
		} else {
			player.gameRecord.end(ActivityType.CERBERUS, false);
		}

		remove(player);
		player.message("Please teleport back to Cerberus to fight him again!");
	}

	@Override
	public void cleanup() {
		if (cerberus != null && cerberus.isRegistered())
			cerberus.unregister();
		Iterator<Npc> it = ghosts.iterator();
		while (it.hasNext()) {
			Npc npc = it.next();
			npc.animate(npc.definition.getDeathAnimation());
			World.schedule(3, npc::unregister);
			it.remove();
		}
	}

	@Override
	protected boolean clickObject(Player player, ObjectInteractionEvent event) {
		return true;
	}

	@Override
	public ActivityType getType() {
		return ActivityType.CERBERUS;
	}

	@Override
	protected Optional<CerberusActivityListener> getListener() {
		return Optional.of(listener);
	}
}