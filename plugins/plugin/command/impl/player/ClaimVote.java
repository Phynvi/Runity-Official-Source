package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Adam_#6723
 */

public class ClaimVote implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		String[] args = command.split(" ");
		if (args.length == 1) {
			player.send(new SendMessage("Please use [::reward id], [::reward id amount], or [::reward id all]."));
			return;
		}

		final String playerName = player.getUsername();
		final String id = args[1];
		final String amount = args.length == 3 ? args[2] : "1";

		com.everythingrs.vote.Vote.service.execute(new Runnable() {
			@Override
			public void run() {
				try {
					com.everythingrs.vote.Vote[] reward = com.everythingrs.vote.Vote.reward("secret_key", playerName,
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

	@Override
	public boolean canUse(Player player) {
		return true;
	}

}
