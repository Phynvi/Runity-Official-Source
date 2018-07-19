package io.battlerune.game.engine.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import io.battlerune.game.engine.sync.task.NpcPostUpdateTask;
import io.battlerune.game.engine.sync.task.NpcPreUpdateTask;
import io.battlerune.game.engine.sync.task.NpcUpdateTask;
import io.battlerune.game.engine.sync.task.PhasedUpdateTask;
import io.battlerune.game.engine.sync.task.PlayerPostUpdateTask;
import io.battlerune.game.engine.sync.task.PlayerPreUpdateTask;
import io.battlerune.game.engine.sync.task.PlayerUpdateTask;
import io.battlerune.game.world.entity.MobList;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;

public final class ParallelClientSynchronizer implements ClientSynchronizer {

    private static final ExecutorService executor = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final Phaser phaser = new Phaser(1);

    @Override
    public void synchronize(MobList<Player> players, MobList<Npc> npcs) {

        // player movement
        phaser.bulkRegister(players.size());
        players.forEach(player -> executor.submit(new PhasedUpdateTask(phaser, new PlayerPreUpdateTask(player))));
        phaser.arriveAndAwaitAdvance();

        // npc movement
        phaser.bulkRegister(npcs.size());
        npcs.forEach(npc -> executor.submit(new PhasedUpdateTask(phaser, new NpcPreUpdateTask(npc))));
        phaser.arriveAndAwaitAdvance();

        // player updating
        phaser.bulkRegister(players.size());
        players.forEach(player -> executor.submit(new PhasedUpdateTask(phaser, new PlayerUpdateTask(player))));
        phaser.arriveAndAwaitAdvance();

        // npc updating
        phaser.bulkRegister(players.size());
        players.forEach(player -> executor.submit(new PhasedUpdateTask(phaser, new NpcUpdateTask(player))));
        phaser.arriveAndAwaitAdvance();

        // reset player
        phaser.bulkRegister(players.size());
        players.forEach(player -> executor.submit(new PhasedUpdateTask(phaser, new PlayerPostUpdateTask(player))));
        phaser.arriveAndAwaitAdvance();

        // reset npc
        phaser.bulkRegister(npcs.size());
        npcs.forEach(npc -> executor.submit(new PhasedUpdateTask(phaser, new NpcPostUpdateTask(npc))));
        phaser.arriveAndAwaitAdvance();

    }

}
