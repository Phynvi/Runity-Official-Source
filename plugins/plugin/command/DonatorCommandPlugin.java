package plugin.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.battlerune.Config;
import io.battlerune.content.activity.impl.cerberus.CerberusActivity;
import io.battlerune.content.activity.impl.vorkath.VorkathActivity;
import io.battlerune.content.skill.impl.magic.teleport.Teleportation;
import io.battlerune.game.plugin.extension.CommandExtension;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.mob.player.PlayerRight;
import io.battlerune.game.world.entity.mob.player.command.Command;
import io.battlerune.game.world.entity.mob.player.command.CommandParser;
import io.battlerune.game.world.position.Area;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendScrollbar;
import io.battlerune.net.packet.out.SendString;

public class DonatorCommandPlugin extends CommandExtension {

    @Override
    protected void register() {
    	
    	commands.add(new Command("commands", "command") {
            @Override
            public void execute(Player player, CommandParser parser) {
                player.send(new SendString("Commands List", 37103));
                player.send(new SendString("", 37107));

                // reset
                for (int i = 0; i < 50; i++) {
                    player.send(new SendString("", i + 37111));
                }

                final Set<String> set = new HashSet<>();
                int count = 0;

                for (CommandExtension extension : extensions) {

                    if (!extension.canAccess(player)) {
                        continue;
                    }

                    final String clazzName = extension.getClass().getSimpleName().replace("CommandPlugin", "");

                    player.send(new SendString(clazzName + " Commands", count + 37111));
                    count++;

                    for (Map.Entry<String, Command> entry : extension.multimap.entries()) {
                        if (count >= 100) {
                            break;
                        }

                        if (set.contains(entry.getKey())) {
                            continue;
                        }

                        final Command command = entry.getValue();

                        final StringBuilder builder = new StringBuilder();

                        for (int i = 0; i < command.getNames().length; i++) {
                            String name = command.getNames()[i];
                            builder.append("::");
                            builder.append(name);
                            if (i < command.getNames().length - 1) {
                                builder.append(", ");
                            }
                        }

                        player.send(new SendString(builder.toString(), count + 37111));

                        set.addAll(Arrays.asList(command.getNames()));

                        count++;
                    }
                }

                player.send(new SendScrollbar(37100, count * 22));
                player.interfaceManager.open(37100);

            }
        });
        
    	
        commands.add(new Command( "donorzone", "dzone") {
            @Override
            public void execute(Player player, CommandParser parser) {
                Teleportation.teleport(player, Config.DONATOR_ZONE, 20, () -> {
                    player.send(new SendMessage("Welcome to the donator zone, " + player.getName() + "!"));
                });
            }
        });
        commands.add(new Command("bank") {
            @Override
            public void execute(Player player, CommandParser parser) {
            	if(Area.inWilderness(player)) {
            		player.message("You cannot open the bank in the wilderness.");
            	} else {
                player.bank.open();
            	}
            }
        });
       
        
        commands.add(new Command("die") {
            @Override
            public void execute(Player player, CommandParser parser) {
                Teleportation.teleport(player, Config.DONATOR_ZONE, 20, () -> {
                    player.send(new SendMessage("Welcome to the donator zone, " + player.getName() + "!"));
                });
            }
        });
        
        commands.add(new Command("vorkath") {
            @Override
            public void execute(Player player, CommandParser parser) {
                Teleportation.teleport(player, Config.DONATOR_ZONE, 20, () -> {
               VorkathActivity.create(player);
                });
            }
        });
        
        commands.add(new Command("cerberus") {
            @Override
            public void execute(Player player, CommandParser parser) {
                Teleportation.teleport(player, Config.DONATOR_ZONE, 20, () -> {
               CerberusActivity.create(player);
                });
            }
        });
        
        commands.add(new Command("canceltask") {
            @Override
            public void execute(Player player, CommandParser parser) {
       player.slayer.cancel();
       player.message("You have cancelled your task!");
            	
            }
        });
        
        
        commands.add(new Command("lava") {
            @Override
            public void execute(Player player, CommandParser parser) {
                Teleportation.teleport(player, new Position(3363, 3318, 2));
                player.send(new SendMessage("@or2@Welcome to the Secret Lava dragon teleport!, " + player.getName() + "."));
            }
        });
        
        commands.add(new Command("portals", "portal", "portalzone", "pz") {
            @Override
            public void execute(Player player, CommandParser parser) {
           
                Teleportation.teleport(player, Config.PORTAL_ZONE, 20, () -> {
                    player.send(new SendMessage("@or2@Welcome to the Portal Zone, " + player.getName() + "."));
                    player.send(new SendMessage("@or2@Each portal teleports you to a different zone"));
                    player.send(new SendMessage("@or2@These are Safe Zones"));
                });
            }
        });
    }   
    
    /**
     * List of perks that donators have.
     * Di Zone
     * Die Zone
     * Portal Zone
     * Free access to instances without paying for them.
     * Normal Donators/Super Donators get X2 Slayer points.
     * Extreme donators and eliete get X3 Slayer points
     * King and Supreme Donators get X4
     * X2 Boss Points
     * X2 Trivia Points
     * X2 Pest Control points
     * Access to the donator Tab interface!
     * Allowed to use the Deposit item box.
     * Able to restore health and hp every 2 minutes.
     * Access to giant roc and lava dragon tele's.
     * Double EXP Overall.
     * Donators can use the obelisk to navigate through the wilderness.
     * Donators can change melee stats.
     * Access to the graceful store.
     * Double Kolodin points
     * 10% Drop rate applied for all donators.
     * Elite donators get 15% Drop rate overall.
     * Supreme & King donators get 20% Drop rate.
     * Donators are allowed to block slayer tasks for free and cancel them.
     * Super donators, get 12 Pk Points per kill
     * Extreme donatores get 13 Pk Points per kill
     * Elite Donators get 14 Pk Points per kill
     * King donators get 15 Pk Points per kill
     * Supreme Donators get 16 Pk Points per kill
     * Access to slayer store shortcuts
     * Access to the PK Store, with exclusive PK Items.
     * Donators get Fire capes & Fighter Torso and Barrows glove & Fighter hat & Infernal cape for free.
     */
        
    @Override
    public boolean canAccess(Player player) {
        return PlayerRight.isDonator(player);
    }

}
