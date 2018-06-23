package plugin.click.button;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import io.battlerune.Config;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.content.pet.PetData;
import io.battlerune.content.pet.Pets;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.content.store.Store;
import io.battlerune.content.tittle.TitleManager;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.combat.strategy.player.special.CombatSpecial;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendRunEnergy;
import io.battlerune.util.Utility;

public class DonatorButtonPlugin extends PluginContext {
    
    /**
     * @author Adam_#6723
     */
    @Override
    protected boolean onClick(Player player, int button) {
        if (button == -8328) {
            player.donatorDeposit.confirm();
            return true;
        }
        if (button == -15115) {
            Teleportation.teleport(player, Config.DONATOR_ZONE);
            return true;
        }
        
        if(button == -15111) {
         TitleManager.open(player);
         player.message("Here donators can set their titles!");
        }
        if(button == -15107) {
            Store.STORES.get("Pet Store").open(player);
         player.message("Donator's can purchase the pets from here! They are untradeable but have amazing benefits!");
        }
        
        if(button == -15099) {
            Store.STORES.get("PK Supply Store").open(player);
       //  player.message("Donator's can purchase the pets from here! They are untradeable but have amazing benefits!");
        }
        
        if(button == -15095) {
        	
        	int length = PlayerRight.isDonator(player) ? 60 : 2;
            if (!player.BankerPetDelay.elapsed(length, TimeUnit.MINUTES)) {
                player.dialogueFactory.sendNpcChat(396, "You can only do this once every " + length + " minutes!", "Time Passed: " + Utility.getTime(player.BankerPetDelay.elapsedTime())).execute();
                return true;
            }
            Pets.onSpawn(player, 83, true);
            player.message("You have been granted a personalised Banker NPC For the next 30 Minutes!"); 	
             
        	
        }
    
        	
        
        if(button == -15103) {
        /*	
        	 if (!player.restoreDelay.elapsed(15, TimeUnit.MINUTES) && !player.getCombat().inCombat()) {
                 player.dialogueFactory.sendNpcChat(1152, "You can only do this once every " + 2 + " minutes!", "Time Passed: " + Utility.getTime(player.restoreDelay.elapsedTime())).execute();
                 return false;
             }

            player.runEnergy = 100;
            player.send(new SendRunEnergy());
            player.skills.restoreAll();
            CombatSpecial.restore(player, 100);
            player.dialogueFactory.sendNpcChat(1152, "Your health & special attack have been restored!").execute();
            player.restoreDelay.reset();
        	  
              
              
       */       
            }
       

        
        
        
        return false;
    }
}