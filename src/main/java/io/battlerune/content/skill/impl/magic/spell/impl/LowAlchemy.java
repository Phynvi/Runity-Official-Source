package io.battlerune.content.skill.impl.magic.spell.impl;

import java.util.Arrays;

import io.battlerune.Config;
import io.battlerune.content.activity.randomevent.RandomEventHandler;
import io.battlerune.content.experiencerate.ExperienceModifier;
import io.battlerune.content.skill.impl.magic.Magic;
import io.battlerune.content.skill.impl.magic.Spellbook;
import io.battlerune.content.skill.impl.magic.spell.Spell;
import io.battlerune.game.Animation;
import io.battlerune.game.Graphic;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.skill.Skill;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendForceTab;
import io.battlerune.net.packet.out.SendMessage;

/**
 * The high alchemy spell.
 * 
 * @author Daniel
 */
public class LowAlchemy implements Spell {

	@Override
	public String getName() {
		return "Low alchemy";
	}

	@Override
	public int getLevel() {
		return 21;
	}

	@Override
	public Item[] getRunes() {
		return new Item[] { new Item(554, 3), new Item(561, 1) };
	}

	@Override
	public void execute(Player player, Item item) {
		if (player.spellbook != Spellbook.MODERN)
			return;

		if (!player.spellCasting.castingDelay.elapsed(500)) {
			return;
		}

		if (Arrays.stream(Magic.UNALCHEABLES).anyMatch($it -> item.getId() == $it.getId())) {
			player.send(new SendMessage("You can not alch this item!"));
			return;
		}

		int value = item.getLowAlch();

		if (value > 10000) {
			player.send(new SendMessage("The value of this item is too high and can not be low-alched."));
			return;
		}

		player.animate(new Animation(712));
		player.graphic(new Graphic(112, true));
		player.inventory.remove(item.getId(), 1);
		player.inventory.removeAll(getRunes());
		player.inventory.add(Config.CURRENCY, value == 0 ? 1 : value);
		player.inventory.refresh();
		player.send(new SendForceTab(6));
		player.skills.addExperience(Skill.MAGIC,
				(31 * (Config.MAGIC_MODIFICATION + 5)) * new ExperienceModifier(player).getModifier());
		player.spellCasting.castingDelay.reset();
		player.action.clearNonWalkableActions();
		RandomEventHandler.trigger(player);
	}
}
