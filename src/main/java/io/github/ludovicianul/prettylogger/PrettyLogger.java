package io.github.ludovicianul.prettylogger;

import io.github.ludovicianul.prettylogger.config.MarkerType;
import io.github.ludovicianul.prettylogger.config.level.PrettyMarker;
import io.github.ludovicianul.prettylogger.config.level.ConfigFactory;
import org.slf4j.Logger;

import java.util.EnumMap;
import java.util.Map;

/**
 * Decorator for the {@code Logger} class that offers additional methods for pretty printing
 * by leveraging the {@link org.slf4j.Marker} functionality
 */
public class PrettyLogger {

    private final Logger slf4jLogger;
    private final EnumMap<MarkerType, PrettyMarker> config;

    private PrettyLogger(Logger slf4jLogger) {
        this.slf4jLogger = slf4jLogger;
        config = new EnumMap<>(MarkerType.class);
        config.put(MarkerType.AWAITING, ConfigFactory.awaiting());
        config.put(MarkerType.COMPLETE, ConfigFactory.complete());
        config.put(MarkerType.DEBUG, ConfigFactory.debug());
        config.put(MarkerType.ERROR, ConfigFactory.error());
        config.put(MarkerType.FATAL, ConfigFactory.fatal());
        config.put(MarkerType.INFO, ConfigFactory.info());
        config.put(MarkerType.NOTE, ConfigFactory.note());
        config.put(MarkerType.PAUSE, ConfigFactory.pause());
        config.put(MarkerType.PENDING, ConfigFactory.pending());
        config.put(MarkerType.SANTA, ConfigFactory.santa());
        config.put(MarkerType.STAR, ConfigFactory.star());
        config.put(MarkerType.START, ConfigFactory.start());
        config.put(MarkerType.STOP, ConfigFactory.stop());
        config.put(MarkerType.SUCCESS, ConfigFactory.success());
        config.put(MarkerType.WARNING, ConfigFactory.warning());
        config.put(MarkerType.SKIP, ConfigFactory.skip());

    }

    private PrettyLogger(Logger slf4jLogger, Map<MarkerType, PrettyMarker> configMap) {
        this(slf4jLogger);
        config.putAll(configMap);
    }

    public static PrettyLogger fromSlf4j(Logger slf4jLogger) {
        return new PrettyLogger(slf4jLogger);
    }

    public static PrettyLogger fromSlf4j(Logger slf4jLogger, Map<MarkerType, PrettyMarker> configMap) {
        return new PrettyLogger(slf4jLogger, configMap);
    }

    public void awaiting(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.AWAITING);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void complete(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.COMPLETE);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void debug(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.DEBUG);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void error(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.ERROR);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void fatal(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.FATAL);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void info(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.INFO);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void note(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.NOTE);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void pause(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.PAUSE);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void santa(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.SANTA);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void star(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.STAR);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void start(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.START);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void stop(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.STOP);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void warn(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.WARNING);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void success(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.SUCCESS);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void skip(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.SKIP);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void pending(String message, Object... arguments) {
        PrettyMarker loggerConfig = config.get(MarkerType.PENDING);
        this.logInternal(loggerConfig, message, arguments);
    }

    public void log(PrettyMarker loggerConfig, String message, Object... arguments) {
        this.logInternal(loggerConfig, message, arguments);
    }

    private void logInternal(PrettyMarker config, String message, Object... arguments) {
        switch (config.getLevel()) {
            case ERROR:
                this.slf4jLogger.error(config.getMarker(), message, arguments);
                break;
            case WARN:
                this.slf4jLogger.warn(config.getMarker(), message, arguments);
                break;
            case INFO:
                this.slf4jLogger.info(config.getMarker(), message, arguments);
                break;
            case DEBUG:
                this.slf4jLogger.debug(config.getMarker(), message, arguments);
                break;
            case TRACE:
                this.slf4jLogger.trace(config.getMarker(), message, arguments);
                break;
        }
    }
}
