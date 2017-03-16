package com.example.android.quakereport;

/**
 * Created by swati on 14/03/2017.
 */

public class Earthquake  {

    /**
     * Magnitude of the earthquake
     */
    private String mMagnitude;

    /**
     * Place where earthquake occured
     */
    private String mLocation;

    /**
     * Date of earthquake
     */
    private String mDate;

    public Earthquake(String magnitude, String place, String date){
        mMagnitude = magnitude;
        mLocation= place;
        mDate = date;
    }

    public String getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public String getDate(){
        return mDate;
    }
}
