package io.github.tjheslin1.esb.jetty;

import io.github.tjheslin1.esb.settings.Settings;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;

public class BankingEventServer {

    private Server server;

    public BankingEventServer(Settings settings) {
        server = new Server(settings.serverPort());
    }

    public BankingEventServer withContext(String path, AbstractHandler abstractHandler) {
        ContextHandler contextHandler = new ContextHandler(path);
        contextHandler.setHandler(abstractHandler);

        server.setHandler(contextHandler);
        return this;
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}
