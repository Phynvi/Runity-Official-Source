package io.battlerune.net.packet.out;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.packet.OutgoingPacket;

/**
 * The {@code OutgoingPacket} that opens the inventory with itemcontainer.
 * 
 * @author Daniel | Obey
 */
public class SendInventoryInterface extends OutgoingPacket {

	private final int open;
	private final int overlay;

	public SendInventoryInterface(int open, int overlay) {
		super(248, 4);
		this.open = open;
		this.overlay = overlay;
	}

	@Override
	public boolean encode(Player player) {
		builder.writeShort(open, ByteModification.ADD).writeShort(overlay);
		return true;
	}

}
