package com.webapp.gwtapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface gwtappServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
