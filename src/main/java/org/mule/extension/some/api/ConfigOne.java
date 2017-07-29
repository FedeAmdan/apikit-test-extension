package org.mule.extension.some.api;

import org.mule.runtime.extension.api.annotation.Operations;

@Operations(ConfigOneOperations.class)
public class ConfigOne {

    public static final ThreadLocal<String> taskTokenInThread = new ThreadLocal<>();
}
