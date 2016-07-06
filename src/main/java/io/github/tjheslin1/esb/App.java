package io.github.tjheslin1.esb;

//import io.github.tjheslin1.esb.jetty.BankingEventServer;
//import io.github.tjheslin1.esb.jetty.DepositServlet;
import io.github.tjheslin1.esb.settings.PropertiesReader;
import io.github.tjheslin1.esb.settings.Settings;

public class App {

    public static void main(String[] args) throws Exception {
        Settings settings = new Settings(new PropertiesReader("localhost"));

//        BankingEventServer bankingEventServer = new BankingEventServer(settings)
//                .withContext("/deposit", new DepositServlet());

//        bankingEventServer.start();
//        Thread.sleep(1000);
//        bankingEventServer.stop();
    }
}
