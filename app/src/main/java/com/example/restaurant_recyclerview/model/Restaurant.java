package com.example.restaurant_recyclerview.model;

public class Restaurant {
    private String mName;
    private String mAddress;
    private int mRating;
    private String mWebsite;

    Restaurant(String name, String address, int rating, String website) {
        mName = name;
        mAddress = address;
        mRating = rating;
        mWebsite = website;
    }


    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getRating() {
        return mRating;
    }

    public String getWebsite() {
        return mWebsite;
    }
}
