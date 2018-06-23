package io.battlerune.game.world.entity.mob.player.command;

import io.battlerune.game.world.entity.mob.player.Player;

public abstract class Command {

    private final String[] names;

    public Command(String... names) {
        this.names = names;
    }

    public abstract void execute(Player player, CommandParser parser);

    public String[] getNames() {
        return names;
    }

}
