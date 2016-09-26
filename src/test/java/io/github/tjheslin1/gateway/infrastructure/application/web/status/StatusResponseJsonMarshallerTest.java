package io.github.tjheslin1.gateway.infrastructure.application.web.status;

import io.github.tjheslin1.WithMockito;
import io.github.tjheslin1.gateway.domain.status.ProbeResult;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static java.util.Collections.singletonList;

public class StatusResponseJsonMarshallerTest implements WithAssertions, WithMockito {

    private final StatusPageResult statusPageResult = mock(StatusPageResult.class);
    private final ProbeResult probeResult = mock(ProbeResult.class);

    private final StatusResponseJsonMarshaller marshaller = new StatusResponseJsonMarshaller();

    @Test
    public void rendersExpectedStatusPage() throws Exception {
        when(statusPageResult.probeResults()).thenReturn(singletonList(probeResult));
        when(statusPageResult.overallResult()).thenReturn("OK");

        assertThat(marshaller.marshall(statusPageResult)).isEqualTo("{ \"probes\": [{\"aggregateStatus\": \"OK\"}], \"overallStatus\": \"OK\"}");
    }
}