package io.battlerune.content.ffa;

import java.util.HashMap;
import java.util.Random;

import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerOption;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendPlayerOption;
import io.battlerune.net.packet.out.SendString;
import io.battlerune.net.packet.out.SendWalkableInterface;

/**
 * Handles the free for all Minigame
 * 
 * @author Harryl
 * @skype hamza_rdm
 */
public class FreeForAll {

	/**
	 * Handles game, lobby values
	 */
	public static HashMap<Player, String> game = new HashMap<Player, String>();

	public static int getPlayers(String type) {
		switch (type) {
		case "game":
			int gamePlayers = 0;
			for (Player players : game.keySet()) {
				if (game.get(players).equalsIgnoreCase("game")) {
					gamePlayers++;
				}
			}
			return gamePlayers;
		case "lobby":
			int lobbyPlayers = 0;
			for (Player players : game.keySet()) {
				if (game.get(players).equalsIgnoreCase("lobby")) {
					lobbyPlayers++;
				}
			}
			return lobbyPlayers;
		}
		return 0;
	}

	/**
	 * Handles the timers of game/lobby
	 */
	public static int WAIT_TIMER = 80; // 3MINUTES
	public static int GAME_TIMER = 900; // 5MINUTES
	public static int OVERALL_TIMER = 10800; // 3 HOURS

	private static String secondsToTimer(int secs) {
		int minutes = secs / 60;
		int seconds = secs % 60;
		if (seconds <= 9) {
			return +minutes + ":0" + seconds;
		}
		return minutes + ":" + seconds;
	}

	/**
	 * Handles the players needed to start the game
	 */
	private final static int PLAYERS_NEEDED = 2;

	/**
	 * Checks if game is started or not / lobby is open or not
	 */
	public static boolean gameStarted = false;
	public static boolean lobbyOpen = false;

	/**
	 * Returns a random type of setup with the needed data
	 * 
	 * @return
	 */
	private static FreeForAllGear getSetup() {
		Random random = new Random();
		FreeForAllGear[] setups = FreeForAllGear.values();
		return setups[random.nextInt(setups.length)];
	}

	/**
	 * Handles the timer/game checks
	 */
	public static void sequence() {
		if (!gameStarted && !lobbyOpen) {

			if (OVERALL_TIMER > 0) {
				OVERALL_TIMER--;

				if (OVERALL_TIMER == 3600) {
					World.sendMessage("[Tournament] The tournament will open it doors in 1 hour!");
				}
			}

			if (OVERALL_TIMER <= 0) {
				lobbyOpen = true;
				OVERALL_TIMER += 350;
				World.sendMessage("[Tournament] The tournament doors have been opened! ::tournament to join!");
			}
			return;
		}

		if (gameStarted && !lobbyOpen) {

			if (GAME_TIMER > 0) {
				GAME_TIMER--;

				if (GAME_TIMER == 120) {
					gameMessage("game", "@or2@[Tournament Game] The round will end shortly!");
				}

				updateInterface("game");
			}

			if (gameStarted && GAME_TIMER <= 0) {
				endGame();
			}
			return;
		}

		if (WAIT_TIMER > 0 && getPlayers("lobby") >= PLAYERS_NEEDED && lobbyOpen) {
			WAIT_TIMER--;

			if (WAIT_TIMER == 60) {
				World.sendMessage("@or2@[Tournament] The Tournament will start shortly, Join now ::tournament!");
			}

			updateInterface("lobby");
		}

		if (WAIT_TIMER <= 0) {
			lobbyOpen = false;
			gameStarted = true;
			WAIT_TIMER += 180;
			startGame();
		}
	}

	/**
	 * Handles the start of the game
	 */
	public static void startGame() {
		for (Player player : game.keySet()) {
			if (game.get(player).equalsIgnoreCase("lobby")) {
				gearUp(player, getSetup());
				game.put(player, "game");
				game.remove(player, "lobby");
			}
		}
	}

	/**
	 * 
	 */
	public static void endGame() {

	}

	/**
	 * 
	 * @param p
	 * @param gear
	 */
	private static void gearUp(Player p, FreeForAllGear gear) {

		for (int i = 0; i < gear.getInventory().length; i++) {
			p.inventory.add(gear.getInventory()[i]);
		}

		for (int i = 0; i < gear.getGear().length; i++) {
			p.equipment.add(new Item(gear.getGear()[i][1], gear.getGear()[i][2]), gear.getGear()[i][0]);
		}

	}

	/**
	 * Checks if player can join the lobby
	 * 
	 * @param player
	 * @return
	 */
	public static boolean lobbyCheck(Player player) {
		if (gameStarted || WAIT_TIMER <= 5) {
			player.message("@or2@[Tournament] Please wait for the next tournament to start!");
			return false;
		}

		/*
		 * for (int i = 0; i < 11; i++) { if (player.equipment.get(i).getId() > 0) {
		 * player.message("@or2@[Tournament] Please bank your equipment!"); return
		 * false; } }
		 */

		if (player.inventory.getFreeSlots() != 28) {
			player.message("@or2@[Tournament] Please bank your items!");
			return false;
		}
		return true;
	}

	/**
	 * Handles joining the lobby!
	 * 
	 * @param player
	 */
	public static void joinLobby(Player player) {
		if (player != null) {
			if (lobbyCheck(player)) {
				game.put(player, "lobby");
				player.move(new Position(3292, 4959, 0));
				player.message("@or2@[Tournament] The game will start shortly!");
				player.send(new SendPlayerOption(PlayerOption.ATTACK, false));
			}
		}
	}

	/**
	 * Handles the walkable interface of the game/lobby
	 * 
	 * @param type
	 */
	public static void updateInterface(String type) {
		switch (type) {
		case "lobby":
			for (Player player : game.keySet()) {
				if (game.get(player).equalsIgnoreCase("lobby")) {
					player.send(new SendWalkableInterface(22119));
					player.send(new SendString("Time until round starts", 22120));
					player.send(new SendString("" + secondsToTimer(WAIT_TIMER), 22121));
				}
			}
			break;
		case "game":
			for (Player player : game.keySet()) {
				if (game.get(player).equalsIgnoreCase("game")) {
					player.move(new Position(3366, 3936, 0));
					player.send(new SendWalkableInterface(22119));
					player.send(new SendString("Time until round ends", 22120));
					player.send(new SendString("" + secondsToTimer(GAME_TIMER), 22121));
				}
			}
			break;
		}
	}

	/**
	 * Removes the items of inventory/equipment
	 * 
	 * @param player
	 */
	public static void removeItems(Player player) {
		player.inventory.clear(true);
		player.equipment.clear(true);
	}

	/**
	 * Handles leaving the game/lobby/respawning when the players dies
	 * 
	 * @param player
	 * @param type
	 */
	public static void leaveGame(Player player, String type) {
		switch (type) {
		case "lobby":
			break;
		case "game":
			break;
		case "logout":
			break;
		case "dead":
			// player.playerAssistant.transform(85);
			player.message("@or2@[Tournament Game] You died, to leave the game leave the portal!");
			removeItems(player);
			break;
		}
	}

	/**
	 * Handles the game messages lobby/game
	 * 
	 * @param type
	 * @param message
	 */
	public static void gameMessage(String type, String message) {
		switch (type) {
		case "lobby":
			for (Player players : game.keySet()) {
				if (game.get(players).equalsIgnoreCase("lobby")) {
					players.message(message);
				}
			}
			break;
		case "game":
			for (Player players : game.keySet()) {
				if (game.get(players).equalsIgnoreCase("game")) {
					players.message(message);
				}
			}
			break;
		}
	}

}
