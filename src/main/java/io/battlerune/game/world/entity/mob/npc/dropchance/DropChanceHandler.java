package io.battlerune.game.world.entity.mob.npc.dropchance;

import io.battlerune.game.world.entity.mob.player.Player;

public class DropChanceHandler {

	private Player player;
	private DropChanceData data;

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
}
