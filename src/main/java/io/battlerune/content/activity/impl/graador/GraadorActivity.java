package io.battlerune.content.activity.impl.graador;

import java.util.Optional;

import io.battlerune.Config;
import io.battlerune.content.ActivityLog;
import io.battlerune.content.activity.Activity;
import io.battlerune.content.activity.ActivityDeathType;
import io.battlerune.content.activity.ActivityType;
import io.battlerune.content.event.impl.ObjectInteractionEvent;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.npc.NpcDeath;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;


/**
 * 
 * @author Adam_#6723
 *
 */

public class GraadorActivity extends Activity {

	private final Player player;
	public Npc graador = null;
	private final GraadorActivityListener listener = new GraadorActivityListener(this);

	private static final int BOSS = 2215;
	private static final Position BOSS_POS = new Position(2870, 5358, 2);

	private GraadorActivity(Player player, int instance) {
		super(1, instance);
		this.player = player;
	}

	public static GraadorActivity create(Player player) {
		GraadorActivity minigame = new GraadorActivity(player, player.playerAssistant.instance());
		minigame.add(player);
		return minigame;
	}

	public static void CreatePaidInstance(Player player) {
		if (!player.bank.contains(995, 75000)) {
			player.message("You need to have 75,000 coins inside your bank to pay for the instance!");
			return;
		} else {
			player.bank.remove(995, 100000);
			Teleportation.teleport(player, new Position(2870, 5358, 2), 20, () -> create(player));
			player.send(new SendMessage("You have teleported to the Instanced Version of Graador"));
			player.send(new SendMessage("75,000 coins has been taken out of your bank, as a fee."));

		}
	}

	public static void CreateUnPaidInstance(Player player) {
		player.send(new SendMessage("You have teleported to the Non-Instanced Version of Graador"));
		Teleportation.teleport(player, new Position(2870, 5358, 2));
	}

	@Override
	public void add(Mob mob) {
		super.add(mob);
		if (mob.isNpc()) {
			if (mob.getNpc().id == BOSS) {
				graador = mob.getNpc();
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
		if (id == BOSS) {
			graador = null;
			Teleportation.teleport(player, Config.DEFAULT_POSITION, 20, () -> {
				player.send(new SendMessage("Get yo ass back home boi, " + player.getName() + "!"));
			});
		}
		super.remove(mob);
	}

	@Override
	protected void start() {
		Npc npc = new Npc(BOSS, BOSS_POS);
		npc.face(player);
		npc.owner = player;
		add(npc);
		player.face(graador.getPosition());
		pause();
	}

	@Override
	public boolean canTeleport(Player player) {
		return true;
	}

	@Override
	public void finish() {
		boolean successfull = graador.isDead();
		cleanup();
		remove(player);
		if (successfull) {
			player.activityLogger.add(ActivityLog.GENERAL_GRAARDOR);
			player.message("Congratulations, you have killed the General Graador.");
			restart(1, () -> {
				if (Area.inGraador(player)) {
					create(player);
				} else {
					remove(player);
					if (PlayerRight.isDonator(player) || PlayerRight.isSuper(player)) {
						player.setBossPoints(player.getBossPoints() + 2);
						player.message("<img=14>You now have @red@" + player.getBossPoints() + " Boss Points!");

					}

					if (PlayerRight.isExtreme(player) || PlayerRight.isElite(player)) {
						player.setBossPoints(player.getBossPoints() + 3);
						player.message("<img=14>You now have @red@" + player.getBossPoints() + " Boss Points!");

					}
					if (PlayerRight.isKing(player)) {
						player.setBossPoints(player.getBossPoints() + 4);
						player.message("<img=14>You now have @red@" + player.getBossPoints() + " Boss Points!");

					} else {
						player.setBossPoints(player.getBossPoints() + 1);
						player.message("<img=14>You now have @red@" + player.getBossPoints() + " Boss Points!");

					}
				}
			});
		}
	}

	@Override
	public void cleanup() {
		if (graador != null && graador.isRegistered())
			graador.unregister();
	}

	@Override
	protected boolean clickObject(Player player, ObjectInteractionEvent event) {
		return true;
	}

	@Override
	protected Optional<GraadorActivityListener> getListener() {
		return Optional.of(listener);
	}

	@Override
	public void onLogout(Player player) {
		cleanup();
		remove(player);
	}

	@Override
	public void onDeath(Mob mob) {
		if (mob.isNpc() && mob.getNpc().equals(graador)) {
			World.schedule(new NpcDeath(mob.getNpc(), this::finish));
			return;
		}
		super.onDeath(mob);
	}

	@Override
	public void onRegionChange(Player player) {
		if (!Area.inGraador(player)) { //TODO
			cleanup();
			remove(player);
		}
	}

	@Override
	public ActivityDeathType deathType() {
		return ActivityDeathType.PURCHASE;
	}

	@Override
	public ActivityType getType() {
		return ActivityType.GENERAL_GRAADOR_INSTANCE;
	}
}
