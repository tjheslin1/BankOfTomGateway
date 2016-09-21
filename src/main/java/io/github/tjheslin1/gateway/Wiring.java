package io.github.tjheslin1.gateway;

import io.github.tjheslin1.gateway.jetty.DepositServlet;
import io.github.tjheslin1.gateway.settings.Settings;

public class Wiring {

    public final Settings settings;

    public Wiring(Settings settings) {
        this.settings = settings;
    }


    public DepositServlet depositServlet() {
        return new DepositServlet(depositUseCase, unmarshaller);
    }
}
