package com.example.android.quakereport;

/**
 * Created by swati on 14/03/2017.
 */

public class Earthquake  {

    /**
     * Magnitude of the earthquake
     */
    private double mMagnitude;

    /**
     * Place where earthquake occured
     */
    private String mLocation;

    /**
     * Time of earthquake
     */
    private long mTimeInMilliSeconds;

    public Earthquake(double magnitude, String place, long timeInMilliSeconds){
        mMagnitude = magnitude;
        mLocation= place;
        mTimeInMilliSeconds = timeInMilliSeconds;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getTimeInMilliSeconds(){
        return mTimeInMilliSeconds;
    }
}
