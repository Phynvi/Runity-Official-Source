package io.battlerune.content.activity.impl;

import io.battlerune.content.ActivityLog;
import io.battlerune.content.achievement.AchievementHandler;
import io.battlerune.content.achievement.AchievementKey;
import io.battlerune.content.activity.Activity;
import io.battlerune.content.activity.ActivityDeathType;
import io.battlerune.content.activity.ActivityType;
import io.battlerune.content.event.impl.NpcInteractionEvent;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.npc.NpcDeath;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.util.Utility;

/**
 * The activity for Vorkath.
 *
 * @author Adam_#6723.
 */
public class VorkathActivity extends Activity {

    /** The player instance for the activity. */
    private final Player player;

    /** The Vorkath npc instance. */
    private Npc vorkath = new Npc(8059, new Position(2269, 4062));

    /** Flag if Vorkath has been summoned. */
    private boolean summoned;

    /** Constructs a new <code>VorkathActivity</code>. */
    private VorkathActivity(Player player, int instance) {
        super(1, instance);
        this.player = player;
    }

    /** Creates a new Vorkath activity for the player. */
    public static VorkathActivity create(Player player) {
        VorkathActivity activity = new VorkathActivity(player, player.playerAssistant.instance());
        activity.pause();
        activity.add(player);
        activity.vorkath.owner = player;
        activity.add(activity.vorkath);
     //   activity.vorkath.blockInteract = true;
    //    activity.vorkath.blockFace = true;
     //   activity.vorkath.locking.lock();
        /*
                        activity.zulrah = new Npc(2042, new Position(2266, 3073));
                activity.attackable = false;
                activity.zulrah.locking.lock();
                activity.zulrah.owner = player;
                activity.add(activity.zulrah);
                activity.zulrah.definition.setRetaliate(false);
                activity.zulrah.animate(new Animation(5071));

         */
        activity.start();
        return activity;
    }

    @Override
    protected void start() {
        if (this.isPaused())
        {
            this.setPause(false);
            System.out.println("Resuming Vorkath");
        }
    }

    @Override
    public void finish() {
        boolean successful = vorkath.isDead();

        cleanup();
        remove(player);

        if (successful) {
            player.activityLogger.add(ActivityLog.VORKATH);
            AchievementHandler.activate(player, AchievementKey.VORKATH);
            player.message("Congratulations, you have killed the Vorkath. Fight duration: @red@" + Utility.getTime(player.gameRecord.end(ActivityType.VORKATH)) + "</col>.");


            restart(10, () -> {
                if (Area.inVorkath(player)) {
                    create(player);
                } else {
                    remove(player);
                }
            });
        }
    }

    @Override
    public void cleanup() {
        remove(vorkath);
    }

    @Override
    protected boolean clickNpc(Player player, NpcInteractionEvent event) {
        if (event.getOpcode() == 0 && event.getNpc().id == 8059 && !summoned) {
            summoned = true;
            player.animate(827);
            vorkath.animate(7950);

            World.schedule(7, () -> {
                vorkath.transform(8060);
                World.schedule(1, () -> {
                    vorkath.face(player);
                  // vorkath.blockInteract = false;
                    vorkath.blockFace = false;
                    vorkath.locking.unlock();
                   // player.gameRecord.start();
                });

            });
            return true;
        }
        return false;
    }

    @Override
    public void onLogout(Player player) {
        cleanup();
        remove(player);
    }

    @Override
    public void onDeath(Mob mob) {
        if (mob.isNpc() && mob.getNpc().equals(vorkath)) {
            World.schedule(new NpcDeath(mob.getNpc(), this::finish));
            return;
        }

        super.onDeath(mob);
    }

    @Override
    public void onRegionChange(Player player) {
        if (!Area.inVorkath(player)) {
            cleanup();
            remove(player);
        }
    }

    @Override
    public ActivityDeathType deathType() {
        return ActivityDeathType.PURCHASE;
    }

    @Override
    public boolean canTeleport(Player player) {
        return true;
    }

    @Override
    public ActivityType getType() {
        return ActivityType.VORKATH;
    }
}
