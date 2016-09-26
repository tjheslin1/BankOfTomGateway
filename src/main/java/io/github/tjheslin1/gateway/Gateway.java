package io.github.tjheslin1.gateway;

import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequestJsonUnmarshaller;
import io.github.tjheslin1.gateway.infrastructure.domain.eventstore.BankingEventServer;
import io.github.tjheslin1.gateway.infrastructure.domain.eventstore.BankingEventServerBuilder;
import io.github.tjheslin1.gateway.jetty.DepositServlet;
import io.github.tjheslin1.gateway.settings.Settings;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public class Gateway {

    public static void main(String[] args) throws Exception {
        String env = getPropertiesFileEnv();
        Properties properties = loadProperties(env);
        Settings settings = new Settings(properties);

        Wiring wiring = new Wiring(settings);

        DepositServlet depositServlet = new DepositServlet(new DepositRequestJsonUnmarshaller());
        BankingEventServer bankingEventServer = new BankingEventServerBuilder(wiring.servletContextHandler(), settings)
                .withServlet(new ServletHolder(depositServlet), "/deposit")
                .build();

        bankingEventServer.start();
        bankingEventServer.stop();
    }

    private static String getPropertiesFileEnv() {
        String env = System.getenv("bank-of-tom-env");
        if (env == null) {
            env = "localhost";
        }
        return env;
    }

    public static Properties loadProperties(String environment) {
        try (InputStream resourceAsStream = Gateway.class.getClassLoader().getResourceAsStream(propertiesFileName(environment))) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read file: " + propertiesFileName(environment));
        }
    }

    private static String propertiesFileName(String environment) {
        return format("%s.properties", environment);
    }
}
