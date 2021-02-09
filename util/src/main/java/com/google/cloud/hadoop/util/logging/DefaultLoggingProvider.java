package com.google.cloud.hadoop.util.logging;

import java.util.Map;

public class DefaultLoggingProvider extends CustomLogger {
    public void log(FSOpType type, FSOpStatus status, String path, Map<String, String> additionalInfo) {
        // do nothing
    }
}
