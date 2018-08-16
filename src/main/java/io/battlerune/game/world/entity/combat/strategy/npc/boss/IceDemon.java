package io.battlerune.game.world.entity.combat.strategy.npc.boss;

import static io.battlerune.game.world.entity.combat.CombatUtil.createStrategyArray;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import io.battlerune.game.Animation;
import io.battlerune.game.Graphic;
import io.battlerune.game.Projectile;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.task.TickableTask;
import io.battlerune.game.world.World;
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
import io.battlerune.game.world.object.CustomGameObject;
import io.battlerune.game.world.pathfinding.TraversalMap;
import io.battlerune.game.world.position.Position;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

/**
 * The combat Script for Ice Demon Boss.
 *
 * @author Adam_#6723
 */
public class IceDemon extends MultiStrategy {
	private static final NpcMeleeStrategy MELEE = NpcMeleeStrategy.get();
	private static final MagicAttack MAGIC = new MagicAttack();
	private static final RangedAttack RANGED = new RangedAttack();



	private static final FrozenSpecial FROZEN_SPECIAL = new FrozenSpecial();
	private static final IceSpecial ICE_SPECIAL = new IceSpecial();

	private static final CombatStrategy<Npc>[] FULL_STRATEGIES = createStrategyArray(MELEE, MAGIC,
			RANGED);
	private static final CombatStrategy<Npc>[] NON_MELEE = createStrategyArray(  MAGIC, RANGED);
	private final CombatStrategy<Npc>[] SPECIALS = createStrategyArray(ICE_SPECIAL, FROZEN_SPECIAL);

	private final Deque<CombatStrategy<Npc>> strategyQueue = new LinkedList<>();
	private int specialIndex;

	public IceDemon() {
		currentStrategy = MELEE;
	}

	@Override
	public void init(Npc attacker, Mob defender) {
		if (strategyQueue.isEmpty()) {
			for (int index = 0; index < 6; index++) {
				strategyQueue.add(RandomUtils.random(FULL_STRATEGIES));
			}
			strategyQueue.add(SPECIALS[specialIndex++ % SPECIALS.length]);
		}
		currentStrategy = strategyQueue.poll();
	}

	@Override
	public boolean canAttack(Npc attacker, Mob defender) {
		if (currentStrategy == MELEE && !MELEE.canAttack(attacker, defender)) {
			currentStrategy = RandomUtils.random(NON_MELEE);
		}
		return currentStrategy.canAttack(attacker, defender);
	}

	@Override
	public boolean withinDistance(Npc attacker, Mob defender) {
		if (currentStrategy == MELEE && !MELEE.withinDistance(attacker, defender)) {
			currentStrategy = RandomUtils.random(NON_MELEE);
		}
		return currentStrategy.canAttack(attacker, defender);
	}

	private static class IceSpecial extends NpcMagicStrategy {
		IceSpecial() {
			super(CombatProjectile.getDefinition("EMPTY"));
		}

		@Override
		public int getAttackDelay(Npc attacker, Mob defender, FightType fightType) {
			return 30;
		}

		// TODO CAVE SNAKE BOSS
		@Override
		public void start(Npc attacker, Mob defender, Hit[] hits) {
			World.schedule(2, () -> {
				attacker.animate(new Animation(69, UpdatePriority.HIGH));
				List<Position> boundaries = TraversalMap.getTraversableTiles(attacker.getPosition().transform(-7, -7),
						30, 30);
				Collections.shuffle(boundaries);

				World.schedule(1, () -> {

					Projectile projectile = new Projectile(605, 10, 85, 26, 25);
					projectile.send(attacker, defender.getPosition());
					World.schedule(AcidTask(defender, defender.getPosition()));

					for (int index = 0; index < 40; index++) {
						Position position = boundaries.get(index);
						projectile.send(attacker, position);
						World.schedule(AcidTask(defender, position));
					}

					final Projectile projectile2 = new Projectile(1014, 15, 95, 26, 25);

					World.schedule(2, () -> World.schedule(specialAttacks(attacker, defender, projectile2)));
				});
			});
		}

