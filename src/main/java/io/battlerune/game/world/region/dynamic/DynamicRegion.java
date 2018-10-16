package io.battlerune.game.world.region.dynamic;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;

/**
 * 
 * @author Teek
 * 
 * Creation Date: 07:02am - 10//16/2018
 *
 */
public class DynamicRegion {
	
	private Player player;
	
	private RegionType type;
	
	private Position instancedPosition;
	
	private boolean npcInstance;
	
	public static enum RegionType {
		
		ZULRAH(new Position(2268, 3070, 0));
		
		public Position position;
		
		RegionType(Position position) {
			this.position = position;
		}
	}
	
	public DynamicRegion(Player player, RegionType type) {
		this.player = player;
		this.type = type;
		this.npcInstance = true;
		createInstance();
	}
	
	public DynamicRegion(Player player, Position instancedPosition) {
		this.player = player;
		this.instancedPosition = instancedPosition;
		createInstance();
	}

	private void createInstance() {
		player.move(npcInstance ? getInstanceLocation() : getInstancePosition());
	}
	
	
	public Position getInstancePosition() {
		return new Position(instancedPosition.getX(), instancedPosition.getY(), instancedPosition.getDynamicHeight(player));
	}
	
	public Position getInstanceLocation() {
		return new Position(type.position.getX(), type.position.getY(), type.position.getDynamicHeight(player));
	}

}
