package io.battlerune.game.world.entity.combat.strategy.npc.boss.arena;

import static io.battlerune.game.world.entity.combat.CombatUtil.createStrategyArray;
import static io.battlerune.game.world.entity.combat.CombatUtil.randomStrategy;

import io.battlerune.game.Animation;
import io.battlerune.game.Graphic;
import io.battlerune.game.Projectile;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.combat.CombatType;
import io.battlerune.game.world.entity.combat.CombatUtil;
import io.battlerune.game.world.entity.combat.attack.FightType;
import io.battlerune.game.world.entity.combat.hit.CombatHit;
import io.battlerune.game.world.entity.combat.hit.Hit;
import io.battlerune.game.world.entity.combat.projectile.CombatProjectile;
import io.battlerune.game.world.entity.combat.strategy.CombatStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.MultiStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.NpcMagicStrategy;
import io.battlerune.game.world.entity.combat.strategy.npc.NpcMeleeStrategy;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.position.Position;
import io.battlerune.game.world.region.RegionManager;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

/**
 * Handles Skotizo's stategy.
 *
 * @author Adam Trinity
 */
public class Arena extends MultiStrategy {
	private static Magic MAGIC = new Magic();

	private static final CombatStrategy<Npc>[] FULL_STRATEGIES = createStrategyArray(NpcMeleeStrategy.get(), MAGIC);
	private static final CombatStrategy<Npc>[] MAGIC_STRATEGIES = createStrategyArray(MAGIC, MAGIC, MAGIC);

	private static final String[] SHOUTS = { "Feel the wrath of Glod!", "The dark times have come for you all!" };

	/** Constructs a new <code>Arena</code>. */
	public Arena() {
		currentStrategy = MAGIC;
	}

	@Override
	public boolean canAttack(Npc attacker, Mob defender) {
		if (!currentStrategy.withinDistance(attacker, defender)) {
			currentStrategy = randomStrategy(MAGIC_STRATEGIES);
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

	/** Arena magic strategy. */
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


			Projectile projectile = new Projectile(1028, 50, 80, 85, 25);
			attacker.animate(new Animation(6501, UpdatePriority.VERY_HIGH));
			CombatUtil.areaAction(attacker, 64, 18, mob -> {
				projectile.send(attacker, defender);
				mob.damage(nextMagicHit(attacker, defender, Utility.random(15, 38)));
			});

			if (Utility.random(0, 2) == 1)
				attacker.speak(Utility.randomElement(SHOUTS));
		}

		@Override
		public CombatHit[] getHits(Npc attacker, Mob defender) {
			CombatHit hit = nextMagicHit(attacker, defender, 38);
			hit.setAccurate(false);
			return new CombatHit[] { hit };
		}

		@Override
		public int modifyAccuracy(Npc attacker, Mob defender, int roll) {
			return roll + 50_000;
		}
	}


		@Override
		public CombatHit[] getHits(Npc attacker, Mob defender) {
			CombatHit hit = nextMagicHit(attacker, defender, 38);
			hit.setAccurate(false);
			return new CombatHit[] { hit };
		}
	}

