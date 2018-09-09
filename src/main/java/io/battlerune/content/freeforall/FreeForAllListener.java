package io.battlerune.content.freeforall;

import io.battlerune.content.skill.impl.magic.Spellbook;
import io.battlerune.game.world.items.Item;

/**
 * Free For All Implementation Class
 * @author Nerik#8690
 *
 */
public interface FreeForAllListener {

	
	/**
	 * Returns the name of the free for all type
	 * @return
	 */
	String getName();

	/**
	 * Returns the equipment of the free for all type
	 * @return
	 */
	Item[] getEquipment();

	/**
	 * Returns the inventory of the free for all type
	 * @return
	 */
	Item[] getInventory();
	
	/**
	 * Returns the spell book type of the free for all type
	 * @return
	 */
	Spellbook getSpellBook();
	
}
