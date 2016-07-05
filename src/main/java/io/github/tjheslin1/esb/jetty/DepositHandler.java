package io.github.tjheslin1.esb.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_OK;

public class DepositHandler extends AbstractHandler {

    @Override
    public void handle(String message, Request request, HttpServletRequest httpServletRequest, HttpServletResponse response)
            throws IOException, ServletException {
        response.setStatus(SC_OK);

        request.setHandled(true);
    }
}
