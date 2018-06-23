package io.battlerune.game.world.region;

import org.eclipse.jetty.util.ConcurrentHashSet;

import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.items.ground.GroundItem;
import io.battlerune.game.world.object.CustomGameObject;
import io.battlerune.game.world.object.GameObject;
import io.battlerune.game.world.position.Position;
import io.battlerune.net.packet.out.SendAddObject;
import io.battlerune.net.packet.out.SendGroundItem;
import io.battlerune.net.packet.out.SendRemoveObject;

import static io.battlerune.game.world.region.Region.SIZE;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Represents a single region.
 *
 * @author Graham Edgecombe
 */
public class RegionBlock {

    /** The tiles within the region. */
    private RegionTile[] tiles;

    /** A list of players in this region. */
    private Deque<Player> players = new ConcurrentLinkedDeque<>();

    /** A list of npcs in this region. */
    private Deque<Npc> npcs = new ConcurrentLinkedDeque<>();

    /** A list of objects in this region. */
    private Map<Position, List<GameObject>> objects;

    /** A list of removed objects in this region. */
    private Deque<GameObject> skipped;

    /** A list of ground items in this region. */
    private Map<Position, Set<GroundItem>> groundItems;

    /** @return the players in this block */
    public Collection<Player> getPlayers() {
        return players;
    }

    /** @return the npcs in this block */
    public Collection<Npc> getNpcs() {
        return npcs;
    }

    /**
     * Gets a {@link Set} of {@link GroundItem}s. If none then creating the
     * set.
     *
     * @param position the position to grab from.
     * @return the set of item nodes on the specified position.
     */
    public Set<GroundItem> getGroundItems(Position position) {
        return getGroundItems().getOrDefault(position, new ConcurrentHashSet<>());
    }

    /**
     * The method that retrieves the item with {@code id} on {@code position}.
     *
     * @param id       the identifier to retrieve the item with.
     * @param position the position to retrieve the item on.
     * @return the item instance wrapped in an optional, or an empty optional if
     * no item is found.
     */
    GroundItem getGroundItem(int id, Position position) {
        for (GroundItem item : getGroundItems(position)) {
            if (item.isRegistered() && item.item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    /** Adds a player to this block. */
    void addPlayer(Player player) {
        players.add(player);
    }

    /** Removes a player from this block. */
    void removePlayer(Player player) {
        players.remove(player);
    }

    /** Adds an npc to this block. */
    void addNpc(Npc npc) {
        npcs.add(npc);
    }

    /** Removes an npc from this block. */
    void removeNpc(Npc npc) {
        npcs.remove(npc);
    }

    /** Adds an object to this block. */
    void addObject(GameObject object) {
        List<GameObject> objs = getObjects().getOrDefault(object.getPosition(), new LinkedList<>());
        if (objs.add(object)) getObjects().put(object.getPosition(), objs);
    }

    /** Removes an object from this block. */
    void removeObject(GameObject object) {
        List<GameObject> objs = getObjects().get(object.getPosition());
        if (objs != null) objs.remove(object);
    }

    /** Adds a ground item to this block. */
    void addGroundItem(GroundItem item) {
        Set<GroundItem> items = getGroundItems(item.getPosition());
        int index = 0;
        for (GroundItem other : items) {
            if (other.getIndex() + 1 > index) {
                index = other.getIndex() + 1;
            }
        }
        item.setIndex(index);
        items.add(item);
        getGroundItems().put(item.getPosition(), items);
    }

    /** Adds a ground item to this block. */
    void removeGroundItem(GroundItem item) {
        Set<GroundItem> items = getGroundItems(item.getPosition());
        items.remove(item);
        if (items.isEmpty()) {
            getGroundItems().remove(item.getPosition());
        } else {
            getGroundItems().put(item.getPosition(), items);
        }
    }

    /** @return {@code true} if this region contains this npc */
    boolean containsNpc(Npc npc) {
        return npcs.contains(npc);
    }

    /** @return {@code true} if this region contains this player */
    boolean containsPlayer(Player player) {
        return players.contains(player);
    }

    /** @return {@code true} if object is in region */
    boolean containsObject(GameObject object) {
        List<GameObject> objs = getObjects().get(object.getPosition());
        return objs != null && objs.contains(object);
    }

    /** @return {@code true} if position is occupied by object */
    boolean containsObject(Position position) {
        List<GameObject> objs = getObjects().get(position);
        return objs != null && !objs.isEmpty();
    }

    GameObject getGameObject(int id, Position position) {
        for (GameObject object : getGameObjects(position)) {
            if (object.getId() == id) {
                return object;
            }
        }
        return null;
    }

    List<GameObject> getGameObjects(Position position) {
        return getObjects().getOrDefault(position, Collections.emptyList());
    }

    void sendGameObjects(Player player) {
        for (GameObject object : getRemovedObjects()) {
            player.send(new SendRemoveObject(object));
        }
        Set<Map.Entry<Position, List<GameObject>>> entrySet = getObjects().entrySet();
        for (Map.Entry<Position, List<GameObject>> entry : entrySet) {
            for (GameObject object : entry.getValue()) {
                if (!(object instanceof CustomGameObject))
                    continue;
                CustomGameObject obj = (CustomGameObject) object;
                if (!obj.isValid())
                    continue;
                player.send(new SendAddObject(obj));
            }
        }
    }

    /**
     * The method which handles updating when the specified {@code player}
     * enters a new region.
     */
    void sendGroundItems(Player player) {
        for (Map.Entry<Position, Set<GroundItem>> entry : getGroundItems().entrySet()) {
            for (GroundItem groundItem : entry.getValue()) {
                if (!groundItem.isRegistered())
                    continue;

                if (groundItem.canSee(player))
                    player.send(new SendGroundItem(groundItem));
            }
        }
    }

    private Map<Position, Set<GroundItem>> getGroundItems() {
        if (groundItems == null)
            groundItems = new ConcurrentHashMap<>();
        return groundItems;
    }

    private Map<Position, List<GameObject>> getObjects() {
        if (objects == null)
            objects = new ConcurrentHashMap<>();
        return objects;
    }

    private Deque<GameObject> getRemovedObjects() {
        if (skipped == null)
            skipped = new ConcurrentLinkedDeque<>();
        return skipped;
    }

    /**
     * Gets a single tile in this region from the specified height, x and y
     * coordinates.
     *
     * @param x      The x coordinate.
     * @param y      The y coordinate.
     * @return The tile in this region for the specified attributes.
     */
    RegionTile getTile(int x, int y) {
        if (tiles == null)
            tiles = new RegionTile[SIZE * SIZE];
        int index = x + y * SIZE;
        if (tiles[index] == null)
            tiles[index] = new RegionTile();
        return tiles[index];
    }

    void skip(GameObject gameObject) {
        getRemovedObjects().add(gameObject);
    }
}
