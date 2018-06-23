package io.battlerune.content.activity.impl.dropcatcher;

import io.battlerune.content.achievement.AchievementHandler;
import io.battlerune.content.achievement.AchievementKey;
import io.battlerune.content.activity.Activity;
import io.battlerune.content.activity.ActivityType;
import io.battlerune.content.activity.panel.ActivityPanel;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.npc.NpcDeath;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendEntityHintArrow;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.RandomUtils;
import io.battlerune.util.Utility;

/*
public class DropCatcher extends Activity {

    private final Player player;

    private Npc monster;

    private DropCatcherData wave = DropCatcherData.AGRITH_NA_NA;

    private DropCatcher(Player player, int instance) {
        super(10, instance);
        this.player = player;
    }

    Handles creating a recipe for disaster activity.
    public static DropCatcher create(Player player) {
    	DropCatcher minigame = new DropCatcher(player, player.playerAssistant.instance());
        ActivityPanel.update(player, -1, "Recipe For Disaster", "Good Luck, " + player.getName() + "!", "Wave starting in 6 seconds");
        player.move(new Position(1899, 5356, 2));
        //pos[x=1899, y=5356, z=2]
        player.gameRecord.start();
        minigame.add(player);
        minigame.resetCooldown();
        return minigame;
    }

    @Override
    public void update() {
        if (wave == null) {
            ActivityPanel.update(player, 100, "Recipe For Disaster", new Item(7462), "</col>Wave: <col=FF5500>" + DropCatcherData.values().length + "/" + DropCatcherData.values().length, "</col>Boss: <col=FF5500>None!", "</col>Time: <col=FF5500>" + Utility.getTime(System.currentTimeMillis() - player.gameRecord.time));
            return;
        }
        int progress = (int) Utility.getPercentageAmount(wave.ordinal(), DropCatcherData.values().length);
        int display = 7453 + wave.gloves;
        String npc = monster == null ? "" : monster.getName();
        ActivityPanel.update(player, progress, "Recipe For Disaster", new Item(display), "</col>Wave: <col=FF5500>" + wave.ordinal() + "/" + DropCatcherData.values().length, "</col>Boss: <col=FF5500>" + npc, "</col>Time: <col=FF5500>" + Utility.getTime(System.currentTimeMillis() - player.gameRecord.time));
    }

    @Override
    protected void start() {
        if (wave == null) {
            finishCooldown();
            return;
        }
        if (player.locking.locked()) {
            return;
        }
        Position spawn = new Position(1899, 5356, 2);
        Position[] boundaries = Utility.getInnerBoundaries(spawn, 5, 5);

        Npc npc = new Npc(wave.npc, RandomUtils.random(boundaries));
        npc.owner = player;
        add(monster = npc);

        player.send(new SendEntityHintArrow(npc));
        monster.getCombat().attack(player);
        pause();
    }

    @Override
    public void finish() {
        cleanup();
        int reward;
        if (wave == null) {
            long time = player.gameRecord.end(ActivityType.DROP_CATCHER);
            reward = DropCatcherData.CULINAROMANCER.gloves;
            AchievementHandler.activate(player, AchievementKey.COMPLETE_RFD);
            player.send(new SendMessage("You have completed the Recipe For Disaster activity. Final time: @red@" + Utility.getTime(time) + "</col>."));
        } else {
            reward = wave.gloves;
            player.send(new SendMessage("RIP"));
        }
        if (reward > player.glovesTier) {
            player.glovesTier = reward;
        }
        player.move(new Position(3080, 3498, 0));
        player.dialogueFactory.sendNpcChat(6526, "You have been rewarded for your efforts.", "Check my store to see your available gloves.").execute();
        remove(player);
    }

    @Override
    public void cleanup() {
        if (monster != null) {
            player.send(new SendEntityHintArrow(monster, true));
            remove(monster);
        }
        ActivityPanel.clear(player);
    }

    @Override
    public boolean canTeleport(Player player) {
        if (player.getCombat().inCombat()) {
            player.send(new SendMessage("You can not do that right now!"));
            return false;
        }
        player.locking.lock();
        cleanup();
        remove(player);
        player.send(new SendMessage("You have forfeited your current progress as you have teleproted."));
        return true;
    }

    @Override
    public void onRegionChange(Player player) {
        if (!Area.inDropcatcher(player)) {
            finish();
        }
    }

    @Override
    public void onLogout(Player player) {
        finish();
    }

    @Override
    public void onDeath(Mob mob) {
        if (mob.isPlayer()) {
            cleanup();
            remove(mob);
            mob.move(new Position(3080, 3498, 0));
            return;
        }
        if (mob.isNpc()) {
            player.send(new SendEntityHintArrow(mob, true));
            World.schedule(new NpcDeath(mob.getNpc()));
            wave = wave.getNext();
            resetCooldown();
        }
    }

    @Override
    public ActivityType getType() {
        return ActivityType.DROP_CATCHER;
    }
}*/
