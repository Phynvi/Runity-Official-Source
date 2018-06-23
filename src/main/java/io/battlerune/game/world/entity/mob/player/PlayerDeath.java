package io.battlerune.game.world.entity.mob.player;

import io.battlerune.Config;
import io.battlerune.content.achievement.AchievementHandler;
import io.battlerune.content.achievement.AchievementKey;
import io.battlerune.content.activity.Activity;
import io.battlerune.content.bot.BotUtility;
import io.battlerune.content.bot.PlayerBot;
import io.battlerune.content.event.EventDispatcher;
import io.battlerune.content.event.impl.OnKillEvent;
import io.battlerune.content.ffa.FreeForAll;
import io.battlerune.content.pet.Pets;
import io.battlerune.content.writer.InterfaceWriter;
import io.battlerune.content.writer.impl.InformationWriter;
import io.battlerune.game.Animation;
import io.battlerune.game.UpdatePriority;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.combat.attack.listener.CombatListenerManager;
import io.battlerune.game.world.entity.combat.strategy.player.special.CombatSpecial;
import io.battlerune.game.world.entity.mob.Mob;
import io.battlerune.game.world.entity.mob.MobDeath;
import io.battlerune.game.world.entity.mob.UpdateFlag;
import io.battlerune.game.world.entity.mob.prayer.Prayer;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.containers.equipment.Equipment;
import io.battlerune.game.world.items.ground.GroundItem;
import io.battlerune.game.world.position.Area;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendRunEnergy;
import io.battlerune.util.Utility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Handles the player death listener.
 *
 * @author Daniel
 */
public final class PlayerDeath extends MobDeath<Player> {

    private boolean safe = false;

    /** Array of all death messages. */
    private static final String[] DEATH_MESSAGES = {
            "You have defeated $VICTIM.",
            "With a crushing blow, you defeat $VICTIM.",
            "It's a humiliating defeat for $VICTIM.",
            "$VICTIM didn't stand a chance against you.",
            "You have defeated $VICTIM.",
            "It's all over for $VICTIM.",
            "$VICTIM regrets the day they met you in combat.",
            "$VICTIM falls before your might.",
            "Can anyone defeat you? Certainly not $VICTIM.",
            "You were clearly a better fighter than $VICTIM."
    };

    /** Creates a new {@link MobDeath}. */
    PlayerDeath(Player mob) {
        super(mob, 2);
    }

    /** The part of the death process where the character is prepared for the rest of the death process. */
    @Override
    public void preDeath(Mob killer) {
        mob.animate(new Animation(836, UpdatePriority.VERY_HIGH));
    }

    /** The main part of the death process where the killer is found for the character. */
    @Override
    public void death() {
        Mob killer = mob.getCombat().getDamageCache().calculateProperKiller().orElse(null);

        if (mob.inActivity() && Activity.evaluate(mob, Activity::safe)) {
            safe = true;
            return;
        }

        if (Area.inZulrah(mob)) {
            safe = true;
            return;
        }

        if (Area.inEventArena(mob)) {
            safe = true;
            mob.equipment.unequip(Equipment.ARROWS_SLOT);
            mob.equipment.unequip(Equipment.AMULET_SLOT);
            mob.equipment.unequip(Equipment.HEAD_SLOT);
            mob.equipment.unequip(Equipment.HANDS_SLOT);
            mob.equipment.unequip(Equipment.LEGS_SLOT);
            mob.equipment.unequip(Equipment.FEET_SLOT);
            mob.equipment.unequip(Equipment.CHEST_SLOT);
            mob.equipment.unequip(Equipment.WEAPON_SLOT);
            mob.equipment.unequip(Equipment.SHIELD_SLOT);
            mob.equipment.unequip(Equipment.RING_SLOT);
            mob.equipment.unequip(Equipment.CAPE_SLOT);


            mob.send(new SendMessage("@red@Your Items have either been banked or sent to your inventory."));
            return;
        }

        if (!PlayerRight.isPriviledged(mob)) {
            Pets.onDeath(mob);
            calculateDropItems(mob, killer);
        }

        if (killer == null)
            return;

        switch (killer.getType()) {
            case PLAYER:
                Player playerKiller = killer.getPlayer();

                if (mob.isBot) {


                    playerKiller.message("<col=295EFF>You were rewarded with 1 point for that bot kill. You now have: " + Utility.formatDigits(playerKiller.pkPoints) + ".");
                    return;
                }

                if (!PlayerKilling.contains(playerKiller, mob.lastHost)) {
                    AchievementHandler.activate(playerKiller, AchievementKey.KILLER, 1);
                    playerKiller.send(new SendMessage(Utility.randomElement(DEATH_MESSAGES).replace("$VICTIM", mob.getName())));
                    PlayerKilling.handle(playerKiller, mob);
                } else {
                    playerKiller.message("<col=FF0019>You have recently killed " + mob.getName() + " and therefore were not rewarded. You must kill ", "<col=FF0019>3 new players to reset this!");
                }

                EventDispatcher.execute(playerKiller, new OnKillEvent(mob));
                break;
            case NPC:
                break;
            default:
                break;
        }

    }

