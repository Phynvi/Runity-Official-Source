package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.net.packet.out.SendMessage;

public class GiveRankCommand implements Command {

	@Override
	public void execute(Player player, String command, String[] parts) {
		String name = parts[1].replaceAll("_", " ");
		
		World.search(name.toString()).ifPresent(other -> {
			DialogueFactory factory = player.dialogueFactory;
			factory.sendOption("Donator Ranks", () -> {
				factory.sendOption("Donator", () -> {
					other.setRight(PlayerRight.DONATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Super Donator", () -> {
					other.setRight(PlayerRight.SUPER_DONATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Extreme Donator", () -> {
					other.setRight(PlayerRight.EXTREME_DONATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Elite Donator", () -> {
					other.setRight(PlayerRight.ELITE_DONATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Supreme Donator", () -> {
					other.setRight(PlayerRight.SUPREME_DONATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				});
				player.send(new SendMessage("The rank of "+other.getUsername()+ " has been updated!"));
			}, "Staff Ranks", () -> {
				factory.sendOption("Server Support", () -> {
					other.setRight(PlayerRight.HELPER);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Moderator", () -> {
					other.setRight(PlayerRight.MODERATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Administrator", () -> {
					other.setRight(PlayerRight.ADMINISTRATOR);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Owner", () -> {
					other.setRight(PlayerRight.OWNER);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Developer", () -> {
					other.setRight(PlayerRight.DEVELOPER);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				});
				player.send(new SendMessage("The rank of "+other.getUsername()+ " has been updated!"));
			}, "Misc", () -> {
				factory.sendOption("Player", () -> {
					other.setRight(PlayerRight.PLAYER);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Ironman", () -> {
					other.setRight(PlayerRight.IRONMAN);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Ultimate Ironman", () -> {
					other.setRight(PlayerRight.ULTIMATE_IRONMAN);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Hardcore Ironman", () -> {
					other.setRight(PlayerRight.HARDCORE_IRONMAN);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				}, "Youtuber", () -> {
					other.setRight(PlayerRight.YOUTUBER);
					other.send(new SendMessage("@red@Your rank has been updated, please relog!"));
				});
				player.send(new SendMessage("The rank of "+other.getUsername()+ " has been updated!"));
			}, "Cancel", () -> {
				factory.clear();
			}).execute();
		});
	}

	@Override
	public boolean canUse(Player player) {
		return PlayerRight.isDeveloper(player);
	}

}
