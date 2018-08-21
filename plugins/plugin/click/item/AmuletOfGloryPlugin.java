package plugin.click.item;

import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.event.impl.ItemClickEvent;
import io.battlerune.game.event.impl.ItemContainerContextMenuEvent;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.containers.equipment.Equipment;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;

public class AmuletOfGloryPlugin extends PluginContext {

	private static final int[] AMULETS = { 1704, 1706, 1708, 1710, 1712, 11976, 11978 };

	public void teleport(Player player, Item item, Position position, int index, boolean equipment) {
		index = index - 1;

		if (player.wilderness > 20 && !PlayerRight.isPriviledged(player)) {
			player.send(new SendMessage("You can't teleport past 20 wilderness!"));
			return;
		}

		if (Teleportation.teleport(player, position)) {
			if (equipment) {
				player.equipment.set(Equipment.AMULET_SLOT, new Item(AMULETS[index]), true);
			} else {
				player.inventory.remove(item);
				player.inventory.add(AMULETS[index], 1);
			}
			player.message("<col=7F007F>" + (index == 0 ? "You have used your last charge."
					: "Your amulet of glory has " + Utility.convertWord(index).toLowerCase() + "charge"
							+ (index == 1 ? "" : "s") + " remaining."));
		}
	}

	private int getIndex(int item) {
		int index = -1;
		for (int amulet = 0; amulet < AMULETS.length; amulet++) {
			if (item == AMULETS[amulet]) {
				return amulet;
			}
		}
		return index;
	}

	@Override
	protected boolean thirdClickItem(Player player, ItemClickEvent event) {
		Item item = event.getItem();
		int index = getIndex(item.getId());

		if (index == -1) {
			return false;
		}

		if (index == 0) {
			player.message("Your amulet of glory has no charges left!");
			return true;
		}
		if (player.inventory.containsAny(AMULETS)) {

			player.dialogueFactory.sendOption("Edgeville", () -> {
				teleport(player, item, new Position(3087, 3496), index, false);
			}, "Karamja", () -> {
				teleport(player, item, new Position(2918, 3176), index, false);
			}, "Dranyor Village", () -> {
				teleport(player, item, new Position(3105, 3251), index, false);
			}, "Al-Kahrid", () -> {
				teleport(player, item, new Position(3293, 3163), index, false);
			}, "Nowhere", player.interfaceManager::close).execute();
		}
		return true;
	}

	@Override
	protected boolean secondClickItemContainer(Player player, ItemContainerContextMenuEvent event) {
		final int interfaceId = event.getInterfaceId();

		if (interfaceId != 1688) {
			return false;
		}

		final int removeId = event.getRemoveId();
		int index = getIndex(removeId);

		if (index == -1) {
			return false;
		}

		if (index == 0) {
			player.message("Your amulet of glory has no charges left!");
			return true;
		}

		Item item = player.equipment.getAmuletSlot();

		if (item == null) {
			return true;
		}
		if (player.inventory.containsAny(AMULETS)) {
			player.dialogueFactory.sendOption("Edgeville", () -> {
				teleport(player, item, new Position(3087, 3496), index, true);
			}, "Karamja", () -> {
				teleport(player, item, new Position(2918, 3176), index, true);
			}, "Dranyor Village", () -> {
				teleport(player, item, new Position(3105, 3251), index, true);
			}, "Al-Kahrid", () -> {
				teleport(player, item, new Position(3293, 3163), index, true);
			}, "Nowhere", player.interfaceManager::close).execute();
		}
		return true;
	}
}
