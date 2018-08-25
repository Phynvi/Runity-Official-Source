package io.battlerune.content.scratchcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendItemOnInterface;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendString;
import io.battlerune.util.Utility;

public class ScratchCard {

	private Player player;

	public ScratchCard(Player player) {
		this.player = player;
	}

	public void display() {

		if (player.inventory.contains(455)) { // this is actually a double check as the itemclick already checks but just incase
			
			player.inventory.remove(new Item(455, 1)); 

			cleanInterface();

			player.interfaceManager.open(20011);

			COMBINATION.add(new ScratchCardCombination(new ScratchCardInstanced(20016, getRandom()),
					new ScratchCardInstanced(20021, getRandom()), new ScratchCardInstanced(20026, getRandom())));
		}

	}

	/**
	 * On {@code display}
	 */
	private void cleanInterface() {

		COMBINATION.clear();
		COMBINATION_COUNT.clear();

		for (int j = 20020; j < 20035; j += 5) {
			player.send(new SendItemOnInterface(j));
		}

		for (int i = 20019; i < 20036; i += 5) {
			player.send(new SendString("$", i));
		}

		player.send(new SendItemOnInterface(20036, new Item(6199)));
		player.send(new SendString("Match 3 to Win!", 20014));
	}

	/**
	 * Processes on button {@click}
	 */
	private void process() {
		if (COMBINATION_COUNT.size() >= 3) {
			if ((COMBINATION_COUNT.get(0).getId() == COMBINATION_COUNT.get(1).getId())
					&& (COMBINATION_COUNT.get(0).getId() == COMBINATION_COUNT.get(2).getId())) {
				player.inventory.add(new Item(COMBINATION_COUNT.get(0).getId()));
				player.send(new SendString("Congratulation's, you have won!", 20014));
			} else {
				player.send(new SendString("Bad luck, you have lost!", 20014));
			}
			getBonus();
		}
	}

	/**
	 * Reveals the clicked card
	 * 
	 * @param button
	 */
	public void reveal(int button) {
		switch (button) {
		case 20016:
			for (int i = 0; i < COMBINATION.size(); i++) {
				if (COMBINATION_COUNT.contains(COMBINATION.get(i).getFirst()))
					continue;
				COMBINATION_COUNT.add(COMBINATION.get(i).getFirst());
				player.send(new SendString("", 20019));
				player.send(new SendItemOnInterface(20020, new Item(COMBINATION.get(i).getFirst().getId())));
			}
			break;
		case 20021:
			for (int i = 0; i < COMBINATION.size(); i++) {
				if (COMBINATION_COUNT.contains(COMBINATION.get(i).getSecond()))
					continue;
				COMBINATION_COUNT.add(COMBINATION.get(i).getSecond());
				player.send(new SendString("", 20024));
				player.send(new SendItemOnInterface(20025, new Item(COMBINATION.get(i).getSecond().getId())));
			}
			break;
		case 20026:
			for (int i = 0; i < COMBINATION.size(); i++) {
				if (COMBINATION_COUNT.contains(COMBINATION.get(i).getThird()))
					continue;
				COMBINATION_COUNT.add(COMBINATION.get(i).getThird());
				player.send(new SendString("", 20029));
				player.send(new SendItemOnInterface(20030, new Item(COMBINATION.get(i).getThird().getId())));
			}
			break;
		}
		process();
	}

	/**
	 * Fetches a random bonus [NOT FiNISHED]
	 */
//its un let me talk so all u do for now just put the prizes that u want and ill finish it up laterkk
	public void getBonus() {
		Item[] items = new Item[] { new Item(995, Utility.random(35000000, 50000000)), new Item(6199) };
		Item item = items[random.nextInt(items.length)];
		player.inventory.add(item);
		player.send(new SendItemOnInterface(20036, item));
	}

	/**
	 * Fetches a random card
	 */
	private static Random random = new Random();

	private int getRandom() {
		return ScratchCardData.values()[random.nextInt(ScratchCardData.values().length)].getDisplayId();
	}

	/**
	 * Stores the already used cards
	 */
	private static final List<ScratchCardInstanced> COMBINATION_COUNT = new ArrayList<>();

	/**
	 * Stores the randomly generated cards
	 */
	private static final List<ScratchCardCombination> COMBINATION = new ArrayList<>();
}
