package plugin.click.button;

import io.battlerune.Config;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.arena.ArenaUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.galvek.GalvekUtility.SpawnData1;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.justicar.JusticarUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.justicar.JusticarUtility.SpawnData2;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.skotizo.SkotizoUtility;
import io.battlerune.game.world.entity.combat.strategy.npc.boss.skotizo.SkotizoUtility.SpawnData;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * 
 * @author Adam_#6723
 *
 */

public class BossEventButtonPlugin extends PluginContext {

	@Override
	protected boolean onClick(Player player, int button) {
		if (button == -19935) {
			if (GalvekUtility.activated == true) {
				SpawnData1 galvekpos = GalvekUtility.spawn;
				Teleportation.teleport(player, galvekpos.getPosition());
				player.message("You have teleported to Galvek");
				player.hideTeleportButton();
				return true;
			}
			/*
			 * if(ArenaUtility.activated == true) { Teleportation.teleport(player,
			 * Config.ARENA_ZONE); player.message("Teleporting you to Glod");
			 * player.hideTeleportButton(); }
			 */
			/*
			 * if(JusticarUtility.activated == true) { SpawnData justicar =
			 * JusticarUtility.spawn; Teleportation.teleport(player,
			 * justicar.getPosition()); player.message("Teleporting you to Justicar");
			 * player.hideTeleportButton(); } if(ArenaUtility.activated == false &&
			 * GalvekUtility.activated == true && JusticarUtility.activated == true) {
			 * player.message("Adam fucked up, spam tf outta him so he fixes this."); return
			 * false; }
			 */

		}
		if (button == -18935) {
			if (ArenaUtility.activated == true) {
				Teleportation.teleport(player, Config.ARENA_ZONE);
				player.message("Teleporting you to Glod");
				player.hideTeleportButton1();
				return true;
			}
		}
		if (button == -17935) {
			if (JusticarUtility.activated == true) {
				SpawnData2 justicar = JusticarUtility.spawn;
				Teleportation.teleport(player, justicar.getPosition());
				player.message("You have teleported to Justicar");
				player.hideTeleportButton2();
				return true;
			}
			return false;
		}
		if (button == -16935) {
			if (SkotizoUtility.activated == true) {
				SpawnData skotizo = SkotizoUtility.spawn;
				Teleportation.teleport(player, skotizo.getPosition());
				player.message("You have teleported to Skotizo");
				player.hideTeleportButton3();
				return true;
			}
			return false;
		}
		player.hideTeleportButton();
		player.hideTeleportButton1();
		player.hideTeleportButton2();
		player.hideTeleportButton3();
		return false;
	}
}
