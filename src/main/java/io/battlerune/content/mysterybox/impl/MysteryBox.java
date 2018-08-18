package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.task.Task;
import io.battlerune.game.task.TaskManager;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.util.Utility;

public class MysteryBox implements MysteryBoxListener {
	int randomAmount = Utility.random(1000000, 2500000);
	int randomAmount1 = Utility.random(2500000, 3500000);
	int randomAmount2 = Utility.random(3500000, 5000000);
	int randomAmount3 = Utility.random(5000000, 50000000);


	@Override
	public Item[] getCommon() {
		return new Item[] { new Item(995, randomAmount), new Item(4151, 1) };
	}

	@Override
	public Item[] getUncommon() {
		return new Item[] { new Item(995, randomAmount1), new Item(4151, 1) };
	}

	@Override
	public Item[] getRare() {
		return new Item[] { new Item(995, randomAmount2), new Item(4151, 1) };
	}

	@Override
	public Item[] getUltra() {
		return new Item[] { new Item(995, randomAmount3), new Item(4151, 1) };
	}

	@Override
	public void execute(Player player) {
		TaskManager.schedule(new Task(1) {
			int tick = 0;

			@Override
			protected void execute() {
				switch (tick) {
				case 1:
					Random random = new Random();
					player.inventory.remove(6199, 1);
					
					if(Utility.random(1, 100) <= 10) {
					player.inventory.add(getUncommon()[random.nextInt(getCommon().length)]);
					player.message("You have recieved a Uncommon loot!");
					}
					if(Utility.random(1, 200) <= 7) {
						player.inventory.add(getRare()[random.nextInt(getCommon().length)]);
						player.message("@gre@You have recieved a Rare loot!");
					}
					if(Utility.random(1, 300) <= 5) {
						player.inventory.add(getUltra()[random.nextInt(getCommon().length)]);
						player.message("You have recieved a ULTRA RARE LOOT!");
                        World.sendMessage(player.getName() + " @red@Has received ULTRA RARE LOOT!");
					} else {
						player.inventory.add(getCommon()[random.nextInt(getCommon().length)]);
					}
					break;
				}
				//tick++;
			}

		});
	}

}
