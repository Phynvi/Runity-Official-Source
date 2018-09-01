package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.util.Utility;

public class GoldMysteryBox implements MysteryBoxListener {

	@Override
	public Item[] getCommon() {
		return new Item[] { new Item(995, Utility.random(1000000, 2500000)), new Item(12696, 10), // Super combat potion
				new Item(10034, 100), // red chins
				new Item(6257, 1), // Broodoo shield
				new Item(6235, 1), // Broodoo shield
				new Item(13385, 1), // xerician hat
				new Item(13387, 1), // xerician top
				new Item(6279, 1), // brodoodon shield
				new Item(13389, 1), // xerician robe

				new Item(3095, 1), // bronze claws
				new Item(3096, 1), // iron claws
				new Item(3097, 1), // steel claws
				new Item(3098, 1), // black claws
				new Item(3099, 1), // mithril claws
				new Item(3100, 1), // adamant claws
				new Item(3101, 1), // rune claws
				new Item(6587, 1), // white claws
				new Item(7537, 1), // crab claw

				new Item(12245, 1), // beanie
				new Item(10039, 1), // kyatt hat
				new Item(10037, 1), // kyatt top
				new Item(10035, 1), // kyatt legs
				new Item(6377, 1), // villager sandals
				new Item(6349, 1), // villager sandals
				new Item(6357, 1), // villager sandals
				new Item(6367, 1), // villager sandals

				new Item(7668, 1), // Gadderhammer
				new Item(811, 300), // rune dart
				new Item(2890, 1), // elemental shield
				new Item(299, 1), // mithril seed
				new Item(6137, 1), // skeletal helm
				new Item(6139, 1), // skeletal top
				new Item(6141, 1), // skeletal bottom
				new Item(6147, 1), // skeletal boots
				new Item(10796, 1), // robin hood hat
				new Item(19707, 1), // amulet of eternal glory
				new Item(6153, 1) // skeleton gloves

		};
	}

	@Override
	public Item[] getUncommon() {
		return new Item[] { new Item(995, Utility.random(2500000, 3500000)), new Item(11959, 300), // black chinchompa
				new Item(1959, 1), // pumpkin
				new Item(1961, 1), // easter egg
				new Item(10507, 1), // reindeer hat

				new Item(9925, 1), // Skeleton mask
				new Item(9922, 1), // skeleton gloves

				new Item(9924, 1), // skeleton shirt
				new Item(9921, 1), // skeleton boots

				new Item(21021, 1), // ancestral top
				new Item(21018, 1), // ancestral hat
				new Item(12002, 1), // occult necklace
				new Item(21024, 1), // ancestral robe bottom
				new Item(20035, 1), // Samurai kasa
				new Item(20038, 1), // Samurai shirt
				new Item(20044, 1), // Samurai greaves
				new Item(20041, 1), // Samurai gloves
				new Item(20047, 1), // Samurai boots
				new Item(20086, 1), // Mummy's hand
				new Item(20092, 1), // Mummy's feet
				new Item(20080, 1), // Mummy's head
				new Item(20083, 1), // Mummy's top
				new Item(20089, 1) // Mummy's leg
		};
	}

	@Override
	public Item[] getRare() {
		return new Item[] { new Item(995, Utility.random(3500000, 5000000)), new Item(12889, 1), // santa pantaloons
				new Item(13576, 1), // Dragon warhammer
				new Item(9923, 1), // skeleton leggings
				new Item(1050, 1), // Santa hat
				new Item(12890, 1), // santa gloves
				new Item(13652, 1), // dragon claws
				new Item(12888, 1), // Santa jacket
				new Item(12891, 1), // Santa boots

				new Item(13343, 1), // black santa hat

				new Item(10556, 1), // attacker icon
				new Item(10557, 1), // collector icon
				new Item(10558, 1), // defender icon
				new Item(10559, 1), // healer icon

				new Item(11847, 1), // black h'ween mask
				new Item(4084, 1), // sled
				new Item(1048, 1), // white phat
				new Item(1040, 1), // yellow phat
				new Item(1042, 1), // blue phat
				new Item(1044, 1), // green phat
				new Item(1046, 1), // purple phat

				new Item(1038, 1), // red phat
				new Item(11862, 1), // black phat
				new Item(11863, 1), // rainbow phat
				new Item(12399, 1), // phat and specs
				new Item(1057, 1), // red h'ween
				new Item(1053, 1), // green h'ween

				new Item(21079, 1), // arcane prayer scroll
				new Item(21034, 1), // dexterous prayer scroll
				new Item(1055, 1) // blue h'ween
		};
	}

	@Override
	public Item[] getUltra() {
		return new Item[] { new Item(995, Utility.random(5000000, 50000000)), new Item(13173, 11), // phat set
				new Item(13175, 1), // h'ween set
				new Item(21000, 1), // twisted buckler
				new Item(21006, 1), // kodai wand
				new Item(21003, 1), // elder maul
				new Item(21015, 1), // Dinh bulwark
				new Item(20997, 1), // twisted bow
				new Item(12817, 1), // ely ss
				new Item(12821, 1), // spectral ss
				new Item(12825, 1), // arcane ss
				new Item(12819, 1), // ely sigil
				new Item(12823, 1), // spectral sigil
				new Item(12827, 1), // arcane sigil
				new Item(21225, 1),

		};
	}

	@Override
	public void execute(Player player) {
		Random random = new Random();
		player.inventory.remove(11739, 1);
		/**
		 * Utility.random(1, 150) <-- This generates a RANDOM number between 1 and 150.
		 * Utility.random(1, 250) <= 10 <---- This generates a RANDOM NUMBER between 1
		 * and 150 and if the RANDOM NUMBER is equal to 10 then it will execute.
		 */
		if (Utility.random(1, 125) <= 12) {
			player.inventory.add(getUncommon()[random.nextInt(getUncommon().length)]);
			player.message("You have recieved a Uncommon loot!");
		}
		if (Utility.random(1, 200) <= 10) {
			player.inventory.add(getRare()[random.nextInt(getRare().length)]);
			player.message("@gre@You have recieved a Rare loot!");
		}
		if (Utility.random(1, 300) <= 7) {
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
