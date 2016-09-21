package io.github.tjheslin1.gateway.jetty;

import io.github.tjheslin1.WithMockito;
import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequestJsonUnmarshaller;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class DepositServletTest implements WithAssertions, WithMockito {

    private final DepositRequestJsonUnmarshaller unmarshaller = mock(DepositRequestJsonUnmarshaller.class);

    private final DepositServlet depositServlet = new DepositServlet(unmarshaller);

    @Test
    public void callledSuccessfullyAndReturns200() throws Exception {
//        depositServlet.
    }
}