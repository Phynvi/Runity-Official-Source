package plugin.click.button;


import io.battlerune.content.activity.impl.VorkathActivity;
import io.battlerune.content.activity.impl.cerberus.CerberusActivity;
import io.battlerune.content.activity.impl.kraken.KrakenActivity;
import io.battlerune.content.activity.impl.zulrah.ZulrahActivity;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.skill.Skill;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendFadeScreen;
import io.battlerune.net.packet.out.SendMessage;

public class BossInformationButtonPlugin extends PluginContext {

    /**
     * @author Adam/adameternal123
     */

    protected boolean onClick(Player player, int button) {
        if(button == -14335){
            Teleportation.teleport(player, new Position(2997, 3849, 0));
            player.send(new SendMessage("You have teleported to King Black Dragon!"));
        }
        if(button == -14320){
            Teleportation.teleport(player, new Position(1761, 5186, 0));
            player.send(new SendMessage("You have teleported to Giant Mole!"));
        }
        if(button == -14305){
            Teleportation.teleport(player, new Position(3195, 3865, 0));
            player.send(new SendMessage("You have teleported to Lava Dragon!"));
        }
        if(button == -14290){
            Teleportation.teleport(player, new Position(1912, 4367, 0));
            player.send(new SendMessage("You have teleported to Dagganoth Lair!"));
        }
        if(button == -14275){
            Teleportation.teleport(player, new Position(2967, 4383, 2));
            player.send(new SendMessage("You have teleported to Corperal Beast!"));
        }
        if(button == -14260){
            Teleportation.teleport(player, new Position(1454, 3690, 0));
            player.send(new SendMessage("You have teleported to Lizard Shamen!"));
        }
        if(button == -14245){
            Teleportation.teleport(player, new Position(3217, 3781, 0));
            player.send(new SendMessage("You have teleported to Vet'ion!"));
        }
        if(button == -14230){
            Teleportation.teleport(player, new Position(2982, 3832, 0));
            player.send(new SendMessage("You have teleported to Chaos Fanatic"));
        }
        if(button == -14215) {
            Teleportation.teleport(player, new Position(2966, 3698, 0));
            player.send(new SendMessage("You have teleported to Crazy Archaeologist"));
        }
        if(button == -14200){
            Teleportation.teleport(player, new Position(2280, 10031, 0), 20, () -> KrakenActivity.create(player));
            player.send(new SendMessage("You have teleported to Kraken!"));
        }
        if(button == -14185){
            if (player.isTeleblocked()) {
                player.message("You are currently under the affects of a teleblock spell and can not teleport!");
                return false;
            }

            player.locking.lock();
            player.send(new SendFadeScreen("You are teleporting to Zulrah's shrine...", 1, 3));
            World.schedule(5, () -> {
                player.move(new Position(2268, 3069, 0));
                ZulrahActivity.create(player);
                player.locking.unlock();
            });
        }
        if(button == -14170){
            DialogueFactory factory = player.dialogueFactory;

            factory.sendOption("General Graardor", () -> {
                Teleportation.teleport(player, new Position(2860, 5355, 2));
                player.send(new SendMessage("You have teleported to the General Graardor boss."));
            }, "Commander Zilyana", () -> {
                Teleportation.teleport(player, new Position(2911, 5265, 0));
                player.send(new SendMessage("You have teleported to the Commander Zilyana boss."));
            }, "K'ril Tsutsaroth", () -> {
                Teleportation.teleport(player, new Position(2925, 5337, 2));
                player.send(new SendMessage("You have teleported to the K'ril Tsutsaroth boss."));
            }, "Kree'arra", () -> {
                Teleportation.teleport(player, new Position(2839, 5292, 2));
                player.send(new SendMessage("You have teleported to the Kree'arra boss."));
            }, "Nevermind", factory::clear).execute();
        }
        if(button == -14155){
            Teleportation.teleport(player, new Position(3307, 3916, 0));
            player.send(new SendMessage("You have teleported to Chaos Elemental!"));
        }
        if(button == -14140){
    		if(player.skills.getLevel(Skill.SLAYER) <= 55) {
            Teleportation.teleport(player, new Position(3307, 3916, 0));
            player.send(new SendMessage("You have teleported to Giant Roc!"));
    		} else {
    			player.message("You need a Slayer Level of 55 And above to teleport to this boss!");
    		}
        }
        if(button == -14110) {
            Teleportation.teleport(player, new Position(3233, 3944, 0));
            player.send(new SendMessage("You have teleported to Scopria!"));
        }
        if(button == -14125) {
            Teleportation.teleport(player, new Position(3274, 3847, 0));
            player.send(new SendMessage("You have teleported to Callisto!"));
        }
        if(button == -14095){
    		if(player.skills.getLevel(Skill.SLAYER) <= 75) {
            Teleportation.teleport(player, new Position(1240, 1226, 0), 20, () -> CerberusActivity.create(player));
            player.send(new SendMessage("You have teleported to Cerberus!"));
        	} else {
    			player.message("You need a Slayer Level of 75 And above to teleport to this boss!");
        	}
        }
        if(button == -14215 ) {
        	 Teleportation.teleport(player, new Position(2966, 3698, 0));
             player.send(new SendMessage("You have teleported to Crazy Arch!"));
        }
        
        if(button == -14080){
    		if(player.skills.getLevel(Skill.SLAYER) <= 99) {
            Teleportation.teleport(player, new Position(2272, 4051, 0), 20, () -> VorkathActivity.create(player));
            player.send(new SendMessage("You have teleported to Vorkath Instance!"));
        	} else {
    			player.message("You need a Slayer Level of 99 to teleport to this boss!");
        	}
        }
        





        return false;
    }
}