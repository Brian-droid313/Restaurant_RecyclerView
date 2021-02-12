package com.example.restaurant_recyclerview.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RestaurantData {
    private static RestaurantData mRestaurantData;
    private List<Restaurant> mRestaurants;

    public static RestaurantData get(Context context) {
        if(mRestaurantData == null) {
            mRestaurantData = new RestaurantData(context);
        }
        return  mRestaurantData;
    }
    private RestaurantData(Context context) {
        mRestaurants = new ArrayList<>();

        Restaurant restaurant1 = new Restaurant("Superdawg Drive-In", "6363 N Milwaukee Ave, Chicago, IL 60646", 5, "http://www.superdawg.com/" );
        Restaurant restaurant2 = new Restaurant("Smoque BBQ", "3800 N Pulaski Rd, Chicago, IL 60641", 5, "https://smoquebbq.com/" );
        Restaurant restaurant3 = new Restaurant("Parachute", "3500 N Elston Ave Chicago, IL 60618", 5, "https://www.parachuterestaurant.com/");
        Restaurant restaurant4 = new Restaurant("Honey Butter Fried Chicken", "3361 N Elston Ave, Chicago, IL 60618", 5, "https://www.honeybutter.com/");
        Restaurant restaurant5 = new Restaurant("Mi Tocaya Antojería", "2800 W Logan Blvd, Chicago, IL 60647",4, "https://www.mitocaya.com/");

        Restaurant restaurant6 = new Restaurant("Galit", "2429 N Lincoln Ave, Chicago, IL 60614", 5, "https://www.galitrestaurant.com/");
        Restaurant restaurant7 = new Restaurant("Paulie Gee's Logan Square", "2451 N Milwaukee Ave, Chicago, IL 60647",3, "https://pauliegee.com/logan-square/");
        Restaurant restaurant8 = new Restaurant("Jibaritos y Mas", "3400 W Fullerton Ave, Chicago, IL 60647", 2, "https://www.orderjibaritosymas.com/");
        Restaurant restaurant9 = new Restaurant("Pequod's Pizza", "2207 N Clybourn Ave, Chicago, IL 60614", 5, "https://pequodspizza.com/");
        Restaurant restaurant10 = new Restaurant("Rica Arepa Venezuelan Restaurant", "4253 W Armitage Ave, Chicago, IL 60639", 4, "https://www.ricaarepatogo.com/");

        mRestaurants.add(restaurant1);
        mRestaurants.add(restaurant2);
        mRestaurants.add(restaurant3);
        mRestaurants.add(restaurant4);
        mRestaurants.add(restaurant5);

        mRestaurants.add(restaurant6);
        mRestaurants.add(restaurant7);
        mRestaurants.add(restaurant8);
        mRestaurants.add(restaurant9);
        mRestaurants.add(restaurant10);


    }

    public Restaurant getRestaurant(int id) {
        return mRestaurants.get(id);
    }
    public List<Restaurant> getRestaurants() {
        return mRestaurants;
    }
}
