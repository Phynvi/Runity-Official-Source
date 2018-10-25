package plugin.click.button;

import io.battlerune.Config;
import io.battlerune.content.DropSimulator;
import io.battlerune.content.activity.impl.cerberus.CerberusActivity;
import io.battlerune.content.activity.impl.corp.CorporealBeastActivity;
import io.battlerune.content.activity.impl.giantmole.GiantMoleActivity;
import io.battlerune.content.activity.impl.graador.GraadorActivity;
import io.battlerune.content.activity.impl.kraken.KrakenActivity;
import io.battlerune.content.activity.impl.lizardmanshaman.LizardManActivity;
import io.battlerune.content.activity.impl.vorkath.VorkathActivity;
import io.battlerune.content.activity.impl.zulrah.ZulrahActivity;
import io.battlerune.content.dialogue.DialogueFactory;
import io.battlerune.content.playerguide.PlayerGuideHandler;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.content.skill.impl.slayer.SlayerTab;
import io.battlerune.content.teleport.TeleportHandler;
import io.battlerune.content.tittle.TitleManager;
import io.battlerune.content.writer.impl.SettingWriter;
import io.battlerune.game.plugin.PluginContext;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendFadeScreen;
import io.battlerune.net.packet.out.SendForceTab;
import io.battlerune.net.packet.out.SendMessage;

public class PlayerPanelButtonPlugin extends PluginContext {

	/**
	 * @author Adam/adameternal123
	 */

	protected boolean onClick(Player player, int button) {

		if (player.wilderness > 20 && !PlayerRight.isPriviledged(player)) {
			player.send(new SendMessage("You can't teleport above 20 wilderness!"));
			return false;
		}
		if (button == -5115) {
			Teleportation.teleport(player, Config.STARTER_ZONE);
			player.send(new SendMessage("You have teleported to Starter Zone!"));
			player.send(new SendMessage("@red@ - 1/100 chance of starter V2 Box!"));
			player.send(new SendMessage("@red@ - 1/200 chance of Mystery Box!"));
			player.send(new SendMessage("@red@ - 1/500 chance of 10$ Bond!"));
		}
		if(button == -5107) {
			new PlayerGuideHandler().open(player);
		}
		if(button == -5103) {
			player.send(new SendForceTab(Config.MUSIC_TAB));
		}
		if(button == -5099) {
			player.move(new Position(3086, 3485, 0));
			player.message("@red@ Click the portal to enter the minigame!");
			player.message("@red@best money maker on Runity");
		}
		if(button == -5095) {
			player.dialogueFactory.sendOption("AFK-Mining", () -> {
				player.dialogueFactory.onAction(() -> player.move(new Position(2910, 4832, 0)));
			},  "AFK-Fishing", () -> {
				player.dialogueFactory.onAction(() -> Teleportation.teleport(player, Config.AFK_FISHING));
			}, "AFK-Woodcutting", () -> {
				player.dialogueFactory.onAction(() -> Teleportation.teleport(player, Config.AFK_WOODCUTTING));
			}, "AFK-Firemaking", () -> {
				player.dialogueFactory.onAction(() -> Teleportation.teleport(player, Config.AFK_FIREMAKING));
			}).execute();
		}
		if(button == -5091) {
			TeleportHandler.open(player);
		}
		if(button == -5803) {
			player.interfaceManager.close();
			player.interfaceManager.setSidebar(Config.WRENCH_TAB, 50000);
			player.interfaceManager.close();
            player.interfaceManager.close();
		}
		return false;
	}
	
}
