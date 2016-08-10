package io.github.tjheslin1.esb.infrastructure.domain.eventstore;

import io.github.tjheslin1.WithMockito;
import io.github.tjheslin1.esb.infrastructure.application.web.DepositRequest;
import io.github.tjheslin1.esb.jetty.DepositServlet;
import io.github.tjheslin1.esb.settings.Settings;
import org.assertj.core.api.WithAssertions;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.String.format;

public class BankingEventServerTest implements WithAssertions, WithMockito {

    private Settings settings = mock(Settings.class);
    private DepositServlet depositServlet = mock(DepositServlet.class);

    private BankingEventServer server;

    @Before
    public void startServer() throws Exception {
        when(settings.host()).thenReturn("localhost");
        when(settings.serverPort()).thenReturn(8086);

        server = new BankingEventServer(settings);
        server.withServlet(depositServlet, "/deposit");

        server.start();
    }

    @After
    public void stopJetty() {
        try {
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() throws Exception {
        URL url = new URL(format("http://%s:%s/deposit", settings.host(), settings.serverPort()));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        connection.setRequestProperty("Content-Type", "application/json");

        connection.getOutputStream().write(new DepositRequest(7, 45.0).toJson().getBytes("UTF-8"));

        connection.connect();
        assertThat(connection.getResponseCode()).isEqualTo(HttpStatus.OK_200);
    }
}