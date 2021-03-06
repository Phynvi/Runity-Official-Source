package io.battlerune.game.event.listener;

import io.battlerune.game.event.Event;

/**
 * The base event listener that will listen for any type of event.
 *
 * @author nshusa
 */
public interface EventListener {

	default void accept(Event event) {

	}

}
