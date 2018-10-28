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
	private boolean useController;
	
	/** Variable for the instanced controller **/
	private DynamicRegionHandler handler;
	
	/** Get method for the instance controller **/
	public DynamicRegionHandler getHandler() {
		return handler;
	}
	
	public static enum RegionType {
		
		ZULRAH(new Position(2268, 3070, 0)),
		
		
		All_FOR_ONE_4(new Position(2920, 4384, 0)),
		
		;
		
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
		this.useController = true;
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
		    this.handler = DynamicRegionHandler.controllers.get(type);//TODO
		    
		    if (!this.getHandler().metRequirements(player)) {
		    	destroyInstance(true);
		    	return;
		    }
		    player.move(useController ? getInstanceLocation() : player.partyLeader != null ? getLeaderPosition(player.partyLeader) : getInstancePosition());
		    this.getHandler().onStart(player);
		
		
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
	
	public Position getLeaderPosition(Player leader) {
		return new Position(instancedPosition.getX(), instancedPosition.getY(), instancedPosition.getDynamicHeight(leader));
	}
	
	/**
	 * Gets the Tiles used for the NPC Instance
	 * @return
	 */
	public Position getInstanceLocation() {
		return new Position(type.position.getX(), type.position.getY(), type.position.getDynamicHeight(player));
	}

}
