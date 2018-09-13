package io.battlerune.net.packet.in;

import io.battlerune.content.command.Command;
import io.battlerune.content.command.CommandManager;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.punishments.PunishmentExecuter;
import io.battlerune.net.packet.ClientPackets;
import io.battlerune.net.packet.GamePacket;
import io.battlerune.net.packet.PacketListener;
import io.battlerune.net.packet.PacketListenerMeta;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;

/**
 * The {@code GamePacket} responsible for handling user commands send from the
 * client.
 *
 * @author Michael | Chex
 */
@PacketListenerMeta(ClientPackets.PLAYER_COMMAND)
public final class CommandPacketListener implements PacketListener {

	@Override
	public void handlePacket(Player player, GamePacket packet) {
		String input = packet.getRS2String();
		String[] parts = input.split(" ");
		parts[0] = parts[0].toLowerCase();
		
		if (player.isTeleporting() || player.isDead())
			return;

		if (input.startsWith("/")) {

			if (PunishmentExecuter.muted(player.getUsername()) || PunishmentExecuter.IPMuted(player.lastHost)) {
				player.send(new SendMessage("You are muted and cannot chat."));
				return;
			}

			player.forClan(channel -> {
				final String line = input.replaceAll("/", "");
				channel.chat(player.getName(), Utility.capitalizeSentence(line));

			});
			return;
		}
		Command plugin = CommandManager.PLUGIN_INPUT.get(parts[0]);
		if (plugin != null) {
			if (plugin.canUse(player)) {
				plugin.execute(player, input, parts);
			} else {
				player.send(new SendMessage("You are not allowed to use this command!"));
			}
		}
	}

}
