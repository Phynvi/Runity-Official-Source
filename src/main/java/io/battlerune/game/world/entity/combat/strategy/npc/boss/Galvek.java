package io.battlerune.game.world.entity.combat.strategy.npc.boss;

import io.battlerune.game.Animation;
import io.battlerune.game.Graphic;
import io.battlerune.game.Projectile;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.combat.attack.FightType;
import io.battlerune.game.world.entity.combat.hit.CombatHit;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.combat.projectile.CombatProjectile;
import io.battlerune.game.world.entity.combat.strategy.CombatStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.MultiStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.NpcMagicStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.NpcMeleeStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.NpcRangedStrategy;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.prayer.Prayer;
import io.battlerune.game.world.position.Position;
import io.battlerune.game.world.region.RegionManager;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

import static io.battlerune.game.world.entity.combat.CombatUtil.createStrategyArray;
import static io.battlerune.game.world.entity.combat.CombatUtil.randomStrategy;

/**
 * Handles Galvek strategy
 *
 * @author Adam
 */
public class Galvek extends MultiStrategy {
    private static Magic MAGIC = new Magic();
    private static Range RANGE = new Range();
    private static LightingRain LIGHTNING_RAIN = new LightingRain();
    private static TeleGrab TELE_GRAB = new TeleGrab();

    private static final CombatStrategy<Npc>[] FULL_STRATEGIES = createStrategyArray(NpcMeleeStrategy.get(), MAGIC, TELE_GRAB, LIGHTNING_RAIN);
    private static final CombatStrategy<Npc>[] MAGIC_STRATEGIES = createStrategyArray(MAGIC, MAGIC, MAGIC,TELE_GRAB, LIGHTNING_RAIN);
    private static final CombatStrategy<Npc>[] NON_MELEE = createStrategyArray(MAGIC, RANGE, MAGIC, MAGIC, MAGIC,TELE_GRAB, LIGHTNING_RAIN);


    private static final String[] SHOUTS = {
        "I am death...",
        "I am destruction..."
        
    };

    /** Constructs a new <code>Galvek</code>. */
    public Galvek() {
        currentStrategy = MAGIC;
        currentStrategy = RANGE;
    }

    @Override
    public boolean canAttack(Npc attacker, Mob defender) {
        if (!currentStrategy.withinDistance(attacker, defender)) {
            currentStrategy = randomStrategy(MAGIC_STRATEGIES);
            currentStrategy = randomStrategy(NON_MELEE);
        }
        return currentStrategy.canAttack(attacker, defender);
    }



    @Override
    public void finishOutgoing(Npc attacker, Mob defender) {
        currentStrategy.finishOutgoing(attacker, defender);
        if (NpcMeleeStrategy.get().withinDistance(attacker, defender)) {
            currentStrategy = randomStrategy(FULL_STRATEGIES);
        } else {
            currentStrategy = randomStrategy(MAGIC_STRATEGIES);
        }  
    }

    @Override
    public int getAttackDelay(Npc attacker, Mob defender, FightType fightType) {
        return attacker.definition.getAttackDelay();
    }
    
    public void block(Npc attacker, Mob defender, Hit[] hits) {
    	if(Utility.random(10, 25) == 15) {
    		
    	
        attacker.animate(new Animation(7914, UpdatePriority.VERY_HIGH));
        attacker.speak("Hells Rage Is built inside of me!");
        

        RegionManager.forNearbyPlayer(attacker, 16, other -> {
            Position position = other.getPosition();

            World.schedule(2, () -> {
                World.sendGraphic(new Graphic(83), position);
                if (other.getPosition().equals(position)) {
                    other.damage(new Hit(Utility.random(20, 50)));
                    other.speak("That hurt...");
                }
            });
        });
    }
    }
    
    private static class Range extends NpcRangedStrategy {
    	
    	
    	
    	public Range() {
             super(CombatProjectile.getDefinition("EMPTY"));
         }

         
         @Override
         public void hit(Npc attacker, Mob defender, Hit hit) {
         }

         @Override
         public void attack(Npc attacker, Mob defender, Hit hit) {
         }

         @Override
         public void start(Npc attacker, Mob defender, Hit[] hits) {
             attacker.animate(new Animation(7910, UpdatePriority.VERY_HIGH));
             Projectile projectile = new Projectile(157, 50, 80, 85, 25);
             defender.damage(new Hit(Utility.random(20, 75)));
             CombatHit hit = nextRangedHit(attacker, defender, 21);
             RegionManager.forNearbyPlayer(attacker, 16, other -> {
                 projectile.send(attacker, other);
                 World.schedule(2, () -> other.damage(nextMagicHit(attacker, other, 38)));
             });

             if (Utility.random(0, 3) == 2)
                 attacker.speak(Utility.randomElement(SHOUTS));
         }

