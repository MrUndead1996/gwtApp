package com.webapp.gwtapp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.webapp.gwtapp.client.start.StartView;
import com.webapp.gwtapp.client.start.StartWidget;
import com.webapp.gwtapp.client.users.UserView;
import com.webapp.gwtapp.client.users.UserWidget;

public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = GWT.create(SimpleEventBus.class);
    private final PlaceController placeController = new PlaceController(eventBus);
    private final StartView startView = new StartWidget();
    private final UserView userView = new UserWidget();

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public StartView getStartView() {
        return startView;
    }

    @Override
    public UserView getUserView() {
        return userView;
    }
}
