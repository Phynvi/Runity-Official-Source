package io.battlerune.content.skill.impl.mining;

import java.util.Arrays;

import io.battlerune.content.event.impl.ObjectInteractionEvent;
import io.battlerune.content.skill.SkillRepository;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.skill.Skill;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.object.GameObject;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;
import io.battlerune.util.chance.Chance;
import io.battlerune.util.chance.WeightedChance;

/**
 * Handles the mining skill.
 *
 * @author Daniel
 */
public final class Mining extends Skill {

	static final Chance<Item> GEM_ITEMS = new Chance<>(Arrays.asList(new WeightedChance<>(6, new Item(1623, 1)), // SAPPHIRE
			new WeightedChance<>(5, new Item(1621, 1)), // EMERALD
			new WeightedChance<>(4, new Item(1619, 1)), // RUBY
			new WeightedChance<>(3, new Item(1617, 1)), // DIAMOND
			new WeightedChance<>(1, new Item(1631, 1)) // DRAGON_STONE
	));

	/** Constructs a new {@link Mining} skill. */
	public Mining(int level, double experience) {
		super(Skill.MINING, level, experience);
	}

	@Override
	protected boolean clickObject(Player player, ObjectInteractionEvent event) {
		GameObject object = event.getObject();
		OreData ore = OreData.forId(object.getDefinition().getId());

		if (ore == null) {
			return false;
		}

		if (!object.active()) {
			return false;
		}

		switch (event.getType()) {
		case FIRST_CLICK_OBJECT:
			attempt(player, object, ore);

			break;
		case SECOND_CLICK_OBJECT:
			player.send(new SendMessage("You examine the rock for ores..."));
			World.schedule(2,
					() -> player.send(new SendMessage("This rock contains " + Utility.formatEnum(ore.name()) + ".")));
			break;
		}
		return true;
	}

	private void attempt(Player player, GameObject object, OreData ore) {
		PickaxeData pickaxe = PickaxeData.getBestPickaxe(player).orElse(null);

		if (pickaxe == null) {
			player.message("You don't have a pickaxe.");
			return;
		}

		if (!player.skills.get(Skill.MINING).reqLevel(pickaxe.level)) {
			player.message("You need a level of " + pickaxe.level + " to use this pickaxe!");
			return;
		}

		if (!player.skills.get(Skill.MINING).reqLevel(ore.level)) {
			player.message("You need a mining level of " + ore.level + " to mine this ore!");
			return;
		}

		start(player, object, ore, pickaxe);
	}

	private void start(Player player, GameObject object, OreData ore, PickaxeData pickaxe) {
		if (!object.getGenericAttributes().has("ores")) {
			object.getGenericAttributes().set("ores", ore.oreCount);
		}

		player.action.execute(new MiningAction(player, object, ore, pickaxe));
		player.skills.get(Skill.MINING).setDoingSkill(true);
		player.message("You swing your pick at the rock...");
	}

	public static boolean success(Player player, OreData ore, PickaxeData pickaxe) {
		return SkillRepository.isSuccess(player, Skill.MINING, ore.level, pickaxe.level);
	}
}
