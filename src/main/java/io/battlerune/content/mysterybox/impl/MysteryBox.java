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
	@Override
	public Item[] getCommon() {
		return new Item[] {
				new Item(995, Utility.random(1000000, 2500000)), 
				new Item(2657, 1), //Zam helm
				new Item(2653, 1), //Zam body
				new Item(2655, 1), //Zan legs
				new Item(3478, 1), //Zam skirt
				new Item(2659, 1), //Zam kite
				
				new Item(2673, 1), //Guth Hel.
				new Item(2669, 1), //Guth Body
				new Item(2671, 1), //Guth legs
				new Item(3480, 1), //Guth skirt
				new Item(2675, 1), //Guth kite
				
				new Item(2665, 1), //Sam helm
				new Item(2661, 1), //Sam body
				new Item(2663, 1), //Sam legs
				new Item(3479, 1), //Sam skirt
				new Item(2667, 1), //Sam kite
				
				new Item(12363, 1), // Bronze d mask
				new Item(12365, 1), //Iron d mask
				new Item(12367, 1), //Steel d mask
				new Item(12369, 1), //Mith d mask
				
				new Item(12518, 1), //Green d mask
				new Item(12522, 1), // Red d mask
				new Item(12520, 1), // Blue d mask
				
				new Item(452, 100), //100 Rune ore
				
				new Item(6739, 1), //Dragon Axe
				new Item(12797, 1), //Dragon Pickaxe
				new Item(21028, 1), //Dragon Harpoon
				
				new Item(11771, 1), //Archers ring (i)
				new Item(11773, 1), // Berserker ring (i)
				new Item(11772, 1), //warrior ring (i)
				
				new Item(4151, 1), //Abyssal Whip
				new Item(6585, 1), //Fury
				new Item(11840, 1) //Dragon boots
				};
	}

	@Override //suck a cock, go do the 
	public Item[] getUncommon() {
		return new Item[] { new Item(995, Utility.random(1000000, 2500000 )), new Item(12877, 1), // Dh set
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
	public Item[] getRare() {
		return new Item[] { new Item(995, Utility.random(2500000, 3500000)), new Item(19547, 1), // Neck of anguish
				new Item(19553, 1), // Amulet of torture

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
				new Item(11283, 1) // DFS

		};
	}

	@Override
	public Item[] getUltra() {
		return new Item[] { new Item(995, Utility.random(5000000, 50000000)), new Item(10350, 1), // 3rd helm
				new Item(10348, 1), // 3rd body
				new Item(10346, 1), // 3rd legs

				new Item(10352, 1), // 3rd shield
				new Item(12437, 1), // 3rd cloak
				new Item(12422, 1), // 3rd wand
				new Item(12424, 1), // 3rd bow
				new Item(12426, 1), // 3rd longsword

				new Item(20576, 1), // 3rd robe top
				new Item(20577, 1), // 3rd robe bottom

				new Item(10334, 1), // 3rd range coif
				new Item(10330, 1), // 3rd range top
				new Item(10336, 1), // 3rd age vamb
				new Item(10332, 1), // 3rd age range legs

				new Item(10342, 1), // 3rd mage hat
				new Item(20014, 1), // 3rd pickaxe
				new Item(20011, 1), // 3rd axe
				new Item(10344, 1), // 3rd amulet

				new Item(13263, 1), // Abyssal bludgeon
				new Item(13265, 1), // abyssal dagger
				new Item(13576, 1), // Dragon Warhammer
				new Item(19481, 1), // heavy balista

				new Item(21018, 1), // Ancestral hat
				new Item(21021, 1), // ancest robe top
				new Item(21024, 1), // ancest robe bottom

				new Item(11832, 1), // bandos chestplate
				new Item(11834, 1), // bandos tassests

				new Item(11826, 1), // arma helm
				new Item(11828, 1), // arma chestplate
				new Item(11830, 1) // arma legs

		};
	}

	@Override
	public void execute(Player player) {
		Random random = new Random();
		player.inventory.remove(6199, 1);
		if (Utility.random(1, 100) <= 10) {
			player.inventory.add(getUncommon()[random.nextInt(getUncommon().length)]);
			player.message("You have recieved a Uncommon loot!");
		}
		if (Utility.random(1, 200) <= 7) {
			player.inventory.add(getRare()[random.nextInt(getRare().length)]);
			player.message("@gre@You have recieved a Rare loot!");
		}
		if (Utility.random(1, 300) <= 5) {
			player.inventory.add(getUltra()[random.nextInt(getUltra().length)]);
			player.message("You have recieved a ULTRA RARE LOOT!");
			World.sendMessage(player.getName() + " @red@Has received ULTRA RARE LOOT!");
		} else {
			player.inventory.add(getCommon()[random.nextInt(getCommon().length)]);

		}

	}

}
