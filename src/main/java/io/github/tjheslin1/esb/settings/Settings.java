package io.github.tjheslin1.esb.settings;

public class Settings implements ServerSettings {

    private PropertiesReader propertiesReader;

    public Settings(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
    }

    public int serverPort() {
        return Integer.parseInt(propertiesReader.readProperty("server.port"));
    }
}
