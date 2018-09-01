package plugin.command.impl.moderator;

import java.util.concurrent.TimeUnit;

import io.battlerune.content.command.Command;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendInputAmount;

public class BanCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		String name = parts[1].replaceAll("_", " ");

		World.search(name.toString()).ifPresent(other -> {
			if (PlayerRight.isPriviledged(other) && !PlayerRight.isDeveloper(player)) {
				player.message("You do not have permission to ban this player!");
				return;
			}

			DialogueFactory factory = player.dialogueFactory;
			factory.sendOption("Ban by day", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this ban to last for?", 2, input -> {
							other.punishment.banUser(Integer.parseInt(input), TimeUnit.DAYS);
							factory.clear();
						})));
			}, "Ban by hour", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this ban to last for?", 3, input -> {
							other.punishment.banUser(Integer.parseInt(input), TimeUnit.HOURS);
							factory.clear();
						})));
			}, "Ban by minute", () -> {
				factory.onAction(() -> player
						.send(new SendInputAmount("How long do you want this ban to last for?", 3, input -> {
							other.punishment.banUser(Integer.parseInt(input), TimeUnit.MINUTES);
							factory.clear();
						})));
			}, "Ban forever", () -> {
				factory.onAction(() -> {
					other.punishment.banUser(9999, TimeUnit.DAYS);
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
