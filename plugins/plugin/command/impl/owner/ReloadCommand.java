package plugin.command.impl.owner;

import io.battlerune.content.command.Command;
import io.battlerune.content.skill.SkillRepository;
import io.battlerune.content.store.Store;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.combat.attack.listener.CombatListenerManager;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.npc.definition.NpcDefinition;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.items.ItemDefinition;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.util.parser.impl.CombatProjectileParser;
import io.battlerune.util.parser.impl.GlobalObjectParser;
import io.battlerune.util.parser.impl.NpcDropParser;
import io.battlerune.util.parser.impl.NpcForceChatParser;
import io.battlerune.util.parser.impl.NpcSpawnParser;
import io.battlerune.util.parser.impl.StoreParser;

/**
 * 
 * @author Adam_#6723
 *
 */

public class ReloadCommand implements Command {

	@Override
	public void execute(Player player, String[] command) {
         		 
			final String name = String.format(command[1]);
                     CombatListenerManager.load();
                     player.send(new SendMessage("Combat listeners have been successfully loaded."));
                     

                     new CombatProjectileParser().run();
                     player.send(new SendMessage("Projectiles have been successfully loaded."));
                     
                     ItemDefinition.createParser().run();
                     player.send(new SendMessage("Items have been successfully loaded."));
                     

                     player.send(new SendMessage("Objects have been successfully loaded."));
                     

                     player.send(new SendMessage("Combat projectiles have been successfully loaded."));
                     World.getNpcs().forEach(Npc::unregister);
                     NpcDefinition.createParser().run();
                     new NpcSpawnParser().run();
                     new NpcForceChatParser().run();
                     player.send(new SendMessage("Npc spawns have been successfully loaded."));
                     ItemDefinition.createParser().run();
                     player.send(new SendMessage("Items have been successfully loaded."));
                     CombatListenerManager.load();
                     player.send(new SendMessage("Combat listeners have been successfully loaded."));
                     

                     World.getNpcs().forEach(Npc::unregister);
                     NpcDefinition.createParser().run();
                     new NpcSpawnParser().run();
                     new NpcForceChatParser().run();
                     new NpcDropParser().run();
                     player.send(new SendMessage("Npc spawns have been successfully loaded."));
                     SkillRepository.load();
                     player.send(new SendMessage("Skills have been successfully loaded."));
                     

                     Store.STORES.clear();
                     new StoreParser().run();
                     player.send(new SendMessage("Stores have been successfully loaded."));

             }
         

		
	
	
	@Override
	public boolean canUse(Player player) {
		if (PlayerRight.isDeveloper(player)) {
			return true;
		}
		player.speak("Hey everyone, i just tried doing something silly.");
		return false;
	}

}
