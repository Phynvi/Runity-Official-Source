package io.battlerune.game.action.impl;

import io.battlerune.Config;
import io.battlerune.content.experiencerate.ExperienceModifier;
import io.battlerune.game.Animation;
import io.battlerune.game.action.Action;
import io.battlerune.game.action.policy.WalkablePolicy;
import io.battlerune.game.task.impl.ObjectReplacementEvent;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.skill.Skill;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.object.GameObject;

/**
 * Handles picking up a flax.
 * 
 * @author Daniel
 */
public final class FlaxPickingAction extends Action<Player> {

	/** The flax game object. */
	private final GameObject object;

	/** The ticks. */
	private boolean pickup;

	/**
	 * Constructs a new <code>FlaxPickingAction</code>.
	 *
	 * @param player The player instance.
	 * @param object The flax game object.
	 */
	public FlaxPickingAction(Player player, GameObject object) {
		super(player, 2, true);
		this.object = object;
	}

	@Override
	public void execute() {
		Player player = getMob().getPlayer();

		if (pickup) {
			player.inventory.add(new Item(1779, 1));
			player.skills.addExperience(Skill.CRAFTING,
					(7 * Config.CRAFTING_MODIFICATION) * new ExperienceModifier(player).getModifier());
			// if (Utility.random(6) == 1) {
			// }
			cancel();
		} else {
			player.animate(new Animation(827));
			pickup = true;

			setDelay(2);
		}
		World.schedule(new ObjectReplacementEvent(object, 5));

	}

	@Override
	public String getName() {
		return "Flax picking";
	}

	@Override
	public boolean prioritized() {
		return false;
	}

	@Override
	public WalkablePolicy getWalkablePolicy() {
		return WalkablePolicy.NON_WALKABLE;
	}
}