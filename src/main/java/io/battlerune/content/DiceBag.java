package io.battlerune.content;

import java.util.concurrent.TimeUnit;

import io.battlerune.content.clanchannel.ClanRepository;
import io.battlerune.content.clanchannel.channel.ClanChannel;
import io.battlerune.content.clanchannel.channel.ClanManagement;
import io.battlerune.game.Animation;
import io.battlerune.game.Graphic;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.Utility;

/**
 * Handles the operating the dicing bag.
 *
 * @author Daniel.
 */
public class DiceBag {

	/** The dice animation. */
	private static final Animation ANIMATION = new Animation(7219);

	/** The dice graphic. */
	private static final Graphic GRAPHIC = new Graphic(1350);

	/**
	 * Handles rolling the dice bag.
	 *
	 * @param player
	 *            The player rolling the dice bag.
	 * @param clan
	 *            The flag if it's a clan roll.
	 */
	public static void roll(Player player, boolean clan) {
		if (player.getCombat().inCombat()) {
			player.send(new SendMessage("You can't be in combat to do this!"));
			return;
		}
		if (Area.inWilderness(player)) {
			player.send(new SendMessage("You can't be in the wilderness to do this!"));
			return;
		}
		if (clan && player.clan == null) {
			player.send(new SendMessage("You need to be in a clan chat channel to do this!"));
			return;
		}
		if (!player.diceDelay.elapsed(3, TimeUnit.SECONDS)) {
			player.send(new SendMessage("You can't do this so quickly!"));
			return;
		}

		int random = Utility.random(1, 100);

		if (clan) {
			if (player.clanChannel != null) {
				rollDice(player, clan, random);
				return;
			}
			player.send(new SendMessage("@blu@You need to be in a Clan Chat channel in order to roll the percentile dice!"));
			return;
		}
		rollDice(player, clan, random);
		return;
	}

	private static void rollDice(Player player, boolean clan, int random) {
		if (clan)
			player.clanChannel
					.message(player.getName() + " has rolled <col=ff0000>" + random + "</col> on the percentile dice!");
		else
			player.send(new SendMessage("@blu@You have rolled @red@" + random + "@blu@ on the percentile dice!"));
		player.animate(ANIMATION);
		player.graphic(GRAPHIC);
		boolean hasClan = player.clanChannel != null;

		if (hasClan) {
			player.clanChannel.message("@blu@You have rolled @red@" + random + "@blu@ on the percentile dice!");
		}
//        if (clan) {
//            Clan channel = ClanRepository.get(player.clan);
//            if (channel == null)
//                return;
//            ClanManager.communicate(channel, player.getName() + " has rolled <col=ff0000>" + random + "</col> on the percentile dice!");
//            return;
//        }
		player.diceDelay.reset();
	}
}