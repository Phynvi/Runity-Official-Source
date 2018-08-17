package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.task.Task;
import io.battlerune.game.task.TaskManager;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;

public class MysteryBox implements MysteryBoxListener {

	@Override
	public Item[] getCommon() {
		return new Item[] { new Item(1, 10), new Item(995, 10), new Item(4151, 1) };
	}

	@Override
	public Item[] getUncommon() {
		return null;
	}

	@Override
	public Item[] getRare() {
		return null;
	}

	@Override
	public Item[] getUltra() {
		return null;
	}

	@Override
	public void execute(Player player) {
		TaskManager.schedule(new Task(1) {
			int tick = 0;

			@Override
			protected void execute() {
				switch (tick) {
				case 1:
					player.message("Loading Goodluck Spinner....");
					break;
				case 3:
					player.message("Finishing It Up!");
					break;
				case 4:
					Random random = new Random();
					player.inventory.add(getCommon()[random.nextInt(getCommon().length)]);
					break;
				}
				tick++;
			}

		});
	}

}
