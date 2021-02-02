package com.google.cloud.hadoop.util.logging;

public abstract class CustomLoggingProvider {
    private static CustomLoggingProvider customLoggingProvider = null;

    public static synchronized void setCustomLoggingProvider(CustomLoggingProvider provider) {
        customLoggingProvider = provider;
    }

    public static CustomLoggingProvider getInstance() {
        if (customLoggingProvider != null)
            return customLoggingProvider;

        customLoggingProvider = new DefaultLoggingProvider();
        return customLoggingProvider;
    }

    public abstract void log(String logMessage);
}