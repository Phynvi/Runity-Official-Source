package plugin.click.object;

import io.battlerune.Config;
import io.battlerune.content.skill.impl.magic.Spellbook;
import io.battlerune.game.Animation;
import io.battlerune.game.event.impl.ObjectClickEvent;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.combat.magic.Autocast;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.region.dynamic.minigames.AllForOne4Session;
import io.battlerune.net.packet.out.SendMessage;

public class ObjectThirdClickPlugin extends PluginContext {

	@Override
	protected boolean thirdClickObject(Player player, ObjectClickEvent event) {
		final int id = event.getObject().getId();

		switch (id) {
		case 409:
			Autocast.reset(player);
			player.animate(new Animation(645));
			player.spellbook = Spellbook.LUNAR;
			player.interfaceManager.setSidebar(Config.MAGIC_TAB, player.spellbook.getInterfaceId());
			player.send(
					new SendMessage("You are now using the " + player.spellbook.name().toLowerCase() + " spellbook."));
			break;
			
		case 13617:
			AllForOne4Session session = new AllForOne4Session();
            session.resetPartner();
			player.message("You have reset your double threat partner!");
			break;

		}

		return false;
	}

}
