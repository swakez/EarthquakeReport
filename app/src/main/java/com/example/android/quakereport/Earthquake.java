package com.example.android.quakereport;

/**
 * Created by swati on 14/03/2017.
 */

public class Earthquake  {

    /**
     * Magnitude of the earthquake
     */
    private float mMagnitude;

    /**
     * Place where earthquake occured
     */
    private String mLocation;

    /**
     * Date of earthquake
     */
    private String mDate;

    public Earthquake(float magnitude, String place, String date){
        mMagnitude = magnitude;
        mLocation= place;
        mDate = date;
    }

    public float getMagnitude(){
        return mMagnitude;
    }

    public String getPlace(){
        return mLocation;
    }

    public String getDate(){
        return mDate;
    }
}
