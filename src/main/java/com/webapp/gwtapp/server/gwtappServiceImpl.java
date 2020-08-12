package com.webapp.gwtapp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.webapp.gwtapp.client.gwtappService;

public class gwtappServiceImpl extends RemoteServiceServlet implements gwtappService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}