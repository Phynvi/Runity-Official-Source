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

	public static int[] ALWAYSLOOT = { 12829, 4151, 10828, 4153, 1704, 6889, 1231, 1305, 1434, 4747, 4712, 4710, 4708,
			4759, 4755 };
	public static int[] COMMONLOOT = { 6199, 989, 3140, 4087, 11732, 989, 12878, 6585, 4675, 12955 };
	public static int[] RARELOOT = { 11834, 11832, 11828, 11830, 11836, 11773, 13239, 13237, 13235, 11772, 11771, 11770,
			20143, 20002, 13689, 14589, 13208, 13701, 13702 };
	public static int[] SUPERRARELOOT = { 11862, 21225, 12817, 12825, 12821, 20997, 13652, 11802, 13576, 11785, 19481,
			11791, 12904, 10860, 3274, 13692, 13662, 11642, 13724, 11063, 11739 };

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

		int random = Utility.random(100);

		if (random <= 50) {
			for (int i = 0; i < COMMONLOOT.length; i++) {
				GroundItem.createGlobal(player, new Item(COMMONLOOT[i], 1),
						new Position(2273 + Utility.random(10), 5341 + Utility.random(10), 0));
			}
		}
		if (random <= 25) {
			for (int i = 0; i < RARELOOT.length; i++) {
				GroundItem.createGlobal(player, new Item(RARELOOT[i], 1),
						new Position(2273 + Utility.random(10), 5341 + Utility.random(10), 0));
			}
		}
		if (random <= 5) {
			for (int i = 0; i < SUPERRARELOOT.length; i++) {
				GroundItem.createGlobal(player, new Item(SUPERRARELOOT[i], 1),
						new Position(2273 + Utility.random(10), 5341 + Utility.random(10), 0));
				World.sendMessage("<img=10><col=FF0000>[ARENA EVENT] Arena has dropped Bank Loot!");
			}
		}

		for (int i = 0; i < ALWAYSLOOT.length; i++) {
			GroundItem.createGlobal(player, new Item(ALWAYSLOOT[i], 1),
					new Position(2273 + Utility.random(10), 5341 + Utility.random(10), 0));
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
