package com.example.categorydetailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listView,
                                    View itemView, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);


                // create an ArrayList of whatever type of data you are displaying in this app
                // In this particular app, everything is centralized around the Food class.
                ArrayList<Food> listData = new ArrayList<>();

                // the choices for the menu on MainActivity coincide with the values in arr in strings.xml file
                if (position == 0) {        		  	// they chose breakfast
                    for (Food f: Food.Breakfast) {      // add all the elements for this array to the arraylist
                        listData.add(f);
                    }
                }

                else if (position == 1) {
                    for (Food f: Food.Lunch) { 		// they chose lunch
                        listData.add(f);
                    }
                }

                else if (position == 2) {
                    for (Food f: Food.Dinner) { 		// they chose dinner
                        listData.add(f);
                    }
                }

                // Send this particular ArrayList of Food data to the next activity, where we display
                // each name of each object in the ArrayList.
                intent.putParcelableArrayListExtra("Array Values", listData);
                startActivity(intent);
            }
        };
//Get a reference to the ListView in the XML
        ListView listView = (ListView) findViewById(R.id.list_options);


//Add the listener to the ListView
// without this line of code, the listView isn’t interactive!!!!
        listView.setOnItemClickListener(itemClickListener);

    }


}