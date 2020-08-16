package com.webapp.gwtapp.client.activity;


import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.webapp.gwtapp.client.ClientFactory;
import com.webapp.gwtapp.client.start.StartActivity;
import com.webapp.gwtapp.client.users.UserActivity;

public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }


    @Override
    public Activity getActivity(Place place) {
        if (place instanceof StartPlace)
            return new StartActivity(clientFactory);
        else if (place instanceof UserPlace)
            return new UserActivity(clientFactory);

        return null;
    }
}
