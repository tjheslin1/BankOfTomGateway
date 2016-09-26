package io.github.tjheslin1.acceptance;

import io.github.theangrydev.yatspecfluent.Given;
import io.github.tjheslin1.gateway.application.probe.Probe;
import io.github.tjheslin1.gateway.application.usecases.StatusUseCase;
import io.github.tjheslin1.gateway.infrastructure.application.web.status.StatusResponseJsonMarshaller;
import io.github.tjheslin1.gateway.infrastructure.application.web.status.StatusServlet;
import org.eclipse.jetty.servlet.ServletHolder;

import static java.util.Collections.singletonList;

public class GivenTheStatusPage implements Given {

    private final TestInfrastructure testInfrastructure;

    public GivenTheStatusPage(TestInfrastructure testInfrastructure) {
        this.testInfrastructure = testInfrastructure;
    }

    public GivenTheStatusPage containsProbe(Probe probe) {
        testInfrastructure.eventServerBuilder().withServlet(statusServletWithProbe(probe), "/path");
        return this;
    }

    private ServletHolder statusServletWithProbe(Probe probe) {
        return new ServletHolder(new StatusServlet(new StatusUseCase(singletonList(probe)), new StatusResponseJsonMarshaller()));
    }

    @Override
    public void prime() {

    }
}
