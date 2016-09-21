package io.github.tjheslin1.gateway.application.web;

public interface JsonUnmarshaller<Request> {

    Request unmarshall(String requestBody);
}
