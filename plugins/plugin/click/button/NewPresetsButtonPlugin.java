package plugin.click.button;



import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;


public class NewPresetsButtonPlugin extends PluginContext {
	
	
	

	/**
	 * @author Adam_#6723
	 */
	
	/** RuneZerker Inventory! Array**/
	  public Item[] Melee126Inventory() {
	        return new Item[] {
	            new Item(12695), new Item(3024), new Item(3024), new Item(391),
	            new Item(391), new Item(391), new Item(391), new Item(391),
	            new Item(391), new Item(391), new Item(391), new Item(391),
	            new Item(391), new Item(391), new Item(391), new Item(391),
	            new Item(3144), new Item(3144), new Item(391), new Item(391),
	            new Item(3144), new Item(3144), new Item(391), new Item(391),
	            new Item(11802), new Item(557, 500), new Item(560, 500), new Item(9075, 500)
	        };
	    }
	  
	  /** AGS Equipment Array. **/
	  public Item[] AGSMeleeEquipment() {
	        return new Item[] { new Item(10828), new Item(10551), new Item(1079), new Item(3105), new Item(4587), new Item(12954), new Item(1725), new Item(2550), new Item(7462), new Item(6570) };
	    }
	  
	  public Item[] Melee126Equipment() {
	        return new Item[] { new Item(10828), new Item(4720), new Item(4722), new Item(3105), new Item(21225), new Item(12954), new Item(1725), new Item(2550), new Item(7462), new Item(6570) };
	    }
	  
	  
	  public void sendMelee123Dialogue(Player player) {
		  
          DialogueFactory factory = player.dialogueFactory;
		  factory.sendNpcChat(306, "Would you like this preset for 100k? " + player.getName());
		  factory.sendOption("Yes", () -> Melee126(player), 
	        		"Nevermind", factory::clear);
	        factory.execute();

	  }
	  
	  /**
	   * Handles the equipping of gear, whilst also subtracting the preset cost from the players inventory!
	   * @param player
	   */
	  public void Melee126(Player player) {
   if(player.inventory.contains(995, 100000)) {
	  player.inventory.remove(995, 100000);

	 if(!player.equipment.isEmpty() || !player.inventory.isEmpty()) {
		 player.bank.depositeInventory();
	     player.bank.depositeEquipment();
	     player.bank.shift();
	     player.bank.refresh();
			 
		 
	     player.equipment.manualWearAll(AGSMeleeEquipment());
	     player.inventory.addAll(Melee126Inventory());
	     player.inventory.refresh();
	     player.equipment.refresh();
	  }
	  
	  } else {
         player.message("You don't have enough!");
	   }
  
  
	}
    @Override
    protected boolean onClick(Player player, int button) {
  if(button == -23029) {
	  sendMelee123Dialogue(player);
  }
  
  if(button == -23028) {
	 if(!player.equipment.isEmpty() || !player.inventory.isEmpty()) {//vorkath is ez with the right anims/gfx
		 player.bank.depositeInventory();
         player.bank.depositeEquipment();
         player.bank.shift();
         player.bank.refresh();
		 
	 }
	  player.equipment.manualWearAll(Melee126Equipment());
	  player.inventory.addAll(Melee126Inventory());
	  player.inventory.refresh();
	  player.equipment.refresh();

	 
	/*  player.inventory.add(4722, 1);
	  int index = player.inventory.computeIndexForId(4722);
	  player.equipment.equip(index);*/
	 
  }
  
            
       

        
        
        
        return false;
    }
}
