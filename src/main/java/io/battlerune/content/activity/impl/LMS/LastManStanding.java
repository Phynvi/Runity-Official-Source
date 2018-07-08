package io.battlerune.content.activity.impl.LMS;

import java.util.HashMap;
import java.util.Map;

import io.battlerune.content.activity.ActivityType;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerOption;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendPlayerOption;



/**
 * 
 * @author Nerik#8690
 *
 */
public class LastManStanding {
	
	/**
	 * Checks players in game / in lobby
	 */
	public static int PLAYERS_IN_GAME = 0;
	public static int PLAYERS_IN_LOBBY = 0;

	/**
	 * @note Stores player and State
	 */
	public static Map<Player, String> LobbyMap = new HashMap<Player, String>();
	public static Map<Player, String> GameMap = new HashMap<Player, String>();

	/**
	 * Handles the Game / lobby Time
	 */
	public static int GameTimer = 1200;
	public static int LobbyTimer = 120;

	/**
	 * Checks if game is running
	 */
	public static boolean GameRunning = false;

	/**
	 * Handles the amount needed
	 */
	private static final int MaxAmount = 3000000;
	private static final int AmountRequired = 2;

	/**
	 * Handles the rewards for the winner
	 */
	private static Item[] Rewards = { new Item(995, 10000000), new Item(1464, 10) };

	/**
	 * Handles random spawning in area
	 */
	private static int Cords[][] = { { 1, 1, 1 } };

	/**
	 * Lobby Sequence
	 */
	public static void LobbyChecker() {
		if (GameRunning == true) {
			EndGameCheck();
			return;
		}

		if (LobbyTimer > 0 && PLAYERS_IN_LOBBY >= 1) {
			LobbyTimer--;
			if (LobbyTimer == 60)
				World.sendMessage("<img=10> <col=660099>[LMS] </col>@red@" + LobbyTimer
						+ " <col=660099>seconds until Lms starts, current lobby count:</col> @red@"
						+ PLAYERS_IN_LOBBY);
		}
		if (LobbyTimer <= 0 && PLAYERS_IN_LOBBY < AmountRequired) {
			for (Player p : World.getPlayers()) {
			
				
				
				/*if (p != null && p.getLocation() == Location.LMS_LOBBY) {
					p.message("@or2@[LMS] The game needs a total of 10 players or more to start");
					LobbyTimer += 120;
					return;
				}*/
			}
		}
		if (LobbyTimer <= 0 && PLAYERS_IN_LOBBY >= AmountRequired) {

			if (GameRunning == false)
				StartGamee();
			LobbyTimer += 120;
		}
	}

	
	

	/**
	 * 
	 * @param player
	 */
	public static void LeaveGame(Player player, String type) {
		switch (type) {

		case "game":
			PLAYERS_IN_GAME--;
			GameMap.remove(player, "PLAYING");
			player.move(Player.DEFAULT_POSITION.copy());
			player.message("@or2@Thanks for participating in the lms game!");
			player.send(new SendPlayerOption(PlayerOption.ATTACK, true));
		//	player.getUpdateFlag().flag(Flag.APPEARANCE);
			player.inventory.clear();
			player.equipment.clear();
			player.equipment.refresh();
			player.inventory.add(Rewards[0]);
			player.inventory.refresh();
			break;

		case "lobby":
			PLAYERS_IN_LOBBY--;
			LobbyMap.remove(player, "WAITING");
			player.setLmsCoffer(player.getLmsCoffer() + MaxAmount);
			player.move(Player.DEFAULT_POSITION.copy());
			player.send(new SendPlayerOption(PlayerOption.ATTACK, false));
		//	player.getUpdateFlag().flag(Flag.APPEARANCE);
			player.inventory.clear();
			player.equipment.clear();
			player.equipment.refresh();
			player.inventory.add(Rewards[0]);
			player.inventory.refresh();
			break;

		case "winner":
			PLAYERS_IN_GAME = 0;
			PLAYERS_IN_LOBBY = 0;
			LobbyMap.clear();
			GameMap.clear();
			player.move(Player.DEFAULT_POSITION.copy());
//			World.sendMessage("<img=10> <col=660099>[LMS]</col>@red@ " + Misc.formatPlayerName(player.getUsername())
//					+ " <col=660099>has just won the lms game!</col>");
			GameRunning = false;
			player.send(new SendPlayerOption(PlayerOption.ATTACK, false));
	//		player.getUpdateFlag().flag(Flag.APPEARANCE);
			player.inventory.clear();
			player.equipment.clear();
			player.equipment.refresh();
			player.inventory.add(Rewards[0]);
			player.inventory.refresh();
		

			break;
		}
	}
	/**
	 * Checks if the game needs to be ended.
	 */
	public static void EndGameCheck() {
		for (Player p : GameMap.keySet()) {
			if (GameMap.size() == 1) {
				LeaveGame(p, "winner");
			}
		}
	}

