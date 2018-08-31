package io.battlerune.content.presets;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendInputMessage;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendString;

public class PresetManager {

	private Player player;
	private Preset preset;

	public PresetManager(Player player, Preset preset) {
		this.player = player;
		this.preset = preset;
	}

	public void save(int slot) {
		if (player.getPresets()[slot] == null) {
			player.getPresets()[slot] = preset;
		} else {
			player.send(new SendMessage("Please delete this preset before saving another preset!"));
		}
		refreshInterface();
	}

	public void delete(int slot) {
		if (player.getPresets()[slot] != null) {
			player.dialogueFactory.sendOption("Delete " + player.getPresets()[slot].getName() + " Preset", () -> {
				player.getPresets()[slot] = null;
			}, "Cancel", () -> {
				player.dialogueFactory.clear();
			}).execute();
		}

		refreshInterface();
	}

	private void refreshInterface() {
		player.interfaceManager.open(45200);

		for (int i = 0; i < player.getPresets().length; i++) {
			if (player.getPresets()[i] != null) {
				player.send(new SendString(player.getPresets()[i].getName(), 42582 + i));
			} else if (player.getPresets()[i] == null) {
				player.send(new SendString(player.getPresets()[i].getName(), 42582 + i));
			}
		}
	}
}
