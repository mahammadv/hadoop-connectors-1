package com.google.cloud.hadoop.util.logging;

import java.util.Map;

public abstract class CustomLogger {

    public enum FSOpType {
        Create,
        Delete,
        Mkdir,
        Rename
    }

    public enum FSOpStatus {
        STARTED,
        SUCCEEDED,
        PROGRESSING,
        FAILED,
        UNDEFINED
    }

    private static CustomLogger customLogger = null;

    public static synchronized void setCustomLoggingProvider(CustomLogger customLoggerObj) {
        customLogger = customLoggerObj;
    }

    public static synchronized CustomLogger getInstance() {
        if (customLogger != null)
            return customLogger;

        customLogger = new DefaultLoggingProvider();
        return customLogger;
    }

    public abstract void log(FSOpType type, FSOpStatus status, String path, Map<String, String> additionalInfo);
}