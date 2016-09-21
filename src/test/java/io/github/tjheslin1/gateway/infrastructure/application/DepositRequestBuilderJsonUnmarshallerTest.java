package io.github.tjheslin1.gateway.infrastructure.application;

import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequest;
import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequestJsonUnmarshaller;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class DepositRequestBuilderJsonUnmarshallerTest implements WithAssertions {

    private DepositRequestJsonUnmarshaller unmarshaller = new DepositRequestJsonUnmarshaller();

    @Test
    public void unmarshallsDepositRequest() {
        String exampleRequest = "{ \"accountId\": \"7\", \"amount\": \"50.0\"}";

        DepositRequest actualRequest = unmarshaller.unmarshall(exampleRequest);

        DepositRequest expectedRequest = new DepositRequest(7, 50.0);

        assertThat(actualRequest).isEqualTo(expectedRequest);
    }
}