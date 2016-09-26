package io.github.tjheslin1.gateway.domain.status;

public enum Status {
    OK("OK"),
    FAIL("FAIL");

    public final String value;

    Status(String value) {
        this.value = value;
    }
}
