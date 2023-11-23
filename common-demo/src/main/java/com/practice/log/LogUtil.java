package com.practice.log;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

public class LogUtil {

    private static final String LOG_UUID = "LOG_UUID";

    public LogUtil() {
    }

    public static void updateLogId(String logID) {
        if(StringUtils.isBlank(logID)) {
            MDC.put("LOG_UUID", createLogId());
        } else {
            MDC.put("LOG_UUID", logID);
        }

    }

    public static String createLogId() {
        return UUID.randomUUID().toString();
    }

    public static String getLogId() {
        String object = MDC.get("LOG_UUID");
        return object == null?null:object.toString();
    }
}
