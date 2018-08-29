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

public class MuteCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {

		final String name = String.format(parts[1]);

		World.search(name.toString()).ifPresent(other -> {
			if (PlayerRight.isPriviledged(other) && !PlayerRight.isDeveloper(player)) {
				player.message("@or2@You do not have permission to mute this player!");
				return;
			}

			DialogueFactory factory = player.dialogueFactory;
			factory.sendOption("Mute by day", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this mute to last for?", 2, input -> {
							other.punishment.mute(Integer.parseInt(input), TimeUnit.DAYS);
							factory.clear();
						})));
			}, "Mute by hour", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this mute to last for?", 3, input -> {
							other.punishment.mute(Integer.parseInt(input), TimeUnit.HOURS);
							factory.clear();
						})));
			}, "Mute by minute", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this mute to last for?", 3, input -> {
							other.punishment.mute(Integer.parseInt(input), TimeUnit.MINUTES);
							factory.clear();
						})));
			}, "Mute forever", () -> {
				factory.onAction(() -> {
					other.punishment.mute(9999, TimeUnit.DAYS);
					factory.clear();
				});
			}).execute();
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isManagement(player);
	}

}
