package org.mule.extension.some.api;


import org.mule.runtime.core.api.util.UUID;
import org.mule.runtime.extension.api.annotation.param.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.currentThread;


public class ConfigOneOperations {
    protected static final Logger logger = LoggerFactory.getLogger(ConfigOneOperations.class);

    public void operationPreRouter(@Config ConfigOne config, String infoToLog)
    {
        String requestTaskToken;
        String log= "";
        if (config.taskTokenInThread.get() != null) {
            requestTaskToken = config.taskTokenInThread.get();
            log += "=== Request: token WAS NOT empty";
        } else {
            requestTaskToken = generateTaskToken();
            config.taskTokenInThread.set(requestTaskToken);
            log += "=== Request: token WAS empty";
        }
        log += " // token: " + requestTaskToken;
        log += " // info to log: " + infoToLog;
        logger.info(log);
    }

    public void operationPostRouter(@Config ConfigOne config, String infoToLog)
    {
        String responseTaskToken;
        String log = "";
        if (config.taskTokenInThread.get() != null) {
            responseTaskToken = config.taskTokenInThread.get();
            log += "=== Response: token in thread WAS NOT empty";
        } else {
            responseTaskToken = generateTaskToken();
            log += "=== Response: token in thread WAS empty";
        }
        log += " // token: " + responseTaskToken;
        log += " // info to log: " + infoToLog;
        logger.info(log);

    }

    protected String generateTaskToken() {
        return currentThread().getName() + " - " + UUID.getUUID().toString();
    }

}
