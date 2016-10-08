package io.github.tjheslin1.acceptance;

import io.github.theangrydev.yatspecfluent.ThenFactory;
import io.github.tjheslin1.acceptance.givens.GivenTheStatusPage;
import io.github.tjheslin1.acceptance.testinfrastructure.RequestFormatter;
import io.github.tjheslin1.acceptance.testinfrastructure.ResponseFormatter;
import io.github.tjheslin1.acceptance.thens.ThenTheResponse;
import io.github.tjheslin1.acceptance.whens.WhenTheStatusPageIsChecked;
import io.github.tjheslin1.gateway.Wiring;
import io.github.tjheslin1.gateway.infrastructure.application.probe.DepositAggregateProbe;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Ignore;
import org.junit.Test;

public class StatusTest extends AcceptanceTest<Request, Response> {

    private final Wiring wiring = new Wiring(testInfrastructure.settings());
    private final DepositAggregateProbe depositAggregateProbe = wiring.depositAggregateProbe();

    private final GivenTheStatusPage theStatusPage = new GivenTheStatusPage(testInfrastructure);
    private final WhenTheStatusPageIsChecked theStatusPageIsChecked = new WhenTheStatusPageIsChecked(this, testInfrastructure, "Gateway",
            new RequestFormatter(), new ResponseFormatter());
    private final ThenFactory<ThenTheResponse, Response> theResponse = ThenTheResponse::new;

    @Test
    public void statusPageTest() throws Exception {
        given(theStatusPage.containsProbe(depositAggregateProbe));
        when(theStatusPageIsChecked);
        then(theResponse).willReturn().withResponseCode(200);
    }
}
