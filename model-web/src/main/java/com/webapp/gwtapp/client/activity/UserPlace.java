package com.webapp.gwtapp.client.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UserPlace extends Place {
    @Override
    public String toString() {
        return Links.USER;
    }

    public static class Tokenizer implements PlaceTokenizer<UserPlace> {
        @Override
        public String getToken(UserPlace place) {
            return place.toString();
        }

        @Override
        public UserPlace getPlace(String token) {
            return new UserPlace();
        }
    }
}
