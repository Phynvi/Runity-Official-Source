package plugin.click.item;

import java.util.concurrent.TimeUnit;

import io.battlerune.content.DiceBag;
import io.battlerune.content.activity.impl.allvsone3.AllVsOneV3;
import io.battlerune.content.activity.impl.flowerpoker.FlowerHandler;
import io.battlerune.content.activity.impl.zulrah.ZulrahActivity;
import io.battlerune.content.combat.cannon.Cannon;
import io.battlerune.content.combat.cannon.CannonManager;
import io.battlerune.content.consume.Anglerfish;
import io.battlerune.content.mysterybox.impl.SilverMysteryBox;
import io.battlerune.content.scratchcard.ScratchCard;
import io.battlerune.content.skill.impl.slayer.Slayer;
import io.battlerune.content.skill.impl.slayer.SlayerTask;
import io.battlerune.content.skill.impl.woodcutting.BirdsNest;
import io.battlerune.game.action.impl.SpadeAction;
import io.battlerune.game.event.impl.ItemClickEvent;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.prayer.Prayer;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendFadeScreen;
import io.battlerune.net.packet.out.SendInputAmount;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendString;
import io.battlerune.util.Utility;

public class ItemFirstClickPlugin extends PluginContext { // etest

	
	@Override
	protected boolean firstClickItem(Player player, ItemClickEvent event) {
		switch (event.getItem().getId()) {
		case 6:
			CannonManager.drop(player, new Cannon(player.getName(), player.getPosition()));
			break;
		case 22092:
			if(player.inventory.getFreeSlots() <= 5) {
				player.message("You need more inventory space!");
				return false;
			}
			player.inventory.add(7775, 125000);
			player.message("@red@You've recieved 125,000 Tickets Extra for using the dragon key!");
			player.message("@red@ You've been lucky and recieved a AvO 3 box!");
			player.inventory.addOrDrop(new Item(6833, 1));
		    player.inventory.remove(22092, 1);
			break;
		case 21813:
			player.pkPoints += 25;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.add(995, 50000000);
			player.inventory.remove(21813, 1);
			break;
		case 7775:
			player.message("To use these points, speak to Davey the thot");
			break;
		case 21810:
			player.pkPoints += 20;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.add(995, 35000000);
			player.inventory.remove(21810, 1);
			break;
		case 21807:
			player.pkPoints += 15;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.add(995, 25000000);
			player.inventory.remove(21807, 1);
			break;
			
		case 620:
			player.inventory.remove(620, 1);
			player.setRight(PlayerRight.DONATOR);
			player.donation.setCredits(100);
			player.donation.setSpent(10);
            player.message("@red@ Relog for your affects to take place & rank to update!");
			break;
			
		case 455:
			new ScratchCard(player).display();
			break;
		case 12746:
			player.pkPoints += 3;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12746, 1);
			break;
		case 10028:
			if (player.inventory.getFreeSlots() <= 3) {
				player.message("You do not have enough inventory space to open this box!");
				return false;
			}
			player.inventory.remove(10028, 1);

			if (Utility.random(1, 5) <= 4) {
				player.inventory.add(995, 5000000);
				player.inventory.add(17163, 1);
				player.inventory.add(17164, 1);
				player.inventory.add(17165, 1);
				player.message("@gre@You were lucky and received 5 Million GP! & Raptor Set!");
				return false;
			}
			if (Utility.random(1, 10) <= 2) {
				player.inventory.add(995, 15000000);
				player.inventory.add(3273, 1);
				player.message("@blu@You were lucky and received 15 Million GP! & Ice Katana!");
				return false;
			}
			if (Utility.random(1, 500) <= 2) {
				player.inventory.add(995, 20000000);
				player.inventory.add(17160, 1);
				player.inventory.add(15300, 1);
				player.inventory.add(13686, 1);
				player.inventory.add(15308, 1);
				player.inventory.add(15301, 1);
				player.message("@red@You were EXTREMELY lucky and received 20 Million GP!");
				return false;
			}
			player.message("you were unfortunate and did not recieve anything.");
			break;
			
			
		case 12789:
			if (player.inventory.getFreeSlots() <= 3) {
				player.message("You do not have enough inventory space to open this box!");
				return false;
			}
			player.inventory.remove(12789, 1);

			if (Utility.random(1, 5) <= 4) {
				player.inventory.add(995, 5000000);
				player.inventory.add(17163, 1);
				player.inventory.add(17164, 1);
				player.inventory.add(17165, 1);
				player.message("@gre@You were lucky and received 5 Million GP! & Raptor Set!");
				return false;
			}
			if (Utility.random(1, 10) <= 2) {
				player.inventory.add(995, 15000000);
				player.inventory.add(3273, 1);
				player.message("@blu@You were lucky and received 15 Million GP! & Ice Katana!");
				return false;
			}
			if (Utility.random(1, 500) <= 2) {
				player.inventory.add(995, 20000000);
				player.inventory.add(17160, 1);
				player.inventory.add(15300, 1);
				player.inventory.add(13686, 1);
				player.inventory.add(15308, 1);
				player.inventory.add(15301, 1);
				player.message("@red@You were EXTREMELY lucky and received 20 Million GP!");
				return false;
			}
			player.message("you were unfortunate and did not recieve anything.");
			break;

		case 299:

			if (!player.flowerDelay.elapsed(2, TimeUnit.SECONDS)) {
				player.dialogueFactory.sendStatement("You can only do this once every 2 Seconds!",
						"Time Passed: " + Utility.getTime(player.flowerDelay.elapsedTime())).execute();
				return true;
			}
			    player.flowerDelay.reset();
				player.inventory.remove(299, 1);
				new FlowerHandler(player).plantFlower(false);
			break;

		case 5020:
			if (player.inventory.contains(995, 1147000000)) {
				player.message("You can't claim this ticket, make some room!");
				return false;
			}

			player.inventory.add(995, 1000000000);
			player.message("You have just claimed 1 1Bil Ticket!");
			player.inventory.remove(5020, 1);

			break;
		case 5021:
			if (player.inventory.contains(995, 1647000000)) {
				player.message("You can't claim this ticket, make some room!");
				return false;
			}
			player.inventory.add(995, 500000000);
			player.message("You have just claimed 1 500M Ticket!");
			player.inventory.remove(5021, 1);

			break;
		case 12748:
			player.pkPoints += 5;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12748, 1);
			break;
		case 4079:
			player.animate(1460);
			break;
		case 12955:
			SilverMysteryBox box = new SilverMysteryBox();
			box.execute(player);
			break;
		case 12749:
			player.pkPoints += 7;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12749, 1);
			break;
		case 12750:
			player.pkPoints += 9;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12750, 1);
			break;
		case 12751:
			player.pkPoints += 11;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12751, 1);
			break;
		case 12752:
			player.pkPoints += 15;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12752, 1);
			break;
		case 12753:
			player.pkPoints += 18;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12753, 1);
			break;
		case 12754:
			player.pkPoints += 21;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12754, 1);
			break;
		case 12755:
			player.pkPoints += 23;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12755, 1);
			break;
		case 12756:
			player.pkPoints += 25;
			player.message("<img=2>You now have @red@" + player.getpkPoints() + " PVP Points!");
			player.inventory.remove(12756, 1);
			break;

		case 13441:
			Anglerfish.onAnglerEffect(player, event.getSlot());
			break;

		case 12791:
			player.runePouch.open();
			break;
		case 4155: {
			Slayer slayer = player.slayer;
			SlayerTask task = slayer.getTask();
			player.send(new SendMessage(
					task == null ? "You currently don't have a task, visit Nieve in edgeville to be assigned one."
							: String.format(
									player.slayer.partner == null ? "You're assigned to kill %s; only %d more to go."
											: "You and " + player.slayer.partner.getName()
													+ " are assigned to kill %s; only %d more to go.",
									task.getName(), slayer.getAmount())));
		}
			break;

		case 995:
			player.send(new SendInputAmount("Enter the amount of coins you want to deposit:", 10, input -> player.bankVault.deposit(Integer.parseInt(input))));
			break;

		case 405: {
			int coins = Utility.random(50000, 75000);
			player.inventory.remove(405, 1);
			player.inventory.add(995, coins);
			player.message("You found " + Utility.formatDigits(coins) + " coins inside of the casket!");
			break;
		}
		case 12938:
			if (player.isTeleblocked()) {
				player.message("You are currently under the affects of a teleblock spell and can not teleport!");
				break;
			}

			player.locking.lock();
			player.send(new SendFadeScreen("You are teleporting to Zulrah's shrine...", 1, 3));
			World.schedule(5, () -> {
				player.move(new Position(2268, 3069, 0));
				ZulrahActivity.create(player);
				player.locking.unlock();
			});
			player.inventory.remove(12938);
			break;

		case 10834:

			int coins = 100000000;

			if (player.inventory.contains(995, 2100000000)) {
				player.message("you have max cash in your inventory, please bank your cash before claiming more.");
			} else {
				player.inventory.remove(10834, 1);
				player.inventory.add(995, coins);
				player.message("You have claimed the @gre@100 Mill " + "Coin Bag");
				player.animate(2109);
				player.graphic(1177);
			}
			break;

		case 10835:
			int coins1 = 500000000;
			if (player.inventory.contains(995, 1500000000)) {
				player.message("you have max cash in your inventory, please bank your cash before claiming more.");
			} else {
				player.inventory.remove(10835, 1);
				player.inventory.add(995, coins1);
				player.message("You have claimed the @gre@500 Mill " + "Coin Bag");
				player.animate(2109);
				player.graphic(1177);
			}
			break;

		/*
		 * case 11865: { player.inventory.remove(11865, 1); player.inventory.add(11864,
		 * 1); player.message("You have disassembled the slayer helmet."); break; } case
		 * 19639: { player.inventory.remove(19639, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 19641: { player.inventory.remove(19641, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 19643: { player.inventory.remove(19643, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 19645: { player.inventory.remove(19645, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 19647: { player.inventory.remove(19647, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 19649: { player.inventory.remove(19649, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 21264: { player.inventory.remove(21264, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; } case
		 * 21266: { player.inventory.remove(19639, 1); player.inventory.add(11864, 1);
		 * player.message("You have disassembled the slayer helmet."); break; }
		 */
		case 21034:
			if (player.unlockedPrayers.contains(Prayer.RIGOUR)) {
				player.dialogueFactory.sendStatement("You already have this prayer unlocked!").execute();
				return true;
			}

			player.inventory.remove(event.getItem());
			player.unlockedPrayers.add(Prayer.RIGOUR);
			player.dialogueFactory.sendStatement("You have learned the Rigour prayer!").execute();
			break;

		case 21079:
			if (player.unlockedPrayers.contains(Prayer.AUGURY)) {
				player.dialogueFactory.sendStatement("You already have this prayer unlocked!").execute();
				return true;
			}

			player.inventory.remove(event.getItem());
			player.unlockedPrayers.add(Prayer.AUGURY);
			player.dialogueFactory.sendStatement("You have learned the Augury prayer!").execute();
			break;

		case 2528:
			player.send(new SendString("Genie's Experience Lamp", 2810));
			player.send(new SendString("", 2831));
			player.interfaceManager.open(2808);
			break;

		/* Spade */
		case 952:
			player.action.execute(new SpadeAction(player), true);
			break;

		/* Dice bag */
		case 15098:
			DiceBag.roll(player, false);
			break;

		/* Looting bag. */
		case 11941:
			player.lootingBag.open();
			break;

		/* Birds nest. */
		case 5070:
		case 5071:
		case 5072:
		case 5073:
		case 5074:
			BirdsNest.search(player, event.getItem().getId());
			break;

		default:
			return false;

		}
		return true;
	}

}
