package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.util.Utility;

public class MegaMysteryBox implements MysteryBoxListener {

	
	@Override
		public Item[] getCommon() {
			return new Item[] {
					new Item(975, 20000000), // 20m cash
	new Item(12646, 1), // pet mole
	new Item(23940, 1), // pet snakeling blue
	new Item(12939, 1), // pet snakeling red

	new Item(12921, 1), // pet snakeling yellow
	new Item(12816, 1), // pet dark core

	new Item(12655, 1), // pet kraken
	new Item(12652, 1), // pet k’rill

	new Item(12651, 1), // 10m cash // pet zilyana
	new Item(12650, 1), // 10m cash // pet general graardor
	new Item(12649, 1), // 10m cash // pet kree’arra
	new Item(12648, 1), // 10m cash // pet smoke devil
	new Item(12645, 1), // 10m cash // pet rex
	new Item(12644, 1), // 10m cash // pet prime
	new Item(12643, 1), // 10m cash // pet supreme
	new Item(11995, 1), // 10m cash // pet chaos elemental

	new Item(7505, 1), // 10m cash // pirate pete
	new Item(21633, 1), // 10m cash // ancient wyvern shield
	new Item(20665, 1), // 10m cash // rift guardian
	new Item(13225, 1), // 10m cash // tzrek-jad
	new Item(13247, 1), // 10m cash // hellpuppy
	new Item(13181, 1), // 10m cash // scorpia’s offspring
	new Item(13178, 1), // 10m cash // callisto cub
	new Item(13178, 1), // 10m cash // rock golem
	new Item(21187, 1), // 10m cash // 

	new Item(20663, 1), // rocky
	new Item(12939, 1), // pet general graador
	new Item(12939, 1), // pet k’rill tsutsaroth

	new Item(126006, 1), // abyssal whip (p+)
	new Item(2577, 1), // ranger boots
	new Item(6920, 1), //  infinity boots
	new Item(11840, 1), // dragon boots
	new Item(19553, 1), // amulet of torture
	new Item(19547, 1), // necklace of anguish
	new Item(13263, 1), // abyssal bludgeon
	new Item(13265, 1), // abyssal dagger
	new Item(11235, 1), // dark bow
	new Item(12926, 1), // blowpipe
	new Item(4151, 1), // abyssal whip

	new Item(21892, 1), // 
	new Item(21895, 1), // abyssal whip
	new Item(12414, 1), //
	new Item(12415, 1), //
	new Item(20000, 1), // 
	new Item(19722, 1), //
	new Item(21902, 1), // 
	new Item(11283, 1), //
	new Item(11335, 1), //
	new Item(12418, 1) //
					};
		}


		@Override
		public Item[] getUncommon() {
			return new Item[] { 
	new Item(13576, 1), // 
	new Item(13652, 1), // 
	new Item(11824, 1), // 
	new Item(11832, 1), // 
	new Item(11834, 1), //
	new Item(13237, 1), // 
	new Item(13235, 1), // 
	new Item(7142, 1), // 
	new Item(13239, 1), // 

	new Item(12904, 1), // 
	new Item(11791, 1), // 

	new Item(21018, 1), // 
	new Item(21021, 1), // 
	new Item(21024, 1), // 
	new Item(19481, 1), // 
	new Item(11802, 1), // 
	new Item(11806, 1), // 
	new Item(19553, 1), // 
	new Item(19547, 1), // 

	new Item(11826, 1), // 
	new Item(11828, 1), // 
	new Item(11830, 1), // 
	new Item(12002, 1), // 
	new Item(11832, 1), // 
	new Item(11834, 1) // 
	};
		}
		@Override
		public Item[] getRare() {
			return new Item[] { 
	new Item(11063, 1), // master wand
	new Item(20838, 1), // 
	new Item(20840, 1), // 
	new Item(20842, 1), // 
	new Item(20846, 1), // 
	new Item(13749, 1), // 
	new Item(13739, 1), // 
	new Item(13739, 1), // 
	new Item(16650, 1), // 

	new Item(16651, 1), // 
	new Item(16653, 1), // 
	new Item(16654, 1), // 
	new Item(16655, 1), // 
	new Item(16656, 1), // 
	new Item(16648, 1), // 
	new Item(16647, 1), // 
	new Item(16649, 1), // 

	new Item(6199, 1), // 
	new Item(12955, 1), // 
	new Item(11739, 1), // 
	new Item(455, 1) // 


	 };
		}
		@Override
		public Item[] getUltra() {
			return new Item[] {
					new Item(13175, 1), // 
	new Item(13173, 1), // 
	new Item(20997, 1), // 
	new Item(21003, 1), // 
	new Item(21006, 1), // 
	new Item(21015, 1), // 
	new Item(21000, 1), // 
	new Item(13723, 1), // 

	new Item(17163, 1), // 
	new Item(17164, 1), // 
	new Item(17165, 1), // 
	new Item(17166, 1), // 
	new Item(17167, 1), // 
	new Item(17168, 1), // 
	new Item(20035, 1), // 
	new Item(20038, 1), // 
	new Item(13726, 1), // 

	new Item(20041, 1), // 
	new Item(20044, 1), // 
	new Item(20047, 1), // 
	new Item(13693, 1), // 
	new Item(13695, 1), // 
	new Item(13696, 1), // 
	new Item(13692, 1), // 
	new Item(17160, 1), // 

	new Item(19687, 1), // 
	new Item(8798, 1), // 
	new Item(8798, 1), // 
	new Item(8799, 1), // 
	new Item(8802, 1), // 
	new Item(8803, 1), // 
	new Item(8804, 1), // 
	new Item(8805, 1), // 
	new Item(8806, 1), // 
	new Item(8807, 1), // 
	new Item(8808, 1), // 
	new Item(8809, 1), // 
	new Item(8810, 1), // 
	new Item(8811, 1), // 

	new Item(3273, 1), // 
	new Item(11642, 1), // 
	new Item(13687, 1), // 
	new Item(13686, 1), // 
	new Item(13738, 1), // 
	new Item(13738, 1), // 
	new Item(13747, 1), // 
	new Item(13748, 1), // 
	new Item(17154, 1), // 

	new Item(17153, 1), // 
	new Item(17155, 1), // 
	new Item(22325, 1) 
		};
	}

	@Override
	public void execute(Player player) {
		Random random = new Random();
		player.inventory.remove(6508, 1);
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
