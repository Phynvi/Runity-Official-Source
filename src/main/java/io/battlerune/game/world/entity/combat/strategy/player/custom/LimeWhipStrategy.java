package io.battlerune.game.world.entity.combat.strategy.player.custom;

import io.battlerune.game.Animation;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.combat.attack.FightType;
import io.battlerune.game.world.entity.combat.hit.CombatHit;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.combat.strategy.player.PlayerMeleeStrategy;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * 
 * @author adameternal123 // Adam_#6723
 *
 */

public class LimeWhipStrategy extends PlayerMeleeStrategy {

	private static final LimeWhipStrategy INSTANCE = new LimeWhipStrategy();

	public String name() {
		return "Lime Whip";
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MELEE;
	}

	/** Atack delay. **/

	@Override
	public int getAttackDelay(Player attacker, Mob defender, FightType fightType) {
		return 2;
	}

	/** Instane's the class to be called upon,and applied to an item. **/
	public static LimeWhipStrategy get() {
		return INSTANCE;
	}

	private static final Animation ANIMATION = new Animation(1658, UpdatePriority.HIGH);

	@Override
	public void attack(Player attacker, Mob defender, Hit hit) {
		super.attack(attacker, defender, hit);
	}

	@Override
	public void start(Player attacker, Mob defender, Hit[] hits) {
		super.start(attacker, defender, hits);
		// TODO EFFECT
	}

	@Override
	public CombatHit[] getHits(Player attacker, Mob defender) {
		return new CombatHit[] { nextMeleeHit(attacker, defender) };
	}

	@Override
	public Animation getAttackAnimation(Player attacker, Mob defender) {
		return ANIMATION;
	}

	@Override
	public int modifyAccuracy(Player attacker, Mob defender, int roll) {
		return roll * 5 / 2;
	}

}
