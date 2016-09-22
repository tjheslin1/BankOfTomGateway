package io.github.tjheslin1.gateway.infrastructure.application.web;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static java.lang.String.format;

public class DepositRequestTest implements WithAssertions {

    private static final int ACCOUNT_ID = 67;
    private static final double AMOUNT = 50.0;


    private DepositRequest depositRequest= new DepositRequest(ACCOUNT_ID, AMOUNT);

    @Test
    public void formatsJsonCorrectly() throws Exception {
        String expectedJson = format("{ \"accountId\": \"%s\", \"amount\": \"%s\" }", ACCOUNT_ID, AMOUNT);

        assertThat(depositRequest.toJson()).isEqualTo(expectedJson);
    }
}