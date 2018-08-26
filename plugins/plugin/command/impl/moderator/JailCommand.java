package plugin.command.impl.moderator;

import java.util.concurrent.TimeUnit;

import io.battlerune.content.command.Command;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendInputAmount;

/**
 * 
 * @author Adam_#6723
 *
 */

public class JailCommand implements Command {

	@Override
	public void execute(Player player, String command,  String[] parts) {
		final String name = String.format(parts[1]);
		World.search(name.toString()).ifPresent(other -> {
			if (PlayerRight.isPriviledged(other) && !PlayerRight.isDeveloper(player)) {
				player.message("@or2@You do not have permission to jail this player!");
				return;
			}

			DialogueFactory factory = player.dialogueFactory;
			factory.sendOption("Jail by day", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this jail to last for?", 2, input -> {
							other.punishment.jail(Integer.parseInt(input), TimeUnit.DAYS);
							factory.clear();
						})));
			}, "Jail by hour", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this jail to last for?", 3, input -> {
							other.punishment.jail(Integer.parseInt(input), TimeUnit.HOURS);
							factory.clear();
						})));
			}, "Jail by minute", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this jail to last for?", 3, input -> {
							other.punishment.jail(Integer.parseInt(input), TimeUnit.MINUTES);
							factory.clear();
						})));
			}, "Jail forever", () -> {
				factory.onAction(() -> {
					other.punishment.jail(9999, TimeUnit.DAYS);
					factory.clear();
				});
			}).execute();
		});
	}

	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isManagement(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}

}
