package io.battlerune.content.combat;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;

public class Killstreak {

	private Player killer;
	private Player player;

	public Killstreak(Player killer, Player player) {
		this.killer = killer;
		this.player = player;
	}

	public void increase() {
		player.killCount++;
		player.killStreak++;
		World.sendMessage(
				"<col=CF2192>[Killstreak] " + killer.getUsername() + " has killed " + player.getUsername() + "</col>");
		World.sendMessage("<col=CF2192>[Killstreak] " + killer.getUsername() + " is on a " + killer.getKillStreak()
				+ " kill streak!</col>");
	}
	
	public void end() {
		World.sendMessage("<col=CF2192>[Killstreak] " + killer.getUsername() + " "
				+ "ended " + player.getUsername() + " killstreak.");
		player.deathCount++;
		player.killStreak = 0;
	}
	
}
