package io.battlerune.game.world.entity.mob.player.persist;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.codec.login.LoginResponse;
import io.battlerune.util.Utility;

public final class PlayerSerializer {

	private static final PlayerPersistable perstable = /* Config.FORUM_INTEGRATION ? new PlayerPersistDB() : */new PlayerPersistFile();

	public static void save(Player player) {
		if (player.isBot) {
			return;
		}
		// player save thread
		new Thread(() -> perstable.save(player)).start();
	}

	public static LoginResponse load(Player player, String expectedPassword) {
		if (player.isBot) {
			return LoginResponse.COULD_NOT_COMPLETE_LOGIN;
		}

		return perstable.load(player, expectedPassword);
	}
	
	public static boolean saveExists(String name) {
		return Files.exists(Paths.get("./data/profile/save/"+Utility.formatUsername(name)+".json"));
	}
}
