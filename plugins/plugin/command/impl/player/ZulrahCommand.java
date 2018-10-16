package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.game.world.region.dynamic.DynamicRegion;
import io.battlerune.game.world.region.dynamic.DynamicRegion.RegionType;


public class ZulrahCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		player.sendMessage("testing.. - Index="+player.getIndex()+" RegionIndex="+(4 * player.getIndex())+"");
		player.setDynamicRegion(new DynamicRegion(player, RegionType.ZULRAH));
	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
