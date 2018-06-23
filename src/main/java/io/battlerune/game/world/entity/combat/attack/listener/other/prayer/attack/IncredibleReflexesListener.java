package io.battlerune.game.world.entity.combat.attack.listener.other.prayer.attack;

import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.mob.Mob;

public class IncredibleReflexesListener extends SimplifiedListener<Mob> {

    @Override
    public int modifyAttackLevel(Mob attacker, Mob defender, int damage) {
        return damage * 23 / 20;
    }

}
