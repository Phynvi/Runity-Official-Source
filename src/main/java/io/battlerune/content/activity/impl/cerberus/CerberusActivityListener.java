package io.battlerune.content.activity.impl.cerberus;

import io.battlerune.content.activity.ActivityListener;
import io.battlerune.game.world.Interactable;
import io.battlerune.game.world.entity.combat.attack.FightType;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.position.Position;
import io.battlerune.util.Utility;

/**
 * 
 * @author Adam_#6723
 *
 */

public class CerberusActivityListener extends ActivityListener<CerberusActivity> {

	CerberusActivityListener(CerberusActivity minigame) {
		super(minigame);
	}

	@Override
	public boolean withinDistance(Mob attacker, Mob defender) {
		if (!attacker.isPlayer())
			return true;
		FightType fightType = attacker.getCombat().getFightType();
		int distance = attacker.getStrategy().getAttackDistance(attacker, fightType);
		Interactable cerberus = Interactable.create(new Position(1238, 1250, attacker.getHeight()), 4, 4);
		return Utility.getDistance(attacker, cerberus) <= distance
				&& attacker.getStrategy().withinDistance(attacker, activity.cerberus);
	}

	@Override
	public boolean canAttack(Mob attacker, Mob defender) {
		return activity.cerberus == null || !activity.cerberus.isDead();
	}

	@Override
	public void hit(Mob attacker, Mob defender, Hit hit) {
		if (!attacker.isPlayer() && !defender.isNpc()) {
			return;
		}
	}

	@Override
	public void onDeath(Mob attacker, Mob defender, Hit hit) {
	}
}