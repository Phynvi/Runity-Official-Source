package io.battlerune.game.world.entity.mob.npc.dropchance;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;

public class DropChanceHandler {

	private Player player;
	private DropChanceData data;

	public DropChanceHandler(Player player) {
		this.player = player;
	}

	public DropChanceHandler(Player player, DropChanceData data) {
		this.player = player;
		this.data = data;
	}

	public double modify() {
		switch (data.getType()) {

		case EQUIPMENT:
			if (player.equipment.contains(data.getItemId())) {
				return data.getModifier();
			}
		case INVENTORY:
			if (player.inventory.contains(data.getItemId())) {
				return data.getModifier();
			}
		default:
			break;
		}
		return 1.0;
	}

	public double getDroprate() {
		for (DropChanceData data : DropChanceData.values()) {
			for (Item item : player.equipment) {
				if (item != null) {
					if (data.getItemId() == item.getId()) {
						return data.getModifier();
					}
				}
			}
		}
		return 0;
	}
}
