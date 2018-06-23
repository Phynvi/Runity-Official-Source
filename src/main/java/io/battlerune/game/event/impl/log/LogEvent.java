package io.battlerune.game.event.impl.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.battlerune.Config;
import io.battlerune.game.event.Event;

import java.io.IOException;
import java.time.LocalDateTime;

public abstract class LogEvent implements Event {

    private static final Logger logger = LogManager.getLogger();
    protected final LocalDateTime dateTime = LocalDateTime.now();

    public void log() {
        if (!Config.FORUM_INTEGRATION || !Config.LOG_PLAYER || true) {
            return;
        }

        new Thread(() -> {
            try {
                onLog();
            } catch (Exception ex) {
                logger.error(String.format("Error logging %s", this.getClass().getSimpleName()), ex);
            }
        }).start();
    }

    public abstract void onLog() throws Exception;

}
