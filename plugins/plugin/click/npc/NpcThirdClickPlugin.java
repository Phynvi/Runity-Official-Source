package plugin.click.npc;

import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.content.dialogue.Expression;
import io.battlerune.content.dialogue.impl.RoyalKingDialogue;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.content.skill.impl.runecrafting.RunecraftTeleport;
import io.battlerune.content.skill.impl.slayer.SlayerOfferings;
import io.battlerune.content.upgrading.Upgrading;
import io.battlerune.game.event.impl.NpcClickEvent;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendURL;
import io.battlerune.util.Utility;

public class NpcThirdClickPlugin extends PluginContext {

	@Override
	protected boolean thirdClickNpc(Player player, NpcClickEvent event) {
		switch (event.getNpc().id) {
		case 5523:
			player.dialogueFactory.sendDialogue(new RoyalKingDialogue(1));
			break;
		case 490:
			SlayerOfferings.offer(player);
			break;
		case 311:
			player.playerAssistant.claimIronmanArmour();
			break;
		case 6797:
			player.dialogueFactory.sendOption("What Item's can I Upgrade?", () -> {
				player.send(new SendURL("https://www.runity.io/forums/upgradingURL"));
                player.message("Opening upgrading information thread.");
					}, "Upgrade an Item", () -> {
					     Upgrading.Upgrade(player);
		                 player.message("More upgrading option's will be added soon! this is just a test version.");						
						},"Nowhere", player.interfaceManager::close).execute();
			
			
			
			
			/*
			DialogueFactory factory = new DialogueFactory(player);
			factory.sendPlayerChat("Hey there...").sendNpcChat(6797, Expression.DRUNK_LEFT, "Oh #name, how are you doing?",
					"scrap the small talk, are you brave?", "Would you like to upgrade your katana for a Death Katana (u).",
					"You have to scarfice all the katana's in your inventory!", "WARNING ALL OF THEM WILL GO!").sendOption("Sure", () -> {
				if (player.inventory.contains(3273)) {
                 if(Utility.random(1, 5000) == 1) {
                	 player.inventory.add(11642, 1);
                	 player.message("You have been lucky and recieved a Death Katana!");
                 }
                 player.inventory.remove(3273);
				}
			}, "Upgrade Normal Whip?", () -> {
				if (player.wilderness > 30 && !PlayerRight.isPriviledged(player)) {
					player.message("@or2@you can't teleport above 30 wilderness");
				} else {
					Teleportation.teleport(player, RunecraftTeleport.EARTH.getPosition(), 20, () -> {
						player.send(new SendMessage("@or2@Welcome to the Nature altar, " + player.getName() + "!"));
					});

				}
			},"Nowhere", player.interfaceManager::close).execute();
			*/
			break;
		case 3220:
			player.dialogueFactory.sendOption("Mind Altar", () -> {
				if (player.wilderness > 30 && !PlayerRight.isPriviledged(player)) {
					player.message("@or2@you can't teleport above 30 wilderness");
				} else {
					Teleportation.teleport(player, RunecraftTeleport.MIND.getPosition(), 20, () -> {
						player.send(new SendMessage("@or2@Welcome to the Air Altar!, " + player.getName() + "!"));
					});
				}
			}, "Earth Altar", () -> {
				if (player.wilderness > 30 && !PlayerRight.isPriviledged(player)) {
					player.message("@or2@you can't teleport above 30 wilderness");
				} else {
					Teleportation.teleport(player, RunecraftTeleport.EARTH.getPosition(), 20, () -> {
						player.send(new SendMessage("@or2@Welcome to the Nature altar, " + player.getName() + "!"));
					});

				}
			}, "Cosmic Altar", () -> {
				if (player.wilderness > 30 && !PlayerRight.isPriviledged(player)) {
					player.message("@or2@you can't teleport above 30 wilderness");
				} else {
					Teleportation.teleport(player, RunecraftTeleport.COSMIC.getPosition(), 20, () -> {
						player.send(new SendMessage("@or2@Welcome to the Blood altar, " + player.getName() + "!"));
					});
				}
			}, "Body Altar", () -> {
				if (player.wilderness > 30 && !PlayerRight.isPriviledged(player)) {
					player.message("@or2@you can't teleport above 30 wilderness");
				} else {
					Teleportation.teleport(player, RunecraftTeleport.BODY.getPosition(), 20, () -> {
						player.send(new SendMessage("@or2@Welcome to the Law Altar, " + player.getName() + "!"));
					});
				}
			}, "Nowhere", player.interfaceManager::close).execute();
			break;
		}
		return false;
	}

}
