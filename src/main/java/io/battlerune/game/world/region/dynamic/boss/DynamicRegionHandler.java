package io.battlerune.game.world.region.dynamic.boss;

import java.util.*;

import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.object.GameObject;
import io.battlerune.game.world.position.Position;
import io.battlerune.game.world.region.dynamic.DynamicRegion.RegionType;
import io.battlerune.game.world.region.dynamic.boss.impl.ZulrahRegionController;

/**
 * 
 * @author Teek
 * 
 * Creation Date: 10/16/2018 - 08:06am
 *
 */
public abstract class DynamicRegionHandler {
	
	
	public static Map<RegionType, DynamicRegionHandler> controllers = new HashMap<RegionType, DynamicRegionHandler>();

	public abstract void onStart(Player player);
	
	public abstract boolean metRequirements(Player player);
	
	public abstract void process(Player player);
	
	public abstract boolean handleObjectInteraction(int objectOption, GameObject object);
	
	public abstract boolean handleNpcAttack(Npc npc);//TODO
	
	public abstract void onNPCDeath(Npc npc);
	
	public abstract void onPlayerDeath(Player player);
	
	public abstract boolean allowTeleportation(Player player);
	
	public abstract void onExit(Player player);//TODO
	
	static {
		controllers.put(RegionType.ZULRAH, new ZulrahRegionController());
		
	}
}
