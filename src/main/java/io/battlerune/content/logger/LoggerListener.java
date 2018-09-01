package io.battlerune.content.logger;

import io.battlerune.game.world.entity.mob.player.Player;

public interface LoggerListener {

	String getPath();
	
	void execute(Player player, Player other, String log);
}
