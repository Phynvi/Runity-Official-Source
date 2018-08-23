package io.battlerune.content.scratchcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendItemOnInterface;

public class ScratchCard {

	private Player player;

	public ScratchCard(Player player) {
		this.player = player;
	}

	public void display() {

		COMBINATION.clear();
		COMBINATION_COUNT.clear();

		player.interfaceManager.open(20011);

		COMBINATION.add(new ScratchCardCombination(new ScratchCardInstanced(20016, getRandom()),
				new ScratchCardInstanced(20021, getRandom()), new ScratchCardInstanced(20026, getRandom())));

	}

	private void process() {
		if (COMBINATION_COUNT.size() >= 3) {
				if ((COMBINATION_COUNT.get(0).getId() == COMBINATION_COUNT.get(1).getId())
						&& (COMBINATION_COUNT.get(0).getId() == COMBINATION_COUNT.get(2).getId())) {
					player.message("YOU WON");
				} else {
					player.message("YOU LOST");
				}
		}
	}

	public void reveal(int buttonId) {
		switch (buttonId) {
		case 20016:
			for (int i = 0; i < COMBINATION.size(); i++) {
				if (COMBINATION_COUNT.contains(COMBINATION.get(i).getFirst()))
					continue;
				COMBINATION_COUNT.add(COMBINATION.get(i).getFirst());
				player.send(new SendItemOnInterface(20020, new Item(4151)));
				player.message("[First] " + COMBINATION.get(i).getFirst().getId());
			}
			break;
		case 20021:
			for (int i = 0; i < COMBINATION.size(); i++) {
				if (COMBINATION_COUNT.contains(COMBINATION.get(i).getSecond()))
					continue;
				COMBINATION_COUNT.add(COMBINATION.get(i).getSecond());
				player.send(new SendItemOnInterface(20025, new Item(4151)));
				player.message("[Second] " + COMBINATION.get(i).getSecond().getId());
			}
			break;
		case 20026:
			for (int i = 0; i < COMBINATION.size(); i++) {
				if (COMBINATION_COUNT.contains(COMBINATION.get(i).getThird()))
					continue;
				COMBINATION_COUNT.add(COMBINATION.get(i).getThird());
				player.send(new SendItemOnInterface(20030, new Item(4151)));
				player.message("[Third] " + COMBINATION.get(i).getThird().getId());
			}
			break;
		}
		process();
	}

	private int getRandom() {
		return ScratchCardData.values()[random.nextInt(ScratchCardData.values().length)].getDisplayId();
	}

	private static Random random = new Random();
	private static final List<ScratchCardInstanced> COMBINATION_COUNT = new ArrayList<>();
	private static final List<ScratchCardCombination> COMBINATION = new ArrayList<>();
}
