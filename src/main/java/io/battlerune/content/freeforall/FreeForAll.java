package io.battlerune.content.freeforall;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.battlerune.content.activity.ActivityType;
import io.battlerune.content.activity.GroupActivity;
import io.battlerune.content.activity.impl.pestcontrol.PestControl;
import io.battlerune.content.freeforall.impl.FreeForAllEndTask;
import io.battlerune.content.freeforall.impl.FreeForAllStartTask;
import io.battlerune.content.freeforall.impl.FreeForAllTask;
import io.battlerune.game.task.Task;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class FreeForAll extends Task {

	private int tick;
	
	public FreeForAll() {
		super(1);
		this.tick = 0;
	}

	@Override
	protected void execute() {
		if (gameStarted) {
			appendTask(new FreeForAllEndTask(), FreeForAllType.GAME);
			return;
		}

		switch (tick) {
		case 1800:
			World.sendBroadcast(1, "<col=354CE6> [Free For All] </col> The Free For All game will start in 10 Minutes!", false);
			break;
		case 2000:
			World.sendBroadcast(1, "<col=354CE6> [Free For All] </col> The Free For All lobby has been opened!", false);
			break;
		case 2400:
			 if (getCount(FreeForAllType.LOBBY) < 4) {
				this.tick = 0;
				message(FreeForAllType.LOBBY, "[Free For All] Couldn't start to low participant count!");
				return;
			} 

			appendTask(new FreeForAllStartTask(), FreeForAllType.LOBBY);
			
			break;
		}

		tick++;
		
		System.out.println("Count: " + tick);
	}

	private static void appendTask(FreeForAllTask task, FreeForAllType type) {
		KEY_MAP.keySet().forEach(player -> {
			if (player != null) {
				if (task != null) {
					if (KEY_MAP.get(player).equals(type)) {
						task.execute(player);
					}
				}
			}
		});
	}

	public static int getCount(FreeForAllType type) {
		switch (type) {
		case LOBBY:
			KEY_MAP.keySet().forEach(player -> {
				if (KEY_MAP.get(player).equals(FreeForAllType.LOBBY)) {
					lobbyCount++;
				}
			});
			return lobbyCount;
		case GAME:
			KEY_MAP.keySet().forEach(player -> {
				if (KEY_MAP.get(player).equals(FreeForAllType.GAME)) {
					gameCount++;
				}
			});
			return gameCount;
		}
		return 0;
	}

	private static void message(FreeForAllType type, String content) {
		KEY_MAP.keySet().forEach(player -> {
			if (KEY_MAP.get(player).equals(type)) {
				player.send(new SendMessage(content));
			}
		});
	}

	public static FreeForAllType getType(Player player) {
		return KEY_MAP.get(player);
	}
	
	private static boolean gameStarted;
	private static int lobbyCount;
	private static int gameCount;
	public static Map<Player, FreeForAllType> KEY_MAP = new HashMap<Player, FreeForAllType>();

}
