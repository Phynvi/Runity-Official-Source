package io.battlerune.game.world.region.dynamic;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.game.world.region.dynamic.boss.DynamicRegionHandler;

/**
 * 
 * @author Teek
 * 
 * Creation Date: 07:02am - 10//16/2018
 *
 */
public class DynamicRegion {
	
	/** Represents the player **/
	private Player player;
	
	/** Variable to handle Dynamic Instance ***/
	private RegionType type;
	
	/** Tile used for the dynamic region **/
	private Position instancedPosition;
	
	/** Boolean check if the instance is for a Boss **/
	private boolean npcInstance;
	
	/** Variable for the instanced controller **/
	private DynamicRegionHandler handler;
	
	/** Get method for the instance controller **/
	public DynamicRegionHandler getHandler() {
		return handler;
	}
	
	public static enum RegionType {
		
		ZULRAH(new Position(2268, 3070, 0));
		
		public Position position;
		
		RegionType(Position position) {
			this.position = position;
		}
	}
	
	/***
	 * Basic constructor for the NPC instances
	 * @param player
	 * @param type
	 */
	public DynamicRegion(Player player, RegionType type) {
		this.player = player;
		this.type = type;
		this.npcInstance = true;
		createInstance();
	}
	
	/***
	 * Basic constructor for Tile instances
	 * @param player
	 * @param instancedPosition
	 */
	public DynamicRegion(Player player, Position instancedPosition) {
		this.player = player;
		this.instancedPosition = instancedPosition;
		createInstance();
	}

	/***
	 * Creates the instance
	 */
	private void createInstance() {
		if (npcInstance) {
		    this.handler = DynamicRegionHandler.controllers.get(type);
		    
		    if (!this.getHandler().metRequirements(player)) {
		    	destroyInstance(true);
		    	return;
		    }
		    this.getHandler().onStart(player);
		}
		player.move(npcInstance ? getInstanceLocation() : getInstancePosition());
	}
	
	public void destroyInstance(boolean failedRequirements) {
		this.getHandler().onExit(player);
		player.setDynamicRegion(null);
		this.handler = null;
			
	}
	
	/***
	 * Gets the Tiles used for the Tile instance
	 * @return
	 */
	public Position getInstancePosition() {
		return new Position(instancedPosition.getX(), instancedPosition.getY(), instancedPosition.getDynamicHeight(player));
	}
	
	/**
	 * Gets the Tiles used for the NPC Instance
	 * @return
	 */
	public Position getInstanceLocation() {
		return new Position(type.position.getX(), type.position.getY(), type.position.getDynamicHeight(player));
	}

}
