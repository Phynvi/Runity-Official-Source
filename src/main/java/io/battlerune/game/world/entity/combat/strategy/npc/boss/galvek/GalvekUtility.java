package io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.Direction;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.ground.GroundItem;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.MessageColor;
import io.battlerune.util.Utility;

/**
 * Created by Adam_#6723
 * Galvek Utility Class, handles the spawning & generates the location of the spawning
 */
public class GalvekUtility {

    public static Npc generateSpawn() {
    	
    	SpawnData1 spawn = SpawnData1.generate();
        Npc Galvek = new Npc(8095, spawn.position, 10, Direction.NORTH);
        World.sendMessage("<col=8714E6> Galvek has just spawned! He is located at " + spawn.location + "!", "<col=8714E6> First clan to kill him will be rewarded handsomely!");
        World.sendMessage("to enter the Galvek do ::Galvek and rid this beast from the world of Runity!");
        World.sendBroadcast(1, "The Galvek boss has spawned enter by doing ::Galvek", true);
        for(int x = 1; x < 5; x++) {
        	System.out.println("Galvek Spawned!!!");
        }
        Galvek.register();
        Galvek.definition.setRespawnTime(-1);
        Galvek.definition.setAggressive(true);
        Galvek.speak("Darkness is here to penetrate your souls!");
        return Galvek;
    }
    

    /** Identification of all loot, it selects the loot  */
    
    
    public static int[] COMMONLOOT = { 6199, 15501, 989, 3140, 4087, 11732, 989 , 12878, 6585, 4675};
	public static int[] RARELOOT = { 11834, 11832, 11828, 11830, 11836, 11773, 13239, 13237, 13235, 11772, 11771, 11770
			, 20143, 20002};
	public static int[] SUPERRARELOOT = {11862, 21225, 12817, 12825, 12821, 20997
			, 13652, 11802, 13576, 11785, 19481, 11791, 12904, };

  
    public static void defeated(Npc Galvek, Player player) {
    	
	/*	int superrare = SUPERRARELOOT[Utility.random(SUPERRARELOOT.length - 1)];
		int rare = RARELOOT[Utility.random(SUPERRARELOOT.length - 1)];
		int common = COMMONLOOT[Utility.random(SUPERRARELOOT.length - 1)];*/

    	
    	
        boolean hasClan = player.clanChannel != null;

        if (hasClan) {
            player.clanChannel.getDetails().points += 5;
            player.clanChannel.addExperience(10000);
            World.sendMessage("<col=8714E6> Galvek has been defeated by " + player.getName() + ", a clan member of " + player.clanChannel.getName() + "!");
            player.clanChannel.message("Hell yeah boys! We just killed Galvek!! We earned 10,000 EXP & 5 CP.");
        }
            World.sendMessage("<col=8714E6> Galvek has been defeated by " + player.getName() + ", a solo individual with balls of steel!");
            
            //TODO Iterate it over the spawnData, and if the spawndata is equal to the correct value from that enum, than edit the Positions.
			
            /** Generates a random item from the int array list. **/
            
            
            /** Generates a random item from the integer array list. **/
                      
                      Item item = new Item(Utility.randomElement(COMMONLOOT));
                      
                      Item item1 = new Item(Utility.randomElement(RARELOOT));
                      
                      Item item2 = new Item(Utility.randomElement(SUPERRARELOOT));
                      
                      /** Constructs a new object for the ground item method, uses utility random, to randomise a number
                       * between the upper bound and lower bound of a number.**/
                    
          		    Position position = new Position(2269 + Utility.random(1, 2), 5342 + Utility.random(2, 3), 0);
          		    Position position1 = new Position(2264 + Utility.random(1, 4), 5336 + Utility.random(2, 5), 0);
          		    Position position2 = new Position(2271 + Utility.random(2, 3), 5345 + Utility.random(3, 4), 0);
          		    
          		    Position position3 = new Position(2281 + Utility.random(1, 6), 5354 + Utility.random(2, 7), 0);
          		    Position position4 = new Position(2278 + Utility.random(2, 7), 5335 + Utility.random(3, 8), 0);
          		    Position position5 = new Position(2258 + Utility.random(3, 8), 5341 + Utility.random(4, 9), 0);

          		    Position position6 = new Position(2270 + Utility.random(1, 5), 5342 + Utility.random(2, 10), 0);
          		    Position position7 = new Position(2256 + Utility.random(2, 8), 5345 + Utility.random(3, 5), 0);
          		    Position position8 = new Position(2265 + Utility.random(2, 3), 5339 + Utility.random(4, 5), 0);
          		
          			if(Utility.random(1, 200) == 200) {
              		    GroundItem.createGlobal(player, item2, position);  
              			GroundItem.createGlobal(player, item2, position4);
              			World.sendMessage("<img=10><col=FF0000>Galvek has dropped Very Rare Loot!");
          			}
          			if(Utility.random(1, 100) == 100) {
              		    GroundItem.createGlobal(player, item1, position3);  
              			GroundItem.createGlobal(player, item1, position2);
              			World.sendMessage("<img=10><col=FF0000>Galvek has dropped Rare Loot!");
          			} 
          		    
          		    GroundItem.createGlobal(player, item, position);  
          			GroundItem.createGlobal(player, item, position1);
          			GroundItem.createGlobal(player, item, position2);
          			GroundItem.createGlobal(player, item, position3);  
          			GroundItem.createGlobal(player, item, position4);
          			GroundItem.createGlobal(player, item, position5);
          			GroundItem.createGlobal(player, item, position6);
          			GroundItem.createGlobal(player, item, position7);
          			GroundItem.createGlobal(player, item2, position8);
          			World.sendMessage("<img=10><col=FF0000>Galvek has dropped Bank Loot!");
          			

                    player.send(new SendMessage("Galvek drop's lootation all over the map.", MessageColor.RED));
                      
               
            
            

        Galvek.unregister();
    }

    public enum SpawnData1 {
        LEVEL_46("lvl 46 wild near Spider Hill", new Position(3135, 3888, 0)),
        LEVEL_16("lvl 16 wild near Bone Yard", new Position(3273, 3648, 0)),
        LEVEL_51("lvl 51 wild near Rogues Castle", new Position(3266, 3924, 0)),
        LEVEL_41("lvl 41 wild near 19 Portal", new Position(3197, 3670, 0)),
        LEVEL_47("lvl 47 wild near obelisk", new Position(3308, 3892, 0)),
        LEVEL_53("lvl 53 wild near scorpia's cave entrance", new Position(3211, 3944, 0));

        public final String location;
        public final Position position;

        SpawnData1(String location, Position position) {
            this.location = location;
            this.position = position;
        }

        public static SpawnData1 generate() {
            return Utility.randomElement(values());
        }
    }
}