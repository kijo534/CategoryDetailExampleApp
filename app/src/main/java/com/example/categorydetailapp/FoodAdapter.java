package com.example.categorydetailapp;

import android.content.Context;
import android.security.identity.IdentityCredential;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
        public FoodAdapter(Context context, ArrayList<Food> foodList) {
            super(context, 0, foodList);
        }
        // method tells us how to setup one row of a list view

        public View getView(int position, View convertView, ViewGroup parent) {
            Food myFood = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.foodrowlayout, parent, false);
            }
            // Step 1: Connect XML references for YOUR custom view
            TextView name = convertView.findViewById(R.id.nameText);
            TextView description = convertView.findViewById(R.id.descriptionView);
            TextView price  = convertView.findViewById(R.id.pView);
            // Step 2: Populate the specific row data into the variables you made in step 1
            name.setText(myFood.getName());
            price.setText("$" + myFood.getPrice());
            description.setText(myFood.getDesc());
            // Step 3: Return the completed view to render on screen
            return convertView;
        }
    }



