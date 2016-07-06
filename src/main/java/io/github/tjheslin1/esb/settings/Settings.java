package io.github.tjheslin1.esb.settings;

public class Settings implements ServerSettings {

    private PropertiesReader propertiesReader;

    public Settings(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
    }

    @Override
    public String webProtocol() {
        return propertiesReader.readProperty("web.protocol");
    }

    @Override
    public String host() {
        return propertiesReader.readProperty("host");
    }

    @Override
    public int serverPort() {
        return Integer.parseInt(propertiesReader.readProperty("server.port"));
    }
}
