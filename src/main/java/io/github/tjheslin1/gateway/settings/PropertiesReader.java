package io.github.tjheslin1.gateway.settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public class PropertiesReader {

    private final String environment;
    private Properties properties;

    public PropertiesReader(String environment) {
        this.environment = environment;
        this.properties = new Properties();

        loadProperties();
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName())) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read file: " + propertiesFileName());
        }
    }

    private String propertiesFileName() {
        return format("%s.properties", environment);
    }
}
