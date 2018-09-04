package io.battlerune.game.world.entity.mob.player.requests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import io.battlerune.game.task.Task;
import io.battlerune.game.world.World;
import io.battlerune.util.Utility;

/**
 * Handles the player punishment
 * 
 * @author Nerik#8690
 */
public class PlayerPunishment {

	private static final String DIRECTORY = "./data/content/punishements/";

	public static ArrayList<String> IPSBanned = new ArrayList<String>();
	public static ArrayList<String> IPSMuted = new ArrayList<String>();
	public static ArrayList<String> AccountsBanned = new ArrayList<String>();
	public static ArrayList<String> AccountsMuted = new ArrayList<String>();

	public static void init() {
		
		IPSBanned.clear();
		IPSMuted.clear();
		AccountsBanned.clear();
		AccountsMuted.clear();

		initializeList(DIRECTORY, "IPBans", IPSBanned);
		initializeList(DIRECTORY, "Bans", AccountsBanned);
		initializeList(DIRECTORY, "IPMutes", IPSMuted);
		initializeList(DIRECTORY, "Mutes", AccountsMuted);
		
		System.out.println("Player Punishements Initialized!");
	}

	public static void initializeList(String directory, String file, ArrayList<String> list) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("" + directory + "" + file + ".txt"));
			String data = null;
			while ((data = in.readLine()) != null) {
				list.add(data);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addBannedIP(String IP) {
		if (!IPSBanned.contains(IP))
			addToFile("" + DIRECTORY + "IPBans.txt", IP);
		IPSBanned.add(IP);

	}

	public static void addMutedIP(String IP) {
		if (!IPSMuted.contains(IP))
			addToFile("" + DIRECTORY + "IPMutes.txt", IP);
		IPSMuted.add(IP);

	}

	public static void ban(String p) {
		p = Utility.formatName(p.toLowerCase());
		if (!AccountsBanned.contains(p))
			addToFile("" + DIRECTORY + "Bans.txt", p);
		AccountsBanned.add(p);

	}

	public static void mute(String p) {
		p = Utility.formatName(p.toLowerCase());
		if (!AccountsMuted.contains(p))
			addToFile("" + DIRECTORY + "Mutes.txt", p);
		AccountsMuted.add(p);

	}

	public static boolean banned(String player) {
		player = Utility.formatName(player.toLowerCase());
		return AccountsBanned.contains(player);

	}

	public static boolean muted(String player) {
		player = Utility.formatName(player.toLowerCase());
		return AccountsMuted.contains(player);

	}

	public static boolean IPBanned(String IP) {
		return IPSBanned.contains(IP);
	}

	public static boolean IPMuted(String IP) {
		return IPSMuted.contains(IP);
	}

	public static void unban(String player) {
		player = Utility.formatName(player.toLowerCase());
		deleteFromFile("" + DIRECTORY + "Bans.txt", player);
		AccountsBanned.remove(player);

	}

	public static void unmute(String player) {
		player = Utility.formatName(player.toLowerCase());
		deleteFromFile("" + DIRECTORY + "Mutes.txt", player);
		AccountsMuted.remove(player);

	}

	public static void reloadIPBans() {
		IPSBanned.clear();
		initializeList(DIRECTORY, "IPBans", IPSBanned);
	}

	public static void reloadIPMutes() {
		IPSMuted.clear();
		initializeList(DIRECTORY, "IPMutes", IPSMuted);
	}

	public static void deleteFromFile(String file, String name) {
		World.schedule(new Task(1) {
			@Override
			protected void execute() {
				try {
					BufferedReader r = new BufferedReader(new FileReader(file));
					ArrayList<String> contents = new ArrayList<String>();
					while (true) {
						String line = r.readLine();
						if (line == null) {
							break;
						} else {
							line = line.trim();
						}
						if (!line.equalsIgnoreCase(name)) {
							contents.add(line);
						}
					}
					r.close();
					BufferedWriter w = new BufferedWriter(new FileWriter(file));
					for (String line : contents) {
						w.write(line, 0, line.length());
						w.newLine();
					}
					w.flush();
					w.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public static void addToFile(String file, String data) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			try {
				out.write(data);
				out.newLine();
			} finally {
				out.close();
				PlayerPunishment.init();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
