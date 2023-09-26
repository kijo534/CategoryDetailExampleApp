package com.example.categorydetailapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
/*
Here is a cheat sheet to make an object parcelable or able to be sent through an intent
1. Implements Parcelable on a class header
2. default constructor (on with no parameters)
3. constructor that tells Java how to read the Parcel to create an object
4. writeToParcel method tells java how to send the parcel
5. Creator method - replace Food with the name of your class
6. need the describeContents method which we arent modifying.
 */

public class Food implements Parcelable {
    private String name;
    private String desc;
    private double price;
    private int imageResourceID;

    public static final Food[] Breakfast = {
            new Food("Bacon", "Perfectly Crunchy", 5.99, R.drawable.bacon),

            new Food("Bagel", "Bagel with Cream Cheese", 3.99, R.drawable.bagel),

            new Food("Eggs", "Puffy Light Eggs", 4.99, R.drawable.eggs)
    };

    public static final Food[] Lunch = {
            new Food("Burger", "Double Cheeseburger", 7.99, R.drawable.burger),

            new Food("French Fries", "Very Crispy French Fries", 4.99, R.drawable.fries),

            new Food("Meatball Sub", "Marinara sauce and Meatball", 6.99, R.drawable.meatball),
    };
    public static final Food[] Dinner = {
            new Food("Steak", "Medium Rare Steak", 17.99, R.drawable.steak),
            new Food("Sushi", "Crab Sushi Rolls", 12.99, R.drawable.sushi),
            new Food("Curry", "Tonkatsu Curry", 11.99, R.drawable.curry)
    };



    //Constructor
    public Food(String name, String desc, double price, int imageResourceID) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imageResourceID = imageResourceID;
    }

    @Override
    public String toString() {
        return name;
    }

    // A default constructor is required for the Parcelable interface to work
    //if you forget this default constructor you cannot use this object as intended
    //even if you never use this specifically. THIS IS REQUIRED
    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }
    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
            *
            *The order of the read method matters. Whatever the order is, it needs to stay consistent.
            * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }



    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     * The order that each variable is packed, in the write method, MUST be the same
     * as the oder that it is unpacked,in the read method, in the constructor
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(desc);
        dest.writeInt(imageResourceID);
    }


    // this code is needed for the Food class to work with Parcelable
    // This code needs no changes other than replacing the word "food" for another class
    // if you were to implement parcelable in another class
    public static final Parcelable.Creator<Food> CREATOR = new
            Parcelable.Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };


    /**
     * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
    }



    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }
}
