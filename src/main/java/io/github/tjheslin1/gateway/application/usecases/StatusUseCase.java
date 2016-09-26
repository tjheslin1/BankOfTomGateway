package io.github.tjheslin1.gateway.application.usecases;

import io.github.tjheslin1.gateway.application.probe.Probe;
import io.github.tjheslin1.gateway.domain.status.ProbeResult;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StatusUseCase {

    private final List<Probe> probes;

    public StatusUseCase(List<Probe> probes) {
        this.probes = probes;
    }

    public List<ProbeResult> checkStatusProbes() {
        return probes.stream().map(Probe::probe).collect(toList());
    }
}
