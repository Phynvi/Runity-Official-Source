package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.util.Utility;

public class PetMysteryBox implements MysteryBoxListener {

	@Override
	public Item[] getCommon() {
		return new Item[] { new Item(995, Utility.random(1000000, 2500000)), new Item(12696, 10), // Super combat potion
				new Item(13322 ,1),
				new Item( 20665,1),
				new Item(20663 ,1),
				new Item(20661 ,1),
				new Item(20659 ,1),
				new Item(13323 ,1),
				new Item(13320 ,1),
				new Item(13321 ,1),
				new Item(13225 ,1),
				new Item(13181 ,1),
				new Item(12648 ,1),
				new Item(13177 ,1),
				new Item(12646 ,1),
				new Item(13178 ,1),

		};
	}

	@Override
	public Item[] getUncommon() {
		return new Item[] { new Item(995, Utility.random(2500000, 3500000)), new Item(11959, 300), // black chinchompa
				new Item(12655 ,1),
				new Item(11995 ,1),
				new Item(12643,1),
				new Item(12645 ,1),
				new Item(12644, 1),
				new Item(12651 ,1),
				new Item(12649 ,1),
				new Item(12653 ,1),

				
		};
	}

	@Override
	public Item[] getRare() {
		return new Item[] { new Item(995, Utility.random(3500000, 5000000)), new Item(12889, 1), // santa pantaloons
				new Item(21273 ,1),
				new Item( 20851 ,1),
				new Item( 13247,1),				
				new Item( 20693,1),
				new Item(  20693,1),
				new Item( 21992,1),				
				new Item( 7505,1),
				new Item( 4149,1),
				new Item( 13262,1),				
				new Item( 21509,1),
				new Item(  21511,1),
				new Item(  7420,1),
		};
	}

	@Override
	public Item[] getUltra() {
		return new Item[] { new Item(995, Utility.random(5000000, 50000000)), new Item(13173, 11), // phat set
				new Item( 9105,1),
				new Item( 8133,1),
				new Item( 8134,1),				
				new Item( 7420,1),
				new Item(21511 ,1),				
				new Item(21509 ,1),
				new Item(13262 ,1),
				new Item(4149 ,1),				
				new Item(7505 ,1),
				new Item(21992 ,1),
				new Item(20693 ,1),

		};
	}

	@Override
	public void execute(Player player) {
		Random random = new Random();
		player.inventory.remove(8038, 1);
		/**
		 * Utility.random(1, 150) <-- This generates a RANDOM number between 1 and 150.
		 * Utility.random(1, 250) <= 10 <---- This generates a RANDOM NUMBER between 1
		 * and 150 and if the RANDOM NUMBER is equal to 10 then it will execute.
		 */
		if (Utility.random(1, 200) <= 7) {
			player.inventory.add(getUncommon()[random.nextInt(getUncommon().length)]);
			player.message("You have recieved a Uncommon loot!");
		}
		if (Utility.random(1, 400) <= 5) {
			player.inventory.add(getRare()[random.nextInt(getRare().length)]);
			player.message("@gre@You have recieved a Rare loot!");
		}
		if (Utility.random(1, 500) <= 2) {
			player.inventory.add(getUltra()[random.nextInt(getUltra().length)]);
			player.message("You have recieved a ULTRA RARE LOOT!");
			World.sendMessage(player.getName() + " @red@Has received ULTRA RARE LOOT!");
		} else {
			player.inventory.add(getCommon()[random.nextInt(getCommon().length)]);
		}
		player.setBossPoints(player.getBossPoints() + 50);
        player.message("You have recieved 50 Boss points!" + " <img=14>You now have @red@ " + player.getBossPoints() + " boss points");
	}

}
