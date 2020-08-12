package com.webapp.gwtapp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwtappService")
public interface gwtappService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use gwtappService.App.getInstance() to access static instance of gwtappServiceAsync
     */
    public static class App {
        private static gwtappServiceAsync ourInstance = GWT.create(gwtappService.class);

        public static synchronized gwtappServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
