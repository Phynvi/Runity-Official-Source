package io.battlerune.content;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import io.battlerune.Config;
import io.battlerune.game.world.World;

/**
 * Adam did all obvious
 * 
 * @author Adam
 *
 */
public class DailyBonus {

	protected int count;

	public DailyBonus(int count) {
		this.count = count;
	}

	public void execute() {
		TimerTask task = new TimerTask() {
			int tick = 0;

			@Override
			public void run() {
				switch (tick++) {
				case 86400:
					load();
					tick = 0;
					break;
				}
			}

		};

		Timer timer = new Timer();
		timer.schedule(task, 1000, 1000);
	}

	public static void load() {
		Calendar calendar = new GregorianCalendar();
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1: // sunday
			Config.DOUBLE_EXPERIENCE = true;
			World.sendBroadcast(60, "[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours!");
			break;
		case 2: // monday
			Config.DOUBLE_EXPERIENCE = false;
			Config.DR_15_BOOST = true;
			World.sendBroadcast(60, "[DAILY SERVER EVENTS] 15% Drop Rate Boost Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours! 2");

			break;
		case 3: // tuesday
			Config.DOUBLE_EXPERIENCE = false;
			Config.DR_15_BOOST = false;
			Config.DOUBLE_PK_POINTS = true;
			World.sendBroadcast(60, "[DAILY SERVER EVENTS] Double PK Points Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours! 3");

			break;
		case 4: // wednesday
			Config.DOUBLE_PK_POINTS = false;
			Config.DOUBLE_AVO_POINTS = true;
			World.sendBroadcast(60,
					"[DAILY SERVER EVENTS] Double Tickets at AvO Minigame Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours! 4");

			break;
		case 5: // thursday
			Config.DOUBLE_AVO_POINTS = true;
			World.sendBroadcast(60,"[DAILY SERVER EVENTS] Double Tickets at AvO Minigame Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours! 5");

			break;
		case 6: // friday
			Config.DOUBLE_AVO_POINTS = false;
			Config.DR_30_BOOST = true;
			World.sendBroadcast(60, "[DAILY SERVER EVENTS] 30% Drop Rate Boost Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours! 6");

			break;
		case 7: // saturday
			Config.DR_30_BOOST = false;
			Config.DOUBLE_EXPERIENCE = true;
			World.sendBroadcast(60, "[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours!", false);
			System.out.println("[DAILY SERVER EVENTS] Double Experience Is Now Activated for 24 Hours! 7");
			break;
		}
	}
}
