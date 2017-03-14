package com.example.android.quakereport;

/**
 * Created by swati on 14/03/2017.
 */

public class Earthquake  {

    /**
     * Magnitude of the earthquake
     */
    private float magnitude;

    /**
     * Place where earthquake occured
     */
    private String place;

    /**
     * Date of earthquake
     */
    private String date;

    public Earthquake(float _magnitude, String _place, String _date){
        magnitude = _magnitude;
        place = _place;
        date = _date;
    }

    public float getMagnitude(){
        return magnitude;
    }

    public String getPlace(){
        return place;
    }

    public String getDate(){
        return date;
    }
}
