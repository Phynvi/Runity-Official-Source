package io.battlerune.content.tools;

import io.battlerune.content.tools.impl.characters.CharactersLoading;

public class ControlPanelHandler {

	public static void main(String[] args) {
		CharactersLoading.load();
		ControlPanel.main(args);
	}
}
