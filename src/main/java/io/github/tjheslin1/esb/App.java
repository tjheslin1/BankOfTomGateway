package io.github.tjheslin1.esb;

import io.github.tjheslin1.esb.infrastructure.jetty.BankingEventServer;
import io.github.tjheslin1.esb.jetty.DepositServlet;
import io.github.tjheslin1.esb.settings.PropertiesReader;
import io.github.tjheslin1.esb.settings.Settings;

public class App {

    public static void main(String[] args) throws Exception {
        Settings settings = new Settings(new PropertiesReader("localhost"));

        BankingEventServer bankingEventServer = new BankingEventServer(settings)
                .withContext(DepositServlet.class, "/deposit");

        bankingEventServer.start();
        Thread.sleep(1000);
        bankingEventServer.stop();
    }
}
