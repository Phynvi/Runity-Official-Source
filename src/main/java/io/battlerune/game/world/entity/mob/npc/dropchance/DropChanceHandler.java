package io.battlerune.game.world.entity.mob.npc.dropchance;

import io.battlerune.Config;
import io.battlerune.game.world.entity.mob.player.Player;

public class DropChanceHandler {

	private Player player;

	public DropChanceHandler(Player player) {
		this.player = player;
	}

	public int droprate = 0;
    public int fakerate = 0;
	
	public int getRate() {
		for (int i = 0; i < player.equipment.getEquipment().length; i++) {
			if (player.equipment.getEquipment()[i] != null) {
				for (DropChanceData data : DropChanceData.values()) {
					if (data.getItemId() == player.equipment.getEquipment()[i].getId()) {
						if (droprate >= 200) {
							return 200;
						}
						droprate += data.getModifier();
					}
				}
			}
		}
		return droprate;
	}
	
	public int getfakerate() {
		for (int i = 0; i < player.equipment.getEquipment().length; i++) {
			if (player.equipment.getEquipment()[i] != null) {
				for (DropChanceData data : DropChanceData.values()) {
					if (data.getItemId() == player.equipment.getEquipment()[i].getId()) {
						if (fakerate >= 100) {
							return 100;
						}
						fakerate += data.getlyingModifier();
					}
				}
			}
		}
		if(Config.DR_15_BOOST == true) {
			return fakerate + 15;	
		} 
		if(Config.DR_30_BOOST == true) {
			return fakerate + 30;	
		}
		else {
			
		return fakerate;
		
		}
	}
}
