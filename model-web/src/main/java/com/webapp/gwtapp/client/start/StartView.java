package com.webapp.gwtapp.client.start;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface StartView extends IsWidget {
    void setPresenter(Presenter presenter);

     interface Presenter {
        void goTo(Place place);
    }
}
