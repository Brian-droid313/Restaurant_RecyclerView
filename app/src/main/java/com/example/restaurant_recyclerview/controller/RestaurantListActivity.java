package com.example.restaurant_recyclerview.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.restaurant_recyclerview.R;
import com.example.restaurant_recyclerview.RestaurantListFragment;

public class RestaurantListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new RestaurantListFragment();
    }
}