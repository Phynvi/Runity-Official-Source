package io.battlerune.content.freeforall.impl;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public class FreeForAllStartTask implements FreeForAllTask {

	
	@Override
	public void execute(Player player) {
		player.send(new SendMessage("Yo works nerik!!!!!!"));
	}

}
