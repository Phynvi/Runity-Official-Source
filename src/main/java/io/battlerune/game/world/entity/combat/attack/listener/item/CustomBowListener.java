package io.battlerune.game.world.entity.combat.attack.listener.item;

import io.battlerune.game.world.entity.combat.attack.listener.ItemCombatListenerSignature;
import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

/**
 * @author Adam_#6723
 */
@ItemCombatListenerSignature(requireAll = true, items = {13749, 13831, 13713})
public class CustomBowListener extends SimplifiedListener<Mob> {

	@Override
	public void hit(Mob attacker, Mob defender, Hit hit) {
		
		if(Utility.random(1, 3) < 1) {
		if (hit.getDamage() <= 0) {
			hit.setDamage(RandomUtils.inclusive(5, 40));
	     	}
		}
	}
}
