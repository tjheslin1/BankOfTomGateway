package io.github.tjheslin1.acceptance;

import io.github.tjheslin1.gateway.Wiring;
import io.github.tjheslin1.gateway.infrastructure.application.probe.DepositAggregateProbe;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

public class StatusTest extends AcceptanceTest<Request, Response> {

    private final Wiring wiring = new Wiring(testInfrastructure.settings());
    private final DepositAggregateProbe depositAggregateProbe = wiring.depositAggregateProbe();

    private final GivenTheStatusPage theStatusPage = new GivenTheStatusPage(testInfrastructure);

    @Test
    public void statusPageTest() throws Exception {
        given(theStatusPage.containsProbe(depositAggregateProbe));
//        when(theStatusPageIsChecked);
    }
}
