package com.webapp.gwtapp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.webapp.gwtapp.client.activity.AppActivityMapper;
import com.webapp.gwtapp.client.activity.AppPlaceHistoryMapper;
import com.webapp.gwtapp.client.activity.AppPlaceMapper;
import com.webapp.gwtapp.client.activity.StartPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class WebApp implements EntryPoint {

    private final Place startPlace = new StartPlace();
    private final SimplePanel appWidget = new SimplePanel();

    public void onModuleLoad() {
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, startPlace);
        RootPanel.get().add(appWidget);
        historyHandler.handleCurrentHistory();
    }

}
