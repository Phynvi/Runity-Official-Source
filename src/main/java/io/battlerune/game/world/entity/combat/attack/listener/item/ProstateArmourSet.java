package io.battlerune.game.world.entity.combat.attack.listener.item;

import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.combat.attack.listener.ItemCombatListenerSignature;
import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.prayer.Prayer;

/**
 * Handles the proselyte armour effect, which if equipped reduces drain rate by
 * 10%
 *
 * @author Adam_#6723
 */
@ItemCombatListenerSignature(requireAll = false, items = { 9672, 9674, 9676 })
public class ProstateArmourSet extends SimplifiedListener<Player> {

	public void method(Mob attacker) {
		for (Prayer prayer : Prayer.values()) {
			prayer.setdrainRate(prayer.getDrainRate() / 10);
		}
	}

	@Override
	public void block(Mob attacker, Player defender, Hit hit, CombatType combatType) {
		method(attacker);
	}

}
