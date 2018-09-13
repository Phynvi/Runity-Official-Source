package io.battlerune.game.world.entity.combat.strategy.npc.boss.porazdir;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.ground.GroundItem;
import io.battlerune.game.world.position.Position;
import io.battlerune.util.Utility;

/**
 * Created by Adam_#6723
 */
public class PorazdirUtility {



	public static int[] ALWAYSLOOT = {6889, 4675, 11836, 12877, 989,  4151,3140, 4087, 11732, 989, 4675, 6585,  };
	public static int[] COMMONLOOT = { 989,  4151,3140, 4087, 11732, 989, 4675, 11770, 11771, 11772, 6585, };
	public static int[] RARELOOT = { 4153, 7158, 1305, 4587, 11840,  6585, 12875, 12873, 11840, 12877};
	public static int[] SUPERRARELOOT = { 13729, 6199, 11802, 11283, 13652, 12904, 11791, 12691, 12692, 12877, 13749, 13729, 17165, 17164, 17163, 13662, 13207, 13190};
	public static int[] ULTRA = {6199, 6889, 4675, 11836, 12877, 13718,21777, 13208, 22123, 21954, 15300 };

	public static void defeated(Npc Porazdir, Player player) {

		int random = Utility.random(1000);

		if (random <= 50) {
				GroundItem.createGlobal(player, new Item(COMMONLOOT[Utility.random(COMMONLOOT.length)], 1),
						new Position(3243 + Utility.random(7), 10200 + Utility.random(1), 0));
		}
		if (random <= 10) {
				GroundItem.createGlobal(player, new Item(RARELOOT[Utility.random(RARELOOT.length)], 1),
						new Position(3243 + Utility.random(5), 10200 + Utility.random(7), 0));
			
		}
		if (random <= 2) {
			GroundItem.createGlobal(player, new Item(SUPERRARELOOT[Utility.random(SUPERRARELOOT.length)], 1),
						new Position(3243 + Utility.random(12), 10201 + Utility.random(5), 0));
				World.sendMessage("<img=10><col=FF0000>[Porazdir] has dropped Rare Loot");
			
		}
		
		if (random <= 11 && Utility.random(1, 10) <= 2) {
			GroundItem.createGlobal(player, new Item(ULTRA[Utility.random(ULTRA.length)], 1),
						new Position(3242 + Utility.random(7), 10200 + Utility.random(8), 0));
				World.sendMessage("<img=10><col=FF0000>[Porazdir] has dropped Ultra Rare Loot!");
			
		}
		for (int i = 0; i < ALWAYSLOOT.length; i++) {
			GroundItem.createGlobal(player, new Item(ALWAYSLOOT[i], 1),
					new Position(3240 + Utility.random(1, 7), 10202 + Utility.random(4), 0));
		}
	}
}
