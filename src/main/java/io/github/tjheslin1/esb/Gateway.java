package io.github.tjheslin1.esb;

import io.github.tjheslin1.esb.infrastructure.domain.eventstore.BankingEventServer;
import io.github.tjheslin1.esb.jetty.DepositServlet;
import io.github.tjheslin1.esb.settings.PropertiesReader;
import io.github.tjheslin1.esb.settings.Settings;

public class Gateway {

    public static void main(String[] args) throws Exception {
        Settings settings = new Settings(new PropertiesReader("localhost"));

        // TODO move new up of DepositServlet into Wiring
        BankingEventServer bankingEventServer = new BankingEventServer(settings)
                .withServlet(new DepositServlet(), "/deposit");

        bankingEventServer.start();
        Thread.sleep(1000);
        bankingEventServer.stop();
    }
}
