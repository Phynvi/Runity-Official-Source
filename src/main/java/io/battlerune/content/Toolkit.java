package io.battlerune.content;

import io.battlerune.game.world.InterfaceConstants;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.Item;
import io.battlerune.game.world.items.ItemDefinition;
import io.battlerune.game.world.items.containers.ItemContainer;
import io.battlerune.net.packet.out.SendConfig;
import io.battlerune.net.packet.out.SendItemOnInterface;
import io.battlerune.net.packet.out.SendMessage;
import io.battlerune.net.packet.out.SendString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.battlerune.game.world.InterfaceConstants.TOOLKIT_INTERFACE;
import static io.battlerune.util.ItemIdentifiers.*;

/**
 * @author Adam_#6723
 * @since Wed, June 13, 2018 @ 7:55 PM
 */
public class Toolkit extends ItemContainer {

    /**
     * The {@link Player} using the {@link Toolkit}.
     */
    private Player player;

    /**
     * The place holder flag.
     */
    public boolean placeHolder;

    /**
     * The tools stored in the {@link Toolkit}.
     */
    public static final List<Item> TOOLS = new ArrayList<>(Arrays.asList(
            new Item(HAMMER),
            new Item(SHEARS),
            new Item(CHISEL),
            new Item(TINDERBOX),
            new Item(KNIFE),
            new Item(SAW),
            new Item(PESTLE_AND_MORTAR),
            new Item(FISHING_ROD),
            new Item(FLY_FISHING_ROD),
            new Item(LOBSTER_POT),
            new Item(HARPOON),
            new Item(SMALL_FISHING_NET),
            new Item(BIG_FISHING_NET),
            new Item(RAKE),
            new Item(SEED_DIBBER),
            new Item(SPADE),
            new Item(SECATEURS),
            new Item(MAGIC_SECATEURS),
            new Item(GLASSBLOWING_PIPE),
            new Item(BRONZE_PICKAXE),
            new Item(IRON_PICKAXE),
            new Item(MITHRIL_PICKAXE),
            new Item(ADAMANT_PICKAXE),
            new Item(RUNE_PICKAXE),
            new Item(BRONZE_AXE),
            new Item(IRON_AXE),
            new Item(MITHRIL_AXE),
            new Item(ADAMANT_AXE),
            new Item(RUNE_AXE),
            new Item(AMMO_MOULD),
            new Item(NECKLACE_MOULD),
            new Item(AMULET_MOULD),
            new Item(BRACELET_MOULD),
            new Item(RING_MOULD)
    ));

    /**
     * Constructs a {@link Toolkit} for the given {@link Player}.
     *
     * @param player {@link Player} player
     */
    public Toolkit(Player player) {
        super(33, StackPolicy.ALWAYS);
        this.player = player;
        this.placeHolder = true;
    }

    /**
     * Opens the {@link Toolkit}.
     */
    public void open() {
        refresh(player, TOOLKIT_INTERFACE);
        player.attributes.set("TOOLKIT_KEY", Boolean.TRUE);
        player.interfaceManager.openInventory(25000, 5063);
    }

    /**
     * Handles the place holder option for the contianer.
     */
    public void placeHolder(int item, int slot) {
        boolean hold = placeHolder;
        placeHolder = true;
        setFiringEvents(false);
        withdraw(item, slot, Integer.MAX_VALUE, true);
        setFiringEvents(true);
        placeHolder = hold;
        refresh();
    }

    public void close() {
        for (Item item : getItems()) {
            if (item == null)
                continue;
            if (remove(item))
                player.inventory.add(item);
        }
        clear(false);
        refresh();
        player.attributes.set("TOOLKIT_KEY", Boolean.FALSE);
    }


    public void fill(int id) {
        add(id, 1);
        placeHolder(id, -1);
        refresh();
    }


    public boolean deposit(int id, int slot, int amount) {
        if (!player.interfaceManager.isInterfaceOpen(25000)) {
            return false;
        }

        Item item = player.inventory.get(slot);

        if (item == null || item.getId() != id) {
            return false;
        }

        int contain = player.inventory.computeAmountForId(id);

        if (contain < amount) {
            amount = contain;
        }

        if (!add(item.getId(), amount)) {
            return false;
        }

        Item current = new Item(item.getId(), amount);

        if (item.isStackable() || amount == 1) {
            player.inventory.remove(current, slot, false);
        } else {
            player.inventory.remove(current, -1, false);
        }

        refresh();

        return true;
    }

    public boolean withdraw(int id, int slot, int amount, boolean starter) {
        if (!player.interfaceManager.isInterfaceOpen(25000) || !starter) {
            return false;
        }

        slot = computeIndexForId(id);
        if (id < 0) return false;

        Item item = get(slot);
        if (item == null || id != item.getId())
            return false;

        if (item.getAmount() == 0) {//Releasing place holders
            boolean hold = placeHolder;
            placeHolder = false;
            remove(item);
            shift();
            placeHolder = hold;
            refresh();
            return false;
        }

        if (item.getAmount() < amount) {
            amount = item.getAmount();
        }

        setFiringEvents(false);
        if (!new Item(id).isStackable() && amount > player.inventory.getFreeSlots()) {
            amount = player.inventory.getFreeSlots();
        } else if (ItemDefinition.get(id).isStackable() && player.inventory.getFreeSlots() == 0) {
            if (!player.inventory.contains(id)) {
                amount = 0;
            } else if (player.inventory.computeAmountForId(id) + amount > Integer.MAX_VALUE) {
                amount = Integer.MAX_VALUE - player.inventory.computeAmountForId(id);
            }
        }

        if (amount == 0) {
            player.send(new SendMessage("You do not have enough inventory spaces to withdraw this item."));
            return false;
        }

        int fuckingSlot = player.inventory.computeIndexForId(id);
        if (fuckingSlot != -1) {
            Item fuckingStan = player.inventory.get(fuckingSlot);
            if (Integer.MAX_VALUE - fuckingStan.getAmount() < amount) {
                amount = Integer.MAX_VALUE - fuckingStan.getAmount();
                player.send(new SendMessage("Your inventory didn't have enough space to withdraw all that!"));
            }
        }


        if (remove(item.getId(), amount)) {
            player.inventory.add(id, amount);
            /*// when an item is taken out of the bank completely, it removes one amount from the tab amounts array
            if (!contains(item.getId())) {
                int tab = tabForSlot(slot);
                changeTabAmount(tab, -1);
                shift();
            }*/
        }
        setFiringEvents(true);
        refresh();

        return true;
    }

    private void refresh() {
        refresh(player, TOOLKIT_INTERFACE);
        player.send(new SendConfig(116, placeHolder ? 1 : 0));
    }

    @Override
    public void onRefresh() {
        player.inventory.refresh();
        player.send(new SendString("Toolkit size: " + this.size(), 25007));
        player.send(new SendItemOnInterface(InterfaceConstants.INVENTORY_STORE, player.inventory.toArray()));
    }

    /**
     * Returns the {@link Player} using the {@link Toolkit}.
     *
     * @return {@link Player}
     */
    public Player getPlayer() {
        return player;
    }
}
