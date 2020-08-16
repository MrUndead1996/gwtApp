package com.webapp.gwtapp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.webapp.gwtapp.model.User;

import java.util.List;

@RemoteServiceRelativePath("userList")
public interface UserList extends RemoteService {
    List<User> getUserList(boolean reverse);
}
