package plugin.command.impl.player;

import io.battlerune.content.command.Command;
import io.battlerune.content.triviabot.TriviaBot;
import io.battlerune.game.world.entity.mob.player.Player;

/**
 * @author Adam_#6723
 */

public class AnswerTriviaCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		final String message = command.substring(4, command.length());
		TriviaBot.answer(player, message);

	}

	@Override
	public boolean canUse(Player player) {
		return true;
	}
}
