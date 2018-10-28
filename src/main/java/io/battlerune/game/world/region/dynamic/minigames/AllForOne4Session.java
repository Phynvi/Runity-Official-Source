package io.battlerune.game.world.region.dynamic.minigames;

import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.content.teleport.TeleportHandler;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.persist.PlayerSerializer;
import io.battlerune.game.world.object.GameObject;
import io.battlerune.game.world.region.dynamic.boss.DynamicRegionHandler;
import io.battlerune.net.packet.out.SendInputMessage;
import io.battlerune.util.Utility;

/**
 * 
 * @author Teek
 *
 */
public class AllForOne4Session extends DynamicRegionHandler {
	
	private long startTime, finishTime;
	
	private Player player;
	
	private Player partner;

	@Override
	public void onStart(Player player) {
		this.player = player;
		this.partner = player.allForOnePartner;
		startTime = System.currentTimeMillis();
		partner.move(player.getPosition());
		
	}

	@Override
	public boolean metRequirements(Player player) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void process(Player player) {
		
	}

	@Override
	public boolean handleObjectInteraction(int objectOption, GameObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNpcAttack(Npc npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onNPCDeath(Npc npc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayerDeath(Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean allowTeleportation(Player player) {
		player.getDynamicRegion().destroyInstance(false);
		return true;
	}

	@Override
	public void onExit(Player player) {
		finishTime = System.currentTimeMillis();
		sendPartnerMessage("Time Elapsed: "+Utility.convertMsToTime(finishTime - startTime));
	}
	
	private void sendPartnerMessage(String message) {
		if (message == null || partner == null)
			return;
		player.sendMessage(message);
		partner.sendMessage(message);
	}

	public static void sendPartnerRequest(Player player, Player other) {
		if (other == null) {
			player.sendMessage("Unable to send request.. other person is offline.");
			return;
		}
		player.sendMessage("Sending partner request to "+other.getUsername()+"...");
		player.lastPartnerRequest += System.currentTimeMillis() + 15000;
		DialogueFactory f = other.dialogueFactory;
		f.sendOption("Accept "+player.getUsername()+"'s All For One 4 partner request", () -> f.onAction(() -> {
			f.clear();
			player.setAllForOnePartner(player, other);
			player.sendPartnerMessage(player, other, "You have been partnered! make your way over to the All vs one v4 portal!");
			player.sendMessage(other.getUsername()+" has accepted your partner request.");
		}), "Decline Request", () -> f.onAction(() -> {
			f.clear();
			other.sendMessage("You have declined "+player.getUsername()+"'s partner request");
			player.sendMessage(other.getUsername()+" has declined your partner request.");
		})).execute();
	}


}
