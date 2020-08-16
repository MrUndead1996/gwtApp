package com.webapp.gwtapp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.webapp.gwtapp.client.start.StartView;
import com.webapp.gwtapp.client.users.UserView;

public interface ClientFactory {
    EventBus getEventBus();
    PlaceController getPlaceController();
    StartView getStartView();
    UserView getUserView();
}
