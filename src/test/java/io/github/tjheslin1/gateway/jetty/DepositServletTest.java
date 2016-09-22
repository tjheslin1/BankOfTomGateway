package io.github.tjheslin1.gateway.jetty;

import io.github.tjheslin1.WithMockito;
import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequest;
import io.github.tjheslin1.gateway.infrastructure.application.web.DepositRequestJsonUnmarshaller;
import org.assertj.core.api.WithAssertions;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

import static java.lang.String.format;

public class DepositServletTest implements WithAssertions, WithMockito {

    private static final int ACCOUNT_ID = 78;
    private static final double AMOUNT = 1249.9;

    private final HttpServletRequest request = mock(HttpServletRequest.class);
    private final HttpServletResponse response = mock(HttpServletResponse.class);
    private final BufferedReader bufferedReader = mock(BufferedReader.class);
    private final DepositRequestJsonUnmarshaller unmarshaller = mock(DepositRequestJsonUnmarshaller.class);
    private final DepositRequest depositRequest = mock(DepositRequest.class);

    private final DepositServlet depositServlet = new DepositServlet(unmarshaller);

    @Before
    public void before() throws IOException {
        String requestBody = format("{ \"accountId\": \"%s\", \"amount\": \"%s\" }", ACCOUNT_ID, AMOUNT);

        when(request.getReader()).thenReturn(bufferedReader);
        when(bufferedReader.lines()).thenReturn(Stream.of(requestBody));

        when(unmarshaller.unmarshall(requestBody)).thenReturn(depositRequest);
    }

    @Test
    public void calledSuccessfullyAndReturns200() throws Exception {
        depositServlet.doPost(request, response);

        verify(response).setContentType("application/json");
        verify(response).setStatus(HttpServletResponse.SC_OK);
    }
}