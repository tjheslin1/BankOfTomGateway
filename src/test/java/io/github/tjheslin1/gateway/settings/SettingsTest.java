package io.github.tjheslin1.gateway.settings;

import io.github.tjheslin1.WithMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.Properties;

public class SettingsTest implements WithAssertions, WithMockito {

    @Test
    public void settingsFileReadFrom() throws Exception {
        Properties properties = mock(Properties.class);
        Settings settings = new Settings(properties);

        when(properties.getProperty("server.port")).thenReturn("1");

        assertThat(settings.serverPort()).isGreaterThan(0);
    }
}