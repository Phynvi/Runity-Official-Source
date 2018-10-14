package io.battlerune.game.world.entity.combat.attack.listener.item;

import io.battlerune.game.Graphic;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.combat.attack.listener.ItemCombatListenerSignature;
import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.prayer.Prayer;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

/**
 * Handles the Lime whip effect, which if equipped reduces drain rate by 25%
 * && steals 50% of the mob's life for the player themselves.
 *
 * @author Adam_#6723
 */
@ItemCombatListenerSignature(requireAll = false, items = {21225, 13749})
public class LimeWhipListener extends SimplifiedListener<Mob> {

	public int healingGraphic = 1296;

	public void method(Mob attacker) {
		for (Prayer prayer : Prayer.values()) {
			prayer.setdrainRate(prayer.getDrainRate() / 2);
		}
	}

	@Override
	public void hit(Mob attacker, Mob defender, Hit hit) {
		if (Math.random() > 0.35) {
			attacker.heal(hit.getDamage() / 3);
			attacker.graphic(new Graphic(healingGraphic, UpdatePriority.HIGH));
		}
		if(Utility.random(1, 3) < 1) {
		if (hit.getDamage() <= 0) {
			hit.setDamage(RandomUtils.inclusive(5, 40));
	     	}
		}
	}

	@Override
	public void block(Mob attacker, Mob defender, Hit hit, CombatType combatType) {
		method(attacker);
	}
}
