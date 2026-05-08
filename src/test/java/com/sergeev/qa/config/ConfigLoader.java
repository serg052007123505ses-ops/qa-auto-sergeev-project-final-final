package com.sergeev.qa.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigLoader {
    private static Config config;

    static {
        ConfigFactory.setProperty("org.aeonbits.owner.allowNestedExpansion", "false");
        config = ConfigFactory.create(Config.class);
    }

    public static Config getConfig() {
        return config;
    }
}