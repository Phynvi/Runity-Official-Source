package io.battlerune.game.world.region.dynamic.boss.impl;

import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.region.dynamic.boss.DynamicRegionController;

/**
 * 
 * @author Teek
 *
 */
public class ZulrahRegionController extends DynamicRegionController {

	@Override
	public boolean handleObjectInteraction(int opcode, int objectId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNpcAttack(Npc npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onStart(Player player) {
		// TODO Auto-generated method stub
		
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
	public boolean requirements(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onExit(Player player) {
		// TODO Auto-generated method stub
		
	}

	
}
