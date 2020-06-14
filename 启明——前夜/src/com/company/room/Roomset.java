package com.company.room;

import java.util.ArrayList;

public class Roomset {
    ArrayList<Place> places = new ArrayList<Place>();


    public ArrayList<Place> getRooms() {
        return places;
    }

    public void setRooms(ArrayList<Place> places) {
        this.places = places;
    }

    public Place reachplacebyId(String placeid) {
        Place place = null;
        for (Place item : places) {
            if (placeid.equals(item.getPlaceid())) {
                place = item;
                break;
            }
        }

        return place;
    }

    public Place getplacebyid(String id) {
        Place place = null;
        for (Place item : places) {
            if (id.equals(item.getPlaceid())) {
                place = item;
            }
        }
        return place;
    }
}
