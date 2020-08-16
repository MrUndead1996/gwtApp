package com.webapp.gwtapp.client.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({StartPlace.Tokenizer.class, UserPlace.Tokenizer.class})
public class AppPlaceMapper implements AppPlaceHistoryMapper {
    @Override
    public Place getPlace(String token) {
        if (Links.START.equals(token)) {
            return new StartPlace();
        }
        if (Links.USER.equals(token)) {
            return new UserPlace();
        }
        return null;
    }
    @Override
    public String getToken(Place place) {
        return place.toString();
    }
}
