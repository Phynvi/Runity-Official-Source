package io.battlerune.content.freeforall;

import io.battlerune.content.skill.impl.magic.Spellbook;
import io.battlerune.game.world.items.Item;

/**
 * Free For All Data Storage
 * @author hamza
 *
 */
public enum FreeForAllData implements FreeForAllListener {

	DHAROK() {

		@Override
		public String getName() {
			return "Dharok";
		}
		
		@Override
		public Item[] getEquipment() {
			return new Item[] {
					
			};
		}

		@Override
		public Item[] getInventory() {
			return new Item[] {
					
			};
		}

		@Override
		public Spellbook getSpellBook() {
			return Spellbook.MODERN;
		}
		
	};
}