         @Override
         public CombatHit[] getHits(Npc attacker, Mob defender) {
             CombatHit hit = nextRangedHit(attacker, defender, 38);
             hit.setAccurate(false);
             return new CombatHit[]{hit};
         }

         @Override
         public int modifyAccuracy(Npc attacker, Mob defender, int roll) {
             return roll + 50_000;
         }
    	
    }

    /** Galvek magic strategy. */
    private static class Magic extends NpcMagicStrategy {
        public Magic() {
            super(CombatProjectile.getDefinition("EMPTY"));
        }

        
        @Override
        public void hit(Npc attacker, Mob defender, Hit hit) {
        }

        @Override
        public void attack(Npc attacker, Mob defender, Hit hit) {
        }

        @Override
        public void start(Npc attacker, Mob defender, Hit[] hits) {
            Projectile projectile = new Projectile(393, 50, 80, 85, 25);
            attacker.animate(new Animation(7904, UpdatePriority.VERY_HIGH));
            RegionManager.forNearbyPlayer(attacker, 16, other -> {
                projectile.send(attacker, other);
                World.schedule(2, () -> other.damage(nextMagicHit(attacker, other, 38)));
                
            });

            if (Utility.random(0, 10) == 1)
                attacker.speak(Utility.randomElement(SHOUTS));
            defender.prayer.deactivate(Prayer.PROTECT_FROM_MAGIC, Prayer.PROTECT_FROM_MELEE, Prayer.PROTECT_FROM_RANGE);
    		defender.getPlayer().send(new SendMessage("Your overhead prayers have been disabled!"));
        }

        @Override
        public CombatHit[] getHits(Npc attacker, Mob defender) {
            CombatHit hit = nextMagicHit(attacker, defender, 38);
            hit.setAccurate(false);
            return new CombatHit[]{hit};
        }

        @Override
        public int modifyAccuracy(Npc attacker, Mob defender, int roll) {
            return roll + 50_000;
        }
    }

    private static class TeleGrab extends NpcMagicStrategy {
        TeleGrab() {
            super(CombatProjectile.getDefinition("EMPTY"));
        }

        @Override
        public void hit(Npc attacker, Mob defender, Hit hit) {
        }

        @Override
        public void attack(Npc attacker, Mob defender, Hit hit) {
        }

        @Override
        public void start(Npc attacker, Mob defender, Hit[] hits) {
        	
        	int disarmattack = 1;
            int disaramattackrandom = Utility.random(disarmattack, 5);
        	if(disaramattackrandom == disarmattack) {
            attacker.animate(new Animation(7908, UpdatePriority.VERY_HIGH));
            Projectile projectile = new Projectile(1479, 50, 80, 85, 25);
            projectile.send(attacker, defender);
            defender.damage(new Hit(Utility.random(20, 50)));
            attacker.speak("I AM A DECENDENT OF HELL!");
        	}
            int scheduleMove = 1;
            int moveplayers = Utility.random(scheduleMove, 7);
            if(scheduleMove == moveplayers) {
            RegionManager.forNearbyPlayer(attacker, 16, other -> World.schedule(1, () -> {
                Position destination = Utility.randomElement(attacker.boundaries);
                World.sendGraphic(new Graphic(190), destination);
                other.move(destination);
                other.message("Galvek's return made the ground shake, causing you to move.");
            }));
        }
        }

        @Override
        public CombatHit[] getHits(Npc attacker, Mob defender) {
            CombatHit hit = nextMagicHit(attacker, defender, 38);
            hit.setAccurate(false);
            return new CombatHit[]{hit};
        }
    }

    private static class LightingRain extends NpcMagicStrategy {
        LightingRain() {
            super(CombatProjectile.getDefinition("Vet'ion"));
        }

        @Override
        public void hit(Npc attacker, Mob defender, Hit hit) {
        }

        @Override
        public void attack(Npc attacker, Mob defender, Hit hit) {
        }

      
        @Override
        public void start(Npc attacker, Mob defender, Hit[] hits) {
            attacker.animate(new Animation(7901, UpdatePriority.VERY_HIGH));
            Projectile projectile = new Projectile(1155, 50, 80, 85, 25);
            CombatHit hit = nextRangedHit(attacker, defender, 21);
            RegionManager.forNearbyPlayer(attacker, 16, other -> {
                projectile.send(attacker, other);
                Position position = other.getPosition();
                
                World.schedule(2, () -> other.damage(nextMagicHit(attacker, other, 38)));
                World.sendGraphic(new Graphic(287), position);
                if (other.getPosition().equals(position)) {
                    other.damage(new Hit(Utility.random(20, 50)));
                    other.speak("OUCH!");
                }
            });
        }

        @Override
        public CombatHit[] getHits(Npc attacker, Mob defender) {
            CombatHit hit = nextMagicHit(attacker, defender, 38);
            hit.setAccurate(false);
            return new CombatHit[]{hit};
        }
    }
}
