package com.webapp.gwtapp.client.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StartPlace extends Place {
    @Override
    public String toString() {
        return Links.START;
    }

    public static class Tokenizer implements PlaceTokenizer<StartPlace> {
        @Override
        public String getToken(StartPlace place) {
            return place.toString();
        }

        @Override
        public StartPlace getPlace(String token) {
            return new StartPlace();
        }
    }
}
