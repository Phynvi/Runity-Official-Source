package io.battlerune.content.upgrading;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.ItemDefinition;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;

public class UpgradeListener {

	private Player player;
	private Item item;

	public UpgradeListener(Player player, Item item) {
		this.player = player;
		this.item = item;
	}

	public void execute() {
		for (Upgrade upgrade : Upgrade.values()) {
			if (upgrade.getReward()[0].equalIds(item)) {
				if (player.inventory.contains(upgrade.getReward()[0])
						&& player.inventory.contains(upgrade.getEtharRequirement())) {
					player.inventory.remove(upgrade.getReward()[0]);
					player.inventory.remove(upgrade.getEtharRequirement());
					player.send(new SendMessage("STATUS: " + setExecution(upgrade)));
				} else {
					player.send(new SendMessage("@red@You do not have the requirements for this item!"));
					player.send(new SendMessage("@red@Requirements: [" + upgrade.getReward()[0].getName() + ", "
							+ upgrade.getReward()[0].getAmount() + "] : [" + upgrade.getEtharRequirement().getName()
							+ ", " + upgrade.getEtharRequirement().getAmount() + "]"));
				}
			}
		}
	}

	private int random = Utility.random(100);
	
	private UpgradeStatus setExecution(Upgrade upgrade) {
		if (random < (100 * upgrade.getChance())) {
			player.inventory.add(upgrade.getReward()[1]);
			World.sendMessage("[UPGRADE] " + player.getUsername() + " have succesfully upgraded "
					+ String.format(ItemDefinition.get(upgrade.getReward()[1].getId()).getName()));
			return UpgradeStatus.SUCCES;
		}
		return UpgradeStatus.FAILED;
	}
}
