package com.webapp.gwtapp.client.start;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.webapp.gwtapp.client.ClientFactory;
import com.webapp.gwtapp.client.activity.StartPlace;
import com.webapp.gwtapp.client.activity.UserPlace;

public class StartActivity extends AbstractActivity implements StartView.Presenter {

    private final ClientFactory clientFactory;

    public StartActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        StartView startView = clientFactory.getStartView();
        startView.setPresenter(this);
        panel.setWidget(startView);
    }


    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(new UserPlace());
    }
}