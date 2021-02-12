package com.example.restaurant_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_recyclerview.controller.RestaurantActivity;
import com.example.restaurant_recyclerview.model.Restaurant;
import com.example.restaurant_recyclerview.model.RestaurantData;

import java.util.List;

public class RestaurantListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RestaurantAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_container);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(divider);

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        if(mAdapter == null) {
            mAdapter = new RestaurantAdapter();
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class RestaurantHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Restaurant mRestaurant;
        private TextView mNameTextView;
        private int mViewPosition;

        public RestaurantHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_restaurant, parent, false));
            itemView.setOnClickListener(this);
            mNameTextView = (TextView) itemView.findViewById(R.id.restaurant_name);
        }

        public void bind(Restaurant restaurant, int viewPosition) {
            mRestaurant = restaurant;
            mViewPosition = viewPosition;
            mNameTextView.setText(mRestaurant.getName());

        }

        @Override
        public void onClick(View v) {
//            Toast.makeText(getActivity(), Integer.toString(mViewPosition), Toast.LENGTH_SHORT).show();
            Intent intent = RestaurantActivity.newIntent(getContext(), mViewPosition);
            startActivity(intent);
        }
    }

    private class RestaurantAdapter extends RecyclerView.Adapter<RestaurantHolder> {

        private List<Restaurant> mRestaurants;
        public RestaurantAdapter() {
            mRestaurants = RestaurantData.get(getActivity()).getRestaurants();
        }
        @NonNull
        @Override
        public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RestaurantHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RestaurantHolder holder, int position) {
            Restaurant restaurant = mRestaurants.get(position);
            holder.bind(restaurant, position);
        }

        @Override
        public int getItemCount() {
            return mRestaurants.size();
        }
    }


}
