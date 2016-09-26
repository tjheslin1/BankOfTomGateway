package io.github.tjheslin1.gateway.application.web;

public interface JsonMarshaller<T> {

    String marshall(T t);
}
