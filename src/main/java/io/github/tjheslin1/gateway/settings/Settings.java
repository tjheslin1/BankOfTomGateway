package io.github.tjheslin1.gateway.settings;

import java.util.Properties;

public class Settings implements ServerSettings {

    private final Properties properties;

    public Settings(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String host() {
        return properties.getProperty("host");
    }

    @Override
    public int serverPort() {
        return Integer.parseInt(properties.getProperty("server.port"));
    }
}
