package io.battlerune.content.activity.impl.battlerealm;

import static io.battlerune.content.activity.impl.battlerealm.Constants.GAME_AREA;
import static io.battlerune.content.activity.impl.battlerealm.Constants.LOBBY_AREA;

import com.google.common.collect.ImmutableList;

import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.impl.SquareArea;

public class BattleRealmCallers {
	public static ImmutableList<SquareArea> getAreas() {
		return ImmutableList.of(GAME_AREA, LOBBY_AREA);
	}

	public static boolean canFight(Player attacker, Mob defender) {
		try {
			return (attacker.battleRealmNode.team != defender.getPlayer().battleRealmNode.team)
					&& Area.inBattleRealm(attacker) && Area.inBattleRealm(defender);
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean cantFight(Player attacker, Mob defender) {
		try {
			return (attacker.battleRealmNode.team == defender.getPlayer().battleRealmNode.team)
					&& Area.inBattleRealm(attacker) && Area.inBattleRealm(defender);
		} catch (Exception e) {
			return false;
		}
	}
}
