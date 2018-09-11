package plugin.command.impl.player;

import com.everythingrs.vote.Vote;

import io.battlerune.content.command.Command;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.net.packet.out.SendMessage;

/**
 * @author Nerik#8690
 */

public class ClaimVote implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		
		/***
		 * Needs a check...
		 */
		Vote.service.execute(new Runnable() {
			@Override
			public void run() {
				try {

					for (int i = 1; i < 3; i++) { 
						Vote[] reward = Vote.reward("it0nzms11avukb49jofyr2j4iyeigg9m99i3uqugiaspds4ibwg9wfjv364piqs8tbb0yynwmi", player.getUsername(), String.valueOf(i), String.valueOf(Byte.MAX_VALUE));

						if (reward[0].message != null) {
							player.send(new SendMessage(reward[0].message));
							return;
						}
						System.out.println("voted?");
						player.inventory.add(new Item(reward[0].reward_id, reward[0].give_amount));
					}
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
