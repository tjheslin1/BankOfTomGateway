package io.github.tjheslin1.esb.jetty;

import io.github.tjheslin1.esb.settings.Settings;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

public class BankingEventServer {

    private Server server;

    public BankingEventServer(Settings settings) {
        this.server = new Server(settings.serverPort());
    }

    public void setHandler(ContextHandler handler) {
        server.setHandler(handler);
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}
