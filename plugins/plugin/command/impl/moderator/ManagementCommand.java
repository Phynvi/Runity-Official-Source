package plugin.command.impl.moderator;

import io.battlerune.content.command.Command;
import io.battlerune.content.staff.PanelType;
import io.battlerune.content.staff.StaffPanel;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

/**
 * 
 * @author Adam_#6723
 *
 */

public class ManagementCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		StaffPanel.open(player, PanelType.INFORMATION_PANEL);
       }

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
