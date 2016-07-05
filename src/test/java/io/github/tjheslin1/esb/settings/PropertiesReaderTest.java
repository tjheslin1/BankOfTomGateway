package io.github.tjheslin1.esb.settings;

import io.github.tjheslin1.WithMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class PropertiesReaderTest implements WithAssertions, WithMockito {

    @Test
    public void readProperty() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader("localhost");

        assertThat(propertiesReader.readProperty("server.port")).isEqualTo("8085");
    }
}