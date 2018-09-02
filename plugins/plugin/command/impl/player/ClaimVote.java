package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Nerik#8690
 */

public class ClaimVote implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		DialogueFactory factory = player.dialogueFactory;
		factory.sendOption("1.000.000 Coins", () -> {
			if (player.inventory.getFreeSlots() > 2) {
				run(player, 995, 1000000);
			} else {
				player.send(new SendMessage("Please make sure to have atleast 2 free slots"));
			}
		}, "Vote Token", () -> {
			if (player.inventory.getFreeSlots() > 2) {
				run(player, 7478, 1);
			} else {
				player.send(new SendMessage("Please make sure to have atleast 2 free slots"));
			}
		}, "Cancel", () -> {
			factory.clear();
		});

	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}

	private void run(Player player, int itemId, int itemAmount) {
		final String playerName = player.getUsername();
		final String id = String.valueOf(itemId);
		final String amount = String.valueOf(itemAmount);

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
					player.inventory.add(reward[0].reward_id, reward[0].give_amount);
					player.send(new SendMessage(
							"Thank you for voting! You now have " + reward[0].vote_points + " vote points."));
				} catch (Exception e) {
					player.send(new SendMessage("Api Services are currently offline. Please check back shortly"));
					e.printStackTrace();
				}
			}

		});
	}

}
