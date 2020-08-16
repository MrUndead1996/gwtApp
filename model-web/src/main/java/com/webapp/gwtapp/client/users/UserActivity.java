package com.webapp.gwtapp.client.users;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.webapp.gwtapp.client.ClientFactory;
import com.webapp.gwtapp.client.UserList;
import com.webapp.gwtapp.client.UserListAsync;

public class UserActivity extends AbstractActivity {
    private final UserListAsync userListAsync = GWT.create(UserList.class);
    private final ClientFactory clientFactory;

    public UserActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        UserView userView = clientFactory.getUserView();
        panel.setWidget(userView);
    }
}