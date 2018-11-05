package plugin.command.impl.player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.persist.PlayerSerializer;
import io.battlerune.game.world.entity.mob.player.profile.ProfileRepository;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendString;
import io.battlerune.util.MessageColor;
import io.battlerune.util.Utility;

/**
 * 
 * @author Adam_#6723
 *
 */

public class CheckPlayers implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		final String name = String.format(parts[1].replaceAll("_", " "));
        handle(player, name);
		
	}
	
	public static List<String> accounts = new ArrayList<String>();

	public void handle(Player player, String name) {
		
		List<String> list = new ArrayList<String>(Short.MAX_VALUE);
		
		String path = "./data/profile/save/";
		
		File folder = new File(path);
		
		File[] listOfFiles = folder.listFiles();
		
		name = Utility.formatName(name);

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile())
				accounts.add(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 5));
		}
		
		System.out.println(accounts.get(0)+" "+name);
		
		Player saved = (Player) PlayerSerializer.loadPlayer(name);
		
		if (saved == null) {
			player.sendMessage("Error.. unable to check account for "+name);
			return;
		}
		
		for (int index = 0; index < accounts.size(); index++) {

			Player p = (Player) PlayerSerializer.loadPlayer(accounts.get(index));

			String configuredName = accounts.get(index);
			
			System.out.println(saved.getUsername()+" "+saved.registeredMac+" "+p.getUsername()+" "+p.registeredMac);
			
			if (saved.registeredMac.equalsIgnoreCase(p.registeredMac))
			    list.add(configuredName);
			
		}
		
		player.send(new SendMessage("There are " + list.size() + " accounts linked to " + Utility.formatName(saved.getName()) + ".", MessageColor.DARK_BLUE));
		
		if (!list.isEmpty()) {
			for (int index = 0; index < 50; index++) {
				String name1 = index >= list.size() ? "" : list.get(index);
				player.send(new SendString(name1, 37111 + index));
			}

			player.send(new SendString("Profiles:\\n" + list.size(), 37107));
			player.send(new SendString(saved.getUsername(), 37103));
			player.interfaceManager.open(37100);
		}
	}
	
	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
