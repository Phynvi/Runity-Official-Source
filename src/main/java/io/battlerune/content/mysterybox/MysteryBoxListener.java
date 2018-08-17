package io.battlerune.content.mysterybox;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;

/**
 * Interface mystery box system
 * @author Nerik#8690
 *
 */
public interface MysteryBoxListener {

	/**
	 * returns the loot
	 * @return
	 */
	Item[] getCommon();
	
	Item[] getUncommon();
	
	Item[] getRare();
	
	Item[] getUltra();
	
	/**
	 * Executes special action
	 */
	void execute(Player player);
}
