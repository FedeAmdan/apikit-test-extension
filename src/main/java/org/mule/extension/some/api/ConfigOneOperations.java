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

        if (config.taskTokenInThread.get() != null) {
            requestTaskToken = config.taskTokenInThread.get();
            logger.info("request: token WAS NOT empty");
        } else {
            requestTaskToken = generateTaskToken();
            config.taskTokenInThread.set(requestTaskToken);
            logger.info("request: token WAS empty");
        }
        logger.info("request token: " + requestTaskToken);
        logger.info("request info to log: " + infoToLog);
    }

    public void operationPostRouter(@Config ConfigOne config, String infoToLog)
    {
        String responseTaskToken;
        if (config.taskTokenInThread.get() != null) {
            responseTaskToken = config.taskTokenInThread.get();
            logger.info("response: token in thread WAS NOT empty");
        } else {
            responseTaskToken = generateTaskToken();
            logger.info("response: token in thread WAS empty");
        }
        logger.info("response token: " + responseTaskToken);
        logger.info("response info to log: " + infoToLog);

    }

    protected String generateTaskToken() {
        return currentThread().getName() + " - " + UUID.getUUID().toString();
    }

}
