package io.battlerune.game.world.entity.combat.attack.listener.item;

import io.battlerune.game.Graphic;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.combat.attack.listener.ItemCombatListenerSignature;
import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.prayer.Prayer;
import io.battlerune.util.Utility;

/**
 * Handles the Chi/kril armour effect, which if equipped reduces drain rate by 12% 
 * && steals 25% of the mob's life for the player themselves.
 *
 * @author Adam_#6723
 */
@ItemCombatListenerSignature(requireAll = false, items = { 13703, 13704, 13705})
public class ChiSetListener extends SimplifiedListener<Mob> {

	public void method(Mob attacker) {
		for(Prayer prayer : Prayer.values()) {
			prayer.setdrainRate(prayer.getDrainRate() / 12 );
		}
	}
	
	@Override
	public void hit(Mob attacker, Mob defender, Hit hit) {
		if (Math.random() > 0.50) {
			attacker.heal(hit.getDamage() / 4);
			attacker.graphic(new Graphic(398, UpdatePriority.HIGH));			
		}
	}

	@Override
	public void block(Mob attacker, Mob defender, Hit hit, CombatType combatType) {
		method(attacker);
	}

}
