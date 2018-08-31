package io.battlerune.content.presets;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendInputMessage;

public class PresetDialogue {

	private Player player;
	private int button;
	
	public PresetDialogue(Player player, int button) {
		this.player = player;
		this.button = button;
	}

	public void execute() {
		player.dialogueFactory.sendOption("Load Preset", () -> {
			//
		}, "Save preset", () -> {
			player.dialogueFactory.sendStatement("You have succesfully saved your preset!")
			.onAction(() -> {
				player.send(new SendInputMessage("Enter the preset name:", 12, input -> {
					if(input != null) {
						new PresetManager(player, new Preset(input, player.equipment.getItems(),
								player.inventory.getItems())).save(getPreset());
						}
				}));
			}).execute();
		}, "Delete preset", () -> {
			new PresetManager(player, player.getPresets()[getPreset()]).delete(getPreset());
		}).execute();
	}

	private int getPreset() {
		for(int i = 0; i < BUTTON_IDS.length; i++) {
			if(button == BUTTON_IDS[i]) {
				return i;
			}
		}
		return 0;
	}
	
	final static int[] BUTTON_IDS = { -22984, -22983, -22982, -22981, -22980, -22979, -22978, -22977 };
}
