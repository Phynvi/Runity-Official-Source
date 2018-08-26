package io.battlerune.content.mysterybox.impl;

import java.util.Random;

import io.battlerune.content.mysterybox.MysteryBoxListener;
import io.battlerune.game.task.Task;
import io.battlerune.game.task.TaskManager;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.util.Utility;

public class SilverMysteryBox implements MysteryBoxListener {
	int randomAmount = Utility.random(1000000, 2500000);//again this shit code?
	int randomAmount1 = Utility.random(2500000, 3500000);
	int randomAmount2 = Utility.random(3500000, 5000000);
	int randomAmount3 = Utility.random(5000000, 50000000);

	@Override
	public Item[] getCommon() {
		return new Item[] { new Item(995, randomAmount), new Item(396, 100), // raw sea turtle
				new Item(990, 50), // c keys
				new Item(454, 1), // coal
				new Item(11128, 1), // berserker neck

				new Item(20217, 1), // team cape i
				new Item(20214, 1), // team cape x
				new Item(20211, 1), // team cape zero

				new Item(4153, 1), // g maul
				new Item(20727, 1), // leaf bladed battleaxe
				new Item(12357, 1), // katana
				new Item(11037, 1) // brine sabre

		};
	}

	@Override
	public Item[] getUncommon() {
		return new Item[] { new Item(995, randomAmount1), new Item(7142, 1), // rapier
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
				new Item(20595, 1), // elder chaos hood
				new Item(20517, 1), // elder chaos top
				new Item(21298, 1), // obsidian helm
				new Item(21301, 1), // obsid body
				new Item(21304, 1), // obsid legs
				new Item(20520, 1) // elder chaos robe

		};
	}

	@Override
	public Item[] getRare() {
		return new Item[] { new Item(995, randomAmount2), new Item(7673, 1), // blue boxing gloves
				new Item(7671, 1), // red b gloves
				new Item(11705, 1), // yellow b gloves
				new Item(11706, 1), // pink b gloves

				new Item(20604, 1), // elder wand

				new Item(13379, 1), // shay helm
				new Item(13381, 1), // shay body
				new Item(13380, 1), // shay legs
				new Item(13378, 1), // shay boots
				new Item(13377, 1), // shay gloves

				new Item(12313, 1), // white boater
				new Item(7319, 1), // red boater
				new Item(7321, 1), // orange boater
				new Item(7323, 1), // green boater
				new Item(7325, 1), // blue boater
				new Item(7327, 1), // black boater
				new Item(12311, 1), // purple boater
				new Item(12309, 1), // pink boater

				new Item(10412, 1), // green elegant shirt
				new Item(10414, 1), // green elegant legs
				new Item(10416, 1), // purple elegant shirt
				new Item(10418, 1), // purple elegant legs
				new Item(12315, 1), // pink elegant shirt
				new Item(12317, 1), // pink elegant legs
				new Item(10400, 1), // black elegant shirt
				new Item(10402, 1), // black elegant legs
				new Item(10408, 1), // blue elegant shirt
				new Item(10410, 1), // blue elegant legs

				new Item(21012, 1), // Dragon hunter cbow

				new Item(10556, 1), // attacker icon
				new Item(10557, 1), // collector icon
				new Item(10558, 1), // defender icon
				new Item(10559, 1) // healer icon

		};
	}

	@Override
	public Item[] getUltra() {
		return new Item[] { new Item(995, randomAmount3), new Item(1038, 1), // red phat
				new Item(1040, 1), // yellow phat
				new Item(1042, 1), // blue phat
				new Item(1044, 1), // green phat

				new Item(1046, 1), // purple phat
				new Item(1048, 1), // white phat
				new Item(11862, 1), // black phat
				new Item(11863, 1), // rainbow phat
				new Item(12399, 1), // phat with specs
				new Item(13173, 1), // partyhat set

				new Item(1057, 1), // red halloween mask
				new Item(11847, 1), // black hween mask
				new Item(1055, 1), // blue hween mask
				new Item(1053, 1), // green hween mask
				new Item(13175, 1) // hween mask set

		};
	}

	@Override//ur slave is actually retarded, don't say that about him, he's my left hand lmaooo gay ass
	public void execute(Player player) {
		Random random = new Random();
		player.inventory.remove(12955, 1);
		/**
		 * Utility.random(1, 150) <-- This generates a RANDOM number between 1 and 150.
		 * Utility.random(1, 250) <= 10 <---- This generates a RANDOM NUMBER between 1
		 * and 150 and if the RANDOM NUMBER is equal to 10 then it will execute.
		 */
		if (Utility.random(1, 125) <= 10) {
			player.inventory.add(getUncommon()[random.nextInt(getUncommon().length)]);
			player.message("You have recieved a Uncommon loot!");
		}
		if (Utility.random(1, 225) <= 7) {
			player.inventory.add(getRare()[random.nextInt(getRare().length)]);
			player.message("@gre@You have recieved a Rare loot!");
		}
		if (Utility.random(1, 325) <= 5) {
			player.inventory.add(getUltra()[random.nextInt(getUltra().length)]);
			player.message("You have recieved a ULTRA RARE LOOT!");
			World.sendMessage(player.getName() + " @red@Has received ULTRA RARE LOOT!");
		} else {
			player.inventory.add(getCommon()[random.nextInt(getCommon().length)]);
		}
		player.setBossPoints(player.getBossPoints() + 50);
		player.message("<img=14>You have been given @red@" + player.getBossPoints() + " Boss Points!");
	}

}