    /** The last part of the death process where the character is reset. */
    @Override
    public void postDeath(Mob killer) {

        if (FreeForAll.game.containsKey(mob)) {
            FreeForAll.leaveGame(mob, "dead");
            return;
        }

        if (mob.isBot) {
            ((PlayerBot) mob).postDeath();
            return;
        }

        mob.unpoison();
        mob.runEnergy = 100;
        mob.skulling.unskull();
        mob.skills.restoreAll();
        mob.inventory.refresh();
        //   mob.equipment.login();
        mob.action.reset();
        mob.playerAssistant.reset();
        mob.interfaceManager.close();
        mob.setSpecialActivated(false);
        mob.getCombat().getDamageCache().clear();
        mob.send(new SendRunEnergy());
        CombatSpecial.restore(mob, 100);
        mob.movement.reset();
        mob.teleblockTimer.set(0);
        mob.equipment.updateAnimation();
        //mob.equipment.refresh();
        mob.equipment.login();

        //IF YOU'RE HAVING AN ISSUE WITH ITEM LISTENERS AFTER DEATH, IT'S THIS FUNCTION RIGHT HERE
        //This function was implementing because dying with a full set of barrows let you keep the effect.
        CombatListenerManager.removeAllPlayerListeners(mob);


        if (mob.inActivity()) {
            Activity.forActivity(mob, it -> it.onDeath(mob));
//            return;
        }

        mob.move(Config.DEFAULT_POSITION);
        mob.send(new SendMessage("Oh dear, you are dead!"));
        mob.animate(new Animation(-1, UpdatePriority.VERY_HIGH));

        if (mob.presetManager.deathOpen) {
            World.schedule(1, mob.presetManager::open);
        }

        if (!safe) {
            if (killer != null && killer.isPlayer() && !mob.equals(killer)) {
                mob.killstreak.end(killer.getName());
            }
            if (mob.right == PlayerRight.HARDCORE_IRONMAN) {
                mob.right = PlayerRight.IRONMAN;
                mob.updateFlags.add(UpdateFlag.APPEARANCE);
                mob.send(new SendMessage("You have lost your hardcore iron man status since you died!!!"));
                World.sendMessage("<col=FF0000>" + Config.SERVER_NAME + "<col=" + mob.right.getColor() + ">" + mob.getName() + "</col>'s " + (mob.brutalMode ? " Brutal Mode " : "") + "hardcore iron man account was lost!");
            }
        }

        InterfaceWriter.write(new InformationWriter(mob));

        mob.animate(new Animation(-1, UpdatePriority.VERY_HIGH));

    }

    /** Calculates and drops all of the items from {@code character} for {@code killer}. */
    private void calculateDropItems(Player character, Mob killer) {
        Player theKiller = killer == null || killer.isNpc() ? character : killer.getPlayer();

        if (character.right.equals(PlayerRight.ULTIMATE_IRONMAN)) {
            List<Item> items = new LinkedList<>();
            character.equipment.forEach(items::add);
            character.inventory.forEach(items::add);
            character.lootingBag.forEach(items::add);
            character.equipment.clear();
            character.inventory.clear();
            character.lootingBag.clear();
            items.forEach(item -> {
                if (!item.isTradeable()) {
                    if (!character.lostUntradeables.deposit(item)) {
                        GroundItem.create(character, item);
                    }
                } else {
                    GroundItem.create(theKiller, item, character.getPosition());
                }
            });
            return;
        }

        LinkedList<Item> toDrop = new LinkedList<>();
        List<Item> keep = new LinkedList<>();
        List<Item> items = new LinkedList<>();
        character.equipment.forEach(items::add);
        Item[] lootingBag = character.lootingBag.getDeathItems();
        character.inventory.forEach(item -> {
            if (item.getId() != 11941) {
                items.add(item);
            }
        });
        character.equipment.clear();
        character.inventory.clear();

        if (lootingBag != null) {
            items.addAll(Arrays.asList(lootingBag));
            character.lootingBag.clear();
        }

        toDrop.addAll(items);

        toDrop.sort((first, second) -> second.getValue() - first.getValue());

        if (!character.skulling.isSkulled()) {
            keep.add(toDrop.pollFirst());
            keep.add(toDrop.pollFirst());
            keep.add(toDrop.pollFirst());
        }

        if (character.prayer.isActive(Prayer.PROTECT_ITEM)) {
            keep.add(toDrop.pollFirst());
        }

        keep.forEach(item -> {
            if (item == null) {
                return;
            }

            character.inventory.add(new Item(item.getId()));
            if (item.isStackable() && item.getAmount() > 1) {
                toDrop.add(item.createAndDecrement(1));
            }
        });

        if (theKiller.isBot) {
            toDrop.forEach(item -> {
                if (character.runecraftPouch.death(item))
                    return;

                if (character.runePouch.death(item))
                    return;

                if (!item.isTradeable()) {
                    if (!character.lostUntradeables.deposit(item)) {
                        GroundItem.create(character, item);
                    }
                    return;
                }

                if (theKiller.isBot && item.getValue() >= 50_000) {
                    return;
                }

                BotUtility.logLoot(item);
            });

            GroundItem drop = GroundItem.create(theKiller, new Item(526), character.getPosition());
            if (!theKiller.equals(character) && PlayerRight.isIronman(theKiller)) {
                drop.canIronMenPickThisItemUp = false;
            }
            return;
        }

        toDrop.forEach(item -> {
            if (character.runecraftPouch.death(item))
                return;

            if (character.runePouch.death(item))
                return;

            if (!item.isTradeable()) {
                if (!character.lostUntradeables.deposit(item)) {
                    GroundItem.create(character, item);
                }
                return;
            }

            if (theKiller.isBot && item.getValue() >= 50_000) {
                return;
            }

            GroundItem drop = GroundItem.create(theKiller, item, character.getPosition());
            if (!theKiller.equals(character) && PlayerRight.isIronman(theKiller)) {
                drop.canIronMenPickThisItemUp = false;
            }
        });

        GroundItem drop = GroundItem.create(theKiller, new Item(526), character.getPosition());
        if (!theKiller.equals(character) && PlayerRight.isIronman(theKiller)) {
            drop.canIronMenPickThisItemUp = false;
        }
    }

}