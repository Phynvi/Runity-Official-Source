package io.battlerune.content.eventboss;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.battlerune.Config;
import io.battlerune.game.task.Task;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.util.Stopwatch;

/**
 * Handles the boss event
 * 
 * @author Nerik#8690
 *
 */
public class EventBossHandler extends Task {

	/**
	 * Constructor (Delay)
	 */
	public EventBossHandler() {
		super(1);
	}

	/**
	 * Timer for the boss event to start <10 minutes>
	 */
	private int counter;

	/**
	 * Stores the boss event data
	 */
	private EventBossData event = null;

	public void setEvent(EventBossData event) {
		this.event = event;
	}

	@Override
	protected void execute() {
		switch (counter++) {
		case 30: // Sends out message
			World.sendMessage("The boss event will take place in 30 seconds");
			break;
		case 60: // Sets random boss data and starts event
			setEvent(genBoss());
			startEvent();
			break;
		case 90: // Sets event to null and cancels the task
			setEvent(null);
			endEvent();
			cancel();
			break;
		}
	}

	/**
	 * Starts the event
	 */
	private void startEvent() {
		Npc npc = new Npc(event.getNpcId(), event.getPos(), Config.NPC_WALKING_RADIUS);
		npc.register();
		World.sendMessage("[Boss Event] The boss event has started!");
		World.getPlayers().forEach(player -> {
			if (player != null) {
				player.sendTeleportButton();
				player.sendTeleportButtonNpc(event.getNpcId());
			}
		});
	}

	private void endEvent() {
		// Npc npc = new Npc(event.getNpcId(), event.getPos(),
		// Config.NPC_WALKING_RADIUS);
		// npc.unregister();
		World.sendMessage("[Boss Event] The boss event has ended!");
		World.getPlayers().forEach(player -> {
			if (player != null) {
				player.hideTeleportButton();
			}
		});
	}

	/**
	 * Fetches random boss data
	 * 
	 * @return
	 */
	private EventBossData genBoss() {
		Random random = new Random();
		return EventBossData.values()[random.nextInt(EventBossData.values().length)];
	}
}
