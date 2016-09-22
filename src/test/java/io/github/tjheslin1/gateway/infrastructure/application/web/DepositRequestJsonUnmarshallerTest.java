package io.github.tjheslin1.gateway.infrastructure.application.web;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static java.lang.String.format;

public class DepositRequestJsonUnmarshallerTest implements WithAssertions {

    private final DepositRequestJsonUnmarshaller unmarshaller = new DepositRequestJsonUnmarshaller();

    @Test
    public void unmarshallsRequest() throws Exception {
        int accountId = 9;
        double amount = 238.9;

        String request = format("{ \"accountId\": \"%s\", \"amount\": \"%s\" }", accountId, amount);
        DepositRequest depositRequest = unmarshaller.unmarshall(request);

        assertThat(depositRequest.accountId).isEqualTo(accountId);
        assertThat(depositRequest.amount).isEqualTo(amount);
    }
}