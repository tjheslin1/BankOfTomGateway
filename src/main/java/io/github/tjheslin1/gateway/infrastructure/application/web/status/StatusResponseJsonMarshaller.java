package io.github.tjheslin1.gateway.infrastructure.application.web.status;

import io.github.tjheslin1.gateway.application.web.JsonMarshaller;
import io.github.tjheslin1.gateway.domain.status.ProbeResult;

import java.util.stream.Collectors;

import static java.lang.String.format;

public class StatusResponseJsonMarshaller implements JsonMarshaller<StatusPageResult> {

    private static final String STATUS_PAGE_FORMAT = "{ \"probes\": [%s], \"overallStatus\": \"%s\"}";

    @Override
    public String marshall(StatusPageResult statusPageResult) {
        String probesJson = statusPageResult.probeResults().stream().map(ProbeResult::toJson).collect(Collectors.joining(", "));

        return format(STATUS_PAGE_FORMAT, probesJson, statusPageResult.overallResult());
    }
}
