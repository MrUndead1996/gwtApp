package com.webapp.gwtapp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.webapp.gwtapp.client.UserList;
import com.webapp.gwtapp.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserListImpl extends RemoteServiceServlet implements UserList {

    @Override
    public List<User> getUserList(boolean reverse) {
        List<User> users = new ArrayList<>(50);
        for (int i = 1;i <= 50;i++){
            User user = new User();
            user.setId((long)i);
            user.setLogin("login" + i);
            user.setName("name" + i);
            user.setDescription("description" + i);
            users.add(user);
        }
        if (!reverse)
            Collections.reverse(users);
        return users;
    }
}
