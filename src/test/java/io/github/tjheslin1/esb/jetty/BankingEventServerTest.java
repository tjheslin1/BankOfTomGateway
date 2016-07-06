package io.github.tjheslin1.esb.jetty;

import io.github.tjheslin1.WithMockito;
import io.github.tjheslin1.esb.settings.Settings;
import io.github.tjheslin1.esb.settings.TestSettings;
import org.assertj.core.api.WithAssertions;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

public class BankingEventServerTest implements WithAssertions, WithMockito {

    private Settings settings = new TestSettings();
    private BankingEventServer server;

    @Before
    public void startServer() throws Exception {
        server = new BankingEventServer(settings);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.addServlet(DepositServlet.class, "/deposit");

        server.setHandler(context);
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
    public void testGet() throws Exception {
        HttpURLConnection http = (HttpURLConnection) new URL("http://localhost:8085/deposit").openConnection();
        http.connect();
        assertThat(http.getResponseCode()).isEqualTo(HttpStatus.OK_200);
    }
}