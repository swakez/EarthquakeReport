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

    /**
     * URL for details of earthquake
     */
    private String mURL;
    /**
     *
     * @param magnitude is the magnitude of the Earthquake
     * @param place is the location where the Earthquake happened
     * @param timeInMilliSeconds is the time in milliseconds(UNIX time) when the earthquakehappened
     * @param url url is the website link to find more details of the earthquake
     */

    public Earthquake(double magnitude, String place, long timeInMilliSeconds,String url){
        mMagnitude = magnitude;
        mLocation= place;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mURL = url;

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

    public String getURL(){ return mURL; }
}
