package io.battlerune.content.logger;

import io.battlerune.game.world.entity.mob.player.Player;

public class LoggerExecuter {

	private String type;
	private Player player;
	private Player other;
	private String log;
	
	public LoggerExecuter(String type, Player player, Player other, String log) {
		this.type = type;
		this.player = player;
		this.other = other;
		this.log = log;
	}
	
	public void execute() {
		LoggerListener listener = LoggerEvent.LISTENER.get(type.toLowerCase());
		if(listener != null) {
			listener.execute(player, other, log);
		}
	}
}
