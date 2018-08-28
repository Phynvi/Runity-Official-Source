package plugin.click.button;

import io.battlerune.Config;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.arena.ArenaUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.justicar.JusticarUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.skotizo.SkotizoUtility;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.parser.old.defs.NpcDefinition;

/**
 * Event boss button plugin handler
 * 
 * @author Nerik#8690
 *
 */

public class BossEventButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		switch (button) {

		case -19935:
			if (getRequirements(player)) {
				if (getNpc().getIndex() == -1) {
					player.send(new SendMessage("@red@ Woops something went wrong"));
					return false;
				}
				Teleportation.teleport(player, getNpc().getPosition());
				player.hideTeleportButton();
			}
			return true;

		}
		return false;
	}

	private boolean getRequirements(Player player) {
		if (player.equipment.containsAny(Config.NOT_ALLOWED) || player.inventory.containsAny(Config.NOT_ALLOWED)) {
			player.message("@red@You are not allowed to bring in custom items " + player.getName() + "!");
			return false;
		}
		if (player.playerAssistant.busy()) {
			player.message("@red@You are to busy to do that at the moment!");
			return false;
		}
		if (player.getCombat().inCombat()) {
			player.message("@red@You can't do this while in combat");
			return false;
		}
		return true;
	}

	private Npc getNpc() {
		if (ArenaUtility.activated) {
			return new Npc(5129, ArenaUtility.spawn.getPosition());
		} else if (GalvekUtility.activated) {
			return new Npc(8095, GalvekUtility.spawn.getPosition());
		} else if (SkotizoUtility.activated) {
			return new Npc(7286, SkotizoUtility.spawn.getPosition());
		} else if (JusticarUtility.activated) {
			return new Npc(7858, JusticarUtility.spawn.getPosition());
		}
		return new Npc(-1, new Position(1, 1, 1));
	}
}
