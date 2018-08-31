package io.battlerune.game.world.entity.combat.strategy.npc.boss.arena;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.Direction;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.ground.GroundItem;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.MessageColor;
import io.battlerune.util.Utility;

/**
 * Created by Daniel on 2017-12-20.
 */
public class ArenaUtility {

	public static SpawnData spawn;

	public static boolean activated = false;

	public static Npc generateSpawn() {
		activated = true;
		SpawnData spawn = SpawnData.generate();
		Npc arena = new Npc(5129, spawn.position, 10, Direction.NORTH);
		World.sendMessage("<col=8714E6>[ARENA EVENT] arena has just spawned! He is located at " + spawn.location + "!",
				"<col=8714E6> First clan to kill him will be rewarded handsomely!");
		World.sendMessage("to enter the arena do ::arena and rid this beast from the world of NR!");
		World.sendBroadcast(1, "The Arena boss has spawned enter by doing ::arena", true);
		World.sendArenaInformation();
		arena.register();
		arena.definition.setRespawnTime(-1);
		arena.definition.setAggressive(true);
		arena.speak("Darkness is here to penetrate your souls!");
		return arena;
	}

	/** Identification of all loot, it selects the loot */

	public static int[] ALWAYSLOOT = {6889, 4675, 11836, 12877 };
	public static int[] COMMONLOOT = { 989,  4151,3140, 4087, 11732, 989, 4675, 11770, 11771, 11772, 6585, };
	public static int[] RARELOOT = { 4153, 7158, 1305, 4587, 11840,  6585, 12875, 12873, 11840, 12877};
	public static int[] SUPERRARELOOT = { 13729, 6199, 11802, 11283, 13652, 12904, 11791, 12691, 12692, 12877, 13749, 13729, 17165, 17164, 17163, 13662, 13207, 13190};
	public static int[] ULTRA = {6889, 4675, 11836, 12877, 13718,21777, 13208, 22123, 21954, 15300 };

	public static void defeated(Npc Arena, Player player) {

		boolean hasClan = player.clanChannel != null;

		if (hasClan) {
			player.clanChannel.getDetails().points += 5;
			player.clanChannel.addExperience(10000);
			World.sendMessage("<col=8714E6>[ARENA EVENT] Arena Boss has been defeated by " + player.getName() + "!");
			player.clanChannel
					.message("[ARENA EVENT] Hell yeah boys! We just killed Galvek!! We earned 10,000 EXP & 5 CP.");
		}
		World.sendMessage("<col=8714E6>[ARENA EVENT] Arena has been defeated by " + player.getName() + ", the legend.");

		/**
		 * Constructs a new object for the ground item method, uses utility random, to
		 * randomise a number between the upper bound and lower bound of a number.
		 * 
		 * 
		 **/

		int random = Utility.random(1000);

		if (random <= 50) {
				GroundItem.createGlobal(player, new Item(COMMONLOOT[Utility.random(COMMONLOOT.length)], 1),
						new Position(2273 + Utility.random(11), 5341 + Utility.random(13), 0));
		}
		if (random <= 10) {
				GroundItem.createGlobal(player, new Item(RARELOOT[Utility.random(RARELOOT.length)], 1),
						new Position(2273 + Utility.random(12), 5341 + Utility.random(14), 0));
			
		}
		if (random <= 2) {
			GroundItem.createGlobal(player, new Item(SUPERRARELOOT[Utility.random(SUPERRARELOOT.length)], 1),
						new Position(2273 + Utility.random(14), 5341 + Utility.random(15), 0));
				World.sendMessage("<img=10><col=FF0000>[GALVEK EVENT] Arena has dropped Bank Loot!");
			
		}
		
		if (random <= 11 && Utility.random(1, 10) <= 2) {
			GroundItem.createGlobal(player, new Item(ULTRA[Utility.random(ULTRA.length)], 1),
						new Position(2273 + Utility.random(14), 5341 + Utility.random(15), 0));
				World.sendMessage("<img=10><col=FF0000>[GALVEK EVENT] Arena has dropped Ultra Rare Loot!");
			
		}
		for (int i = 0; i < ALWAYSLOOT.length; i++) {
			GroundItem.createGlobal(player, new Item(ALWAYSLOOT[i], 1),
					new Position(2273 + Utility.random(1, 15), 5341 + Utility.random(12), 0));
		}
		for (Player players : World.getPlayers()) {
			if (Area.inGlodArena(players)) {
				int randomAmount = Utility.random(1000000, 2000000);
				players.inventory.add(995, randomAmount);
				players.message("<col=8714E6>[ARENA EVENT] You have recieved " + randomAmount
						+ " coins for completing the arena event.");
			}
		}

		player.send(new SendMessage("[ARENA EVENT] Arena drop's lootation all over the map.", MessageColor.RED));
		Arena.unregister();
		activated = false;
	}

	public enum SpawnData {
		LEVEL_18("do ::arena To Enter his evil lair!", new Position(2273, 5341, 0));
		public final String location;
		public final Position position;

		SpawnData(String location, Position position) {
			this.location = location;
			this.position = position;
		}

		public static SpawnData generate() {
			return Utility.randomElement(values());
		}

		public String getLocation() {
			return location;
		}

		public Position getPosition() {
			return position;
		}
	}
}
