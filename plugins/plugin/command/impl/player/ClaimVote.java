package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Nerik#8690
 */

public class ClaimVote implements Command {
	

	@Override
	public void execute(Player player, String command, String[] parts) {
		if (parts.length == 1) {
			player.send(new SendMessage("Please use [::reward id], [::reward id amount], or [::reward id all]."));
			return;
		}

		final String playerName = player.getUsername();
		final String id = parts[1];
		final String amount = parts.length == 3 ? parts[2] : "1";

		com.everythingrs.vote.Vote.service.execute(new Runnable() {
			@Override
			public void run() {
				try {
					com.everythingrs.vote.Vote[] reward = com.everythingrs.vote.Vote.reward(
							"it0nzms11avukb49jofyr2j4iyeigg9m99i3uqugiaspds4ibwg9wfjv364piqs8tbb0yynwmi", playerName,
							id, amount);
					if (reward[0].message != null) {
						player.send(new SendMessage(reward[0].message));
						return;
					}
					player.inventory.add(new Item(reward[0].reward_id, reward[0].give_amount));
					player.send(new SendMessage(
							"Thank you for voting! You now have " + reward[0].vote_points + " vote points."));
				} catch (Exception e) {
					player.send(new SendMessage("Api Services are currently offline. Please check back shortly"));
					e.printStackTrace();
				}
			}

		});

	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
