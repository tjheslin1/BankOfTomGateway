package io.github.tjheslin1.gateway;

import io.github.tjheslin1.gateway.infrastructure.application.probe.DepositAggregateProbe;
import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequestJsonUnmarshaller;
import io.github.tjheslin1.gateway.jetty.DepositServlet;
import io.github.tjheslin1.gateway.settings.Settings;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Wiring {

    public final Settings settings;

    public Wiring(Settings settings) {
        this.settings = settings;
    }

    public ServletContextHandler servletContextHandler() {
        return new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    }

    public DepositServlet depositServlet() {
        return new DepositServlet(new DepositRequestJsonUnmarshaller());
    }

    public DepositAggregateProbe depositAggregateProbe() {
        return new DepositAggregateProbe();
    }
}
