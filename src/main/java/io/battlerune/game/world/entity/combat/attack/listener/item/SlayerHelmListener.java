package io.battlerune.game.world.entity.combat.attack.listener.item;

import io.battlerune.game.world.entity.combat.attack.listener.ItemCombatListenerSignature;
import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * Handles the slayer helmet / black mask effects ofr slayer tasks.
 *
 * @author Michael | Chex
 */
@ItemCombatListenerSignature(requireAll = false, items = {
		/* Slayer helmets */
		11864, 19639, 19643, 19647, 21264,

		/* Black masks */
		8901, 8903, 8905, 8907, 8909, 8911, 8913, 8915, 8917, 8919, 8921 })
public class SlayerHelmListener extends SimplifiedListener<Player> {

	@Override
	public int modifyAttackLevel(Player attacker, Mob defender, int level) {
		if (attacker.slayer.getTask() != null && attacker.slayer.getTask().valid(defender.id))
			return level * 7 / 6;
		return level;
	}

	@Override
	public int modifyStrengthLevel(Player attacker, Mob defender, int level) {
		if (attacker.slayer.getTask() != null && attacker.slayer.getTask().valid(defender.id))
			return level * 7 / 6;
		return level;
	}

}
