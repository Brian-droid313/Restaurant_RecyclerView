package com.example.restaurant_recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurant_recyclerview.model.Restaurant;
import com.example.restaurant_recyclerview.model.RestaurantData;

public class RestaurantFragment extends Fragment {
    private Restaurant mRestaurant;

    private TextView mRestaurantName;
    private TextView mRestaurantAddress;
    private TextView mRating;
    private Button mButton;

    private static String ARG_RESTAURANT_NUM = "arg_restaurant_num";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int restaurantPosition = getArguments().getInt(ARG_RESTAURANT_NUM);
        mRestaurant = RestaurantData.get(getActivity()).getRestaurant(restaurantPosition);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        mRestaurantName = (TextView) view.findViewById(R.id.restaurant_name);
        mRestaurantName.setText(mRestaurant.getName());

        mRestaurantAddress = (TextView) view.findViewById(R.id.restaurant_address);
        mRestaurantAddress.setText(mRestaurant.getAddress());

        mRating = (TextView) view.findViewById(R.id.restaurant_rating);
        mRating.setText(Integer.toString(mRestaurant.getRating()));

        mButton = (Button) view.findViewById(R.id.url_button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(mRestaurant.getWebsite());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public static Fragment newInstance(int restaurantNum) {
        Bundle args = new Bundle();
        args.putInt(ARG_RESTAURANT_NUM, restaurantNum);

        Fragment fragment = new RestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
