package io.battlerune.util.tools;

import io.battlerune.game.world.items.ItemDefinition;

public class ItemStatsDumper {
	public static void main(String[] args) {
		printStats();
	}

	public static void printStats() {
		for (int i = 0; i < 22518; ++i) {
			ItemDefinition item = ItemDefinition.get(i);
			if (item != null && item.getBonuses() != null) {
				String s = "" + item.getId() + "";
				for (int j = 0; j < item.getBonuses().length; ++j) {
					if (j != 11 && j != 12)
						s += " " + ((int) item.getBonuses()[j]);
				}
				System.out.println(s);
			}
		}
	}
}
