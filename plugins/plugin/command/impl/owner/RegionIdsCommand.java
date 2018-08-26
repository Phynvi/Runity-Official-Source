package plugin.command.impl.owner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.region.Region;
import io.battlerune.game.world.region.RegionManager;
import io.battlerune.net.packet.out.SendMessage;

public class RegionIdsCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		Region[] regions = RegionManager.getSurroundingRegions(player.getPosition().copy());

		for (int i = 0; i < regions.length; i++) {
			player.send(new SendMessage("ID: " + regions[i].getId()));
		}

		try (PrintWriter print = new PrintWriter("region.txt")) {

			for (int i = 0; i < regions.length; i++) {
				print.write("ID: " + regions[i].getId() + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
