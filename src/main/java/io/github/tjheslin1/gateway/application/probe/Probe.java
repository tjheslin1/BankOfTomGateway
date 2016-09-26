package io.github.tjheslin1.gateway.application.probe;

import io.github.tjheslin1.gateway.domain.status.ProbeResult;

public interface Probe {

    ProbeResult probe();
}
