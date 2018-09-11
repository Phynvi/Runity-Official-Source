package io.battlerune.net.packet.in;

import java.util.Map.Entry;

import io.battlerune.game.event.impl.log.ChatLogEvent;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.data.PacketType;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.punishments.PunishmentExecuter;
import io.battlerune.game.world.entity.mob.player.relations.ChatColor;
import io.battlerune.game.world.entity.mob.player.relations.ChatEffect;
import io.battlerune.game.world.entity.mob.player.relations.ChatMessage;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.packet.ClientPackets;
import io.battlerune.net.packet.GamePacket;
import io.battlerune.net.packet.PacketListener;
import io.battlerune.net.packet.PacketListenerMeta;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.ChatCodec;

/**
 * The {@code GamePacket} responsible for chat messages.
 * 
 * @author Daniel
 */
@PacketListenerMeta(ClientPackets.INTERFACE_ON_GROUNDITEM)
public class InterfaceOnGroundItemListener implements PacketListener {

	@Override
	public void handlePacket(Player player, GamePacket packet) {
		int yCoord = packet.readShort(ByteOrder.LE);
		int itemId = packet.readShort();
		int xCoord = packet.readShort(ByteOrder.LE);
		int unknown = packet.readShort(ByteModification.ADD);
		
		player.send(new SendMessage("Telegrab will be added soon!"));
		
		
	}
}