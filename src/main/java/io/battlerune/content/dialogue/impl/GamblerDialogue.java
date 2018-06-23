package io.battlerune.content.dialogue.impl;

import io.battlerune.content.WellOfGoodwill;
import io.battlerune.content.clanchannel.ClanMember;
import io.battlerune.content.clanchannel.channel.ClanChannel;
import io.battlerune.content.clanchannel.content.ClanLevel;
import io.battlerune.content.clanchannel.content.ClanTask;
import io.battlerune.content.clanchannel.content.ClanViewer;
import io.battlerune.content.dialogue.Dialogue;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.content.dialogue.Expression;
import io.battlerune.content.store.Store;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.*;
import io.battlerune.util.Difficulty;
import io.battlerune.util.Utility;
import io.battlerune.util.parser.impl.NpcForceChatParser;

import java.util.Optional;
import java.util.Random;

import static io.battlerune.game.world.entity.EntityType.NPC;

/**
 * Handles the clan master dialogue.
 *
 * @author Red
 */
public class GamblerDialogue extends Dialogue {

    private Npc npc;

    public GamblerDialogue(Npc npc) {
        this.npc = npc;
    }

    @Override
    public void sendDialogues(DialogueFactory factory) {
        Player player = factory.getPlayer();
        factory.sendNpcChat(1012, Expression.HAPPY, "Welcome! Use an item on me to make a", "bet, or enter how many coins you would like to wager!");
        factory.onAction(() -> World.schedule(1, () -> player.send(new SendInputAmount("How much would you like to bet?", 10, input -> bet(factory, Integer.parseInt(input))))));
        factory.execute();
    }

    private void bet(DialogueFactory factory, int i) {
        factory.clear();
        Player player = factory.getPlayer();

        if (!player.inventory.contains(995, i))
        {
            factory.sendNpcChat(1012, Expression.LAUGH, "You do not have enough!");
            factory.execute();
            return;
        }

        int roll = new Random().nextInt(100);
        npc.speak("You rolled a " + roll);
        if (roll >= 55)
        {
            player.inventory.add(995, i);
        }
        else
        {
            player.inventory.remove(995, i);
        }
        //Somehow send something that tells player what they rolled

    }
}
