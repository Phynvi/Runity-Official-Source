package io.battlerune.game.world.entity.combat.attack.listener.other.prayer.magic;

import io.battlerune.game.world.entity.combat.attack.listener.SimplifiedListener;
import io.battlerune.game.world.entity.mob.Mob;

public class MysticWillListener extends SimplifiedListener<Mob> {

    @Override
    public int modifyMagicLevel(Mob attacker, Mob defender, int level) {
        return level * 21 / 20;
    }

}
