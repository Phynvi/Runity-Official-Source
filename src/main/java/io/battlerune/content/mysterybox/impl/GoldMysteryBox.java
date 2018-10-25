package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;
import io.battlerune.util.Utility;

public class GoldMysteryBox implements MysteryBoxListener {

	@Override
	public Item[] getCommon() {
		return new Item[] { new Item(995, Utility.random(2500000, 3500000)), new Item(11959, 300), // black chinchompa		new Item(10034, 100), // Red Chins
		        new Item(2581, 1), // Robin hood hat
		        new Item(19707, 1), // Amulet of eternal glory
		        new Item(299, 50), // 50x Flower Poker Seeds
				new Item(12926, 1), // Toxic blowpipe
				new Item(11283, 1), // DFS
		        new Item(811, 500), // 500x Rune Dart
		        new Item(11230, 200), // 200x Dragon Dart
		        new Item(7668, 1), // Gadderhammer
		        new Item(6818, 1), // Bow-Sword (Cool skiller weapon)
		        new Item(6199, 1), // Mummy's leg
				new Item(12357, 1), // katana
				new Item(21021, 1), // ancestral top
				new Item(21018, 1), // ancestral hat
				new Item(12002, 1), // occult necklace
				new Item(6739, 1), // Dragon Axe
				new Item(12797, 1), // Dragon Pickaxe
				new Item(21028, 1), // Dragon Harpoon
				new Item(11771, 1), // Archers ring (i)
				new Item(11773, 1), // Berserker ring (i)
				new Item(11772, 1), // warrior ring (i)

				new Item(4151, 1), // Abyssal Whip
				new Item(6585, 1), // Fury
				new Item(11840, 1), // Dragon boots
				new Item(12881, 1), // Ahrim set
				new Item(12883, 1), // Kail's set
				new Item(12873, 1), // Guthen set
				new Item(12879, 1), // Torag set
				new Item(19484, 500), // 500 Dragon Jav
				new Item(11212, 500), // 500 Dragon Arrows
				new Item(12875, 1) // Verac set

			};
		}


	@Override
	public Item[] getUncommon() {
		return new Item[] { new Item(995, Utility.random(2500000, 3500000)), new Item(11959, 300), // black chinchompa
				new Item(1959, 1), // pumpkin
				new Item(1961, 1), // easter egg
				new Item(10507, 1), // reindeer hat
				new Item(21012, 1), // Dragon hunter cbow
				new Item(19553, 1), // Amulet of torture
				new Item(11283, 1), // DFS
				new Item(21021, 1), // ancestral top
				new Item(21018, 1), // ancestral hat
				new Item(12002, 1), // occult necklace
				new Item(21024, 1), // ancestral robe bottom
				new Item(20086, 1), // Mummy's hand
				new Item(20092, 1), // Mummy's feet
				new Item(20080, 1), // Mummy's head
				new Item(20083, 1), // Mummy's top
				new Item(20089, 1), // Mummy's leg
				new Item(11785, 1), // Arma crossbow
				new Item(11926, 1), // odium ward
				new Item(12691, 1), // tyrannical ring (i)
				new Item(12692, 1), // treasonousnring (i)
				new Item(13202, 1), // ring of gods (i)
				new Item(12397, 1), // crown
				new Item(19707, 1), // eternal glory
				new Item(11889, 1), // zam hasta
				new Item(11791, 1), // SOTD
				new Item(19710, 1), // ring of suffering (i)
				new Item(12831, 1), // blessed ss
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
				new Item(12821, 1), // spectral ss
				new Item(12825, 1), // arcane ss
				new Item(13343, 1), // black santa hat

				new Item(10556, 1), // attacker icon
				new Item(10557, 1), // collector icon
				new Item(10558, 1), // defender icon
				new Item(10559, 1), // healer icon

				new Item(11847, 1), // black h'ween mask
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
				new Item(11810, 1), // Arma hilt
				new Item(11812, 1), // Bandos hilt
				new Item(11814, 1), // Sara hilt
				new Item(11816, 1), // Zam hilt
				new Item(13235, 1), // eternal boots
				new Item(13237, 1), // peg boots
				new Item(13239, 1), // prim boots
				new Item(13652, 1), // Dragon Claws
				new Item(11785, 1), // Arma crossbow
				new Item(12926, 1), // Toxic blowpipe
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
				new Item(13703, 1), 
				new Item(13704, 1), 
				new Item(13705, 1), 
				new Item(13687, 1),
				new Item(13686, 1),
				new Item(20035, 1), // Samurai kasa
				new Item(20038, 1), // Samurai shirt
				new Item(20044, 1), // Samurai greaves
				new Item(20041, 1), // Samurai gloves
				new Item(20047, 1), // Samurai boots

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
		if (Utility.random(1, 50) <= 12) {
			player.inventory.add(getUncommon()[random.nextInt(getUncommon().length)]);
			player.message("You have recieved a Uncommon loot!");
		}
		if (Utility.random(1, 350) <= 2) {
			player.inventory.add(getRare()[random.nextInt(getRare().length)]);
			player.message("@gre@You have recieved a Rare loot!");
			World.sendMessage(player.getName() + " @red@Has received RARE LOOT!");
		}
		//TODO Make Supreme rank have beenfits
		if (Utility.random(1, 500) <= 2) {
			player.inventory.add(getUltra()[random.nextInt(getUltra().length)]);
			player.message("You have recieved a ULTRA RARE LOOT!");
			World.sendMessage(player.getName() + " @red@Has received ULTRA RARE LOOT!");
		} else {
			player.inventory.add(getCommon()[random.nextInt(getCommon().length)]);
		}
		player.inventory.add(2528, 3);
		player.setBossPoints(player.getBossPoints() + 50);
        player.message("You have recieved 50 Boss points!" + " <img=2>You now have @red@ " + player.getBossPoints() + " boss points");
	}

}