		private TickableTask specialAttacks(Mob attacker, Mob defender, Projectile projectile) {
			return new TickableTask(false, 1) {

				@Override
				protected void tick() {
					if (attacker == null || attacker.isDead()) {
						cancel();
						return;
					}

					if (tick > 24) {
						cancel();
						return;
					}

					Position position = defender.getPosition().copy();
					projectile.send(attacker, position);

					World.schedule(3, () -> {
						World.sendGraphic(new Graphic(1312, UpdatePriority.HIGH), position, attacker.instance);

						if (defender.getPosition().equals(position)) {
							defender.writeDamage(new Hit(Utility.random(1, 10)));
						}
					});
				}
			};
		}

		private TickableTask AcidTask(Mob defender, Position position) {
			return new TickableTask(false, 2) {
				private CustomGameObject object;

				@Override
				protected void tick() {
					if (tick == 1) {
						object = new CustomGameObject(31991, defender.instance, position);
						object.register();
					} else if (tick == 13) {
						object.unregister();
						cancel();
						return;
					}

					if (defender.getPosition().equals(position)) {
						defender.writeDamage(new Hit(Utility.random(10, 15)));

					}
				}
			};
		}

		@Override
		public CombatHit[] getHits(Npc attacker, Mob defender) {
			CombatHit combatHit = nextMagicHit(attacker, defender, 0);
			combatHit.setAccurate(true);
			combatHit.setDamage(-1);
			return new CombatHit[] { combatHit };
		}
	}

	private static class RangedAttack extends NpcMagicStrategy {

		RangedAttack() {
			super(CombatProjectile.getDefinition("Icedmon tarn randomAttack"));
		}

		@Override
		public Animation getAttackAnimation(Npc attacker, Mob defender) {
			return new Animation(69, UpdatePriority.HIGH);
		}

		@Override
		public CombatHit[] getHits(Npc attacker, Mob defender) {
			return new CombatHit[] { nextRangedHit(attacker, defender, 32) };
		}
	}

	private static class MagicAttack extends NpcMagicStrategy {

		MagicAttack() {
			super(CombatProjectile.getDefinition("Icedmon tarn randomAttack"));
		}

		@Override
		public Animation getAttackAnimation(Npc attacker, Mob defender) {
			return new Animation(69, UpdatePriority.HIGH);
		}

		@Override
		public CombatHit[] getHits(Npc attacker, Mob defender) {
			return new CombatHit[] { nextRangedHit(attacker, defender, 32) };
		}

	}

	private static class FrozenSpecial extends NpcMagicStrategy {
		private final Projectile PROJECTILE = new Projectile(1324, 5, 85, 85, 25);

		FrozenSpecial() {
			super(CombatProjectile.getDefinition("Crumble Undead"));
		}

		@Override
		public Animation getAttackAnimation(Npc attacker, Mob defender) {
			return new Animation(64, UpdatePriority.HIGH);
		}

		@Override
		public void hit(Npc attacker, Mob defender, Hit hit) {
			World.schedule(4, () -> {
				int randomHit = Utility.random(1, 30);
				Npc shadow = new Npc(7586, new Position(2524, 4655, 0)) {

					@Override
					public void appendDeath() {
						super.appendDeath();

					}
				};
				shadow.register();
				shadow.walkTo(defender, () -> {
					World.sendGraphic(new Graphic(1460, true), shadow.getPosition());
					defender.damage(new Hit(randomHit * shadow.getCurrentHealth() / shadow.getMaximumHealth()));
					defender.graphic(287);
					shadow.unregister();
				});
			});

		}

		@Override
		public int getAttackDelay(Npc attacker, Mob defender, FightType fightType) {
			return 15;
		}

		@Override
		public CombatHit[] getHits(Npc attacker, Mob defender) {
			CombatHit combatHit = nextMagicHit(attacker, defender, -1);
			combatHit.setAccurate(false);
			return new CombatHit[] { combatHit };
		}
	}
}
