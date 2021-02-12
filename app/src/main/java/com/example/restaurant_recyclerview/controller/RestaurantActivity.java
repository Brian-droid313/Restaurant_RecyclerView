package com.example.restaurant_recyclerview.controller;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.restaurant_recyclerview.RestaurantFragment;

public class RestaurantActivity extends SingleFragmentActivity {

    private static String EXTRA_RESTAURANT_POS = "restaurant_position";

    @Override
    public Fragment createFragment() {

        int restaurantNum = getIntent().getIntExtra(EXTRA_RESTAURANT_POS, 0);
        return RestaurantFragment.newInstance(restaurantNum);
    }

    public static Intent newIntent(Context context, int restaurantPos) {
        Intent intent = new Intent(context, RestaurantActivity.class);
        intent.putExtra(EXTRA_RESTAURANT_POS, restaurantPos);
        return intent;
    }
}