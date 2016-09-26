package io.github.tjheslin1.gateway.domain.status;

public interface ProbeResult {

    Status result();
    String toJson();
}