	/**
	 * Lobby Sequence
	 */
	public static void GameSquencer() {
		if (GameRunning == false) {
			return;
		}
		if (GameRunning == true && GameTimer > 0) {
			GameTimer--;
		}
		if (GameRunning == true && GameTimer <= 0) {
			for (Player p : World.getPlayers()) {
				/*if (p != null && p.getLocation() == Location.LMS_GAME) {
					LeaveGame(p, "game");
					GameTimer = 1200;
				}*/
			}
		}
	}


	/**
	 * Handles the game (spawning, countdown etc..)
	 */
	public static void StartGamee() {
		for (Player p : World.getPlayers()) {
			/*if (p != null && p.getLocation() == Location.LMS_LOBBY) {
				PLAYERS_IN_LOBBY--;
				LobbyMap.remove(p, "WAITING");
				p.move(new Position(2755, 2784, 0));
				PLAYERS_IN_GAME++;
				GameMap.put(p, "PLAYING");
				GameRunning = true;
				//p.getPacketSender().sendInteractionOption("Attack", 2, true);
				LmsObjectHandler.spawnCrates();
				//updateInterface("game");
			}*/
		}
	}
	public static void GameMessages(Player killer, Player killed) {
		for (Player p : World.getPlayers()) {
			/*if (p != null && p.getLocation() == Location.LMS_GAME) {
				if(GameMap.size() < 2) {
					return;
				}
		
				p.sendMessage("<img=10> @or2@[LMS]</col>@red@ " + Misc.formatPlayerName(killed.getUsername())
					+ " <col=660099>has just been killed by " + Misc.formatPlayerName(killer.getUsername()) + "!");
			  }*/
		}
	}



	/**
	 * Double checks if player wants to join lobby!
	 * 
	 * @param player
	 */
	public static void LobbyDialouge(Player player) {
		if (lobbyCheck(player)) {
		// 	DialogueManager.start(player, 152);
		   // player.setDialogueActionId(153);
		}
	}

	/**
	 * Checks if player can join lobby.
	 * 
	 * @param player
	 */
	public static boolean lobbyCheck(Player player) {

		if (player.getLmsCoffer() < MaxAmount) {
			player.message("@or2@[LMS] You need atleast 3m in your lms coffer to join the lobby!");
			return false;
		}
		if (player.inventory.getFreeSlots() != 28) {
			player.message("@or2@[LMS] Please make sure to bank your inventory");
			return false;
		}
		for (int i = 0; i < 14; i++) {
			
			if (player.equipment.get(i).getId() > 0) {
				player.message("@or2@[LMS] Please make sure to bank your equipment");
				return false;
			}
		}
		return true;
	}

	/**
	 * Updates the lobby / game Interface
	 */

	
	
//	 @Override
	    public ActivityType getType() {
	        return ActivityType.LMS;
	    }
}
