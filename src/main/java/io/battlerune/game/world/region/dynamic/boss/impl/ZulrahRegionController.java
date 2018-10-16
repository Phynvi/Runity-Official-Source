package io.battlerune.game.world.region.dynamic.boss.impl;

import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.object.GameObject;
import io.battlerune.game.world.region.dynamic.boss.DynamicRegionHandler;

/**
 * 
 * @author Teek
 *
 */
public class ZulrahRegionController extends DynamicRegionHandler {

	@Override
	public void onStart(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean metRequirements(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void process(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleObjectInteraction(int objectOption, GameObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNpcAttack(Npc npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onNPCDeath(Npc npc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayerDeath(Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean allowTeleportation(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onExit(Player player) {
		// TODO Auto-generated method stub
		
	}


}
