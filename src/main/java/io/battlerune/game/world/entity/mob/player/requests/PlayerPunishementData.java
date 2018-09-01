package io.battlerune.game.world.entity.mob.player.requests;

public enum PlayerPunishementData {

	BAN("./data/content/punishements/Banned.txt"), MUTE("./data/content/punishements/Banned.txt"),
	JAIL("./data/content/punishements/Banned.txt"),;

	private String path;

	PlayerPunishementData(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
