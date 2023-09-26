package com.example.categorydetailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        try {
            // This gets the particular Detailed object we are displaying
            // In this case, it is a Food object.
            Food myFood = intent.getParcelableExtra("Chosen Food");
            // This page will display the specific Detailed data for what your app is showing.
            // Get references to the xml views for name, price, desc, and photo
            String name = myFood.getName();
            String description = myFood.getDesc();
            double price = myFood.getPrice();
            int photo = myFood.getImageResourceID();

            TextView nameTV = findViewById(R.id.nameView);
            TextView priceTV = findViewById(R.id.priceView);
            TextView descripTV = findViewById(R.id.descripView);
            ImageView imageTV = findViewById(R.id.imageView);

            nameTV.setText(name);
            priceTV.setText("$" + price);
            descripTV.setText(description);
            imageTV.setImageResource(photo);


            // set values on the screen based on the object that was passed to this Detail activity
            if (myFood.getImageResourceID() == 0) {
                // set a default pic or decide what to do in this case.
            }
            else {
                imageTV.setImageResource(myFood.getImageResourceID());
            }
        }
        catch (Exception e) {
            Log.i("Denna", "Food app not working!");
        }

    }
}