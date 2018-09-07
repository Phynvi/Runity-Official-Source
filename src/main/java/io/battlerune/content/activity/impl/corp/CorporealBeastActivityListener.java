package io.battlerune.content.activity.impl.corp;

import io.battlerune.content.activity.ActivityListener;
import io.battlerune.game.world.Interactable;
import io.battlerune.game.world.entity.combat.attack.FightType;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.position.Position;
import io.battlerune.util.Utility;

public class CorporealBeastActivityListener extends ActivityListener<CorporealBeastActivity> {

	CorporealBeastActivityListener(CorporealBeastActivity corpActivity) {
		super(corpActivity);
	}

	@Override
	public boolean withinDistance(Mob attacker, Mob defender) {
		if (!attacker.isPlayer())
			return true;
		FightType fightType = attacker.getCombat().getFightType();
		int distance = attacker.getStrategy().getAttackDistance(attacker, fightType);
		Interactable corporeal = Interactable.create(new Position(2986, 4381, attacker.getHeight()), 4, 4);
		return Utility.getDistance(attacker, corporeal) <= distance
				&& attacker.getStrategy().withinDistance(attacker, activity.corp);
	}

	@Override
	public boolean canAttack(Mob attacker, Mob defender) {
		return activity.corp == null || !activity.corp.isDead();
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
