package com.webapp.gwtapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.webapp.gwtapp.model.User;

import java.util.List;

public interface UserListAsync {
    void getUserList(boolean reverse, AsyncCallback<List<User>> async);
}
