package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by swati on 14/03/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Context context, int resource, List<Earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        // Check if there is an existing list item view (called converview) then we can use it,
        // otherwise inflate a new list item layout
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }

        // Find the earthquake at the given location in the list of earthquakes
        Earthquake localEarthquake = getItem(position);

        // Find the textview with View ID Magnitude
        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.mag_text_view);
        //Display the magnitude of current earthquake
        magnitudeTextView.setText(localEarthquake.getMagnitude());

        // Find the textview with View ID location
        TextView placeTextView = (TextView)listItemView.findViewById(R.id.location_text_view);
        //Display the location of current earthquake
        placeTextView.setText(localEarthquake.getLocation());

        // Find the textview with View ID date
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date_text_view);
        //Display the date of current earthquake
        dateTextView.setText(localEarthquake.getDate());

        return listItemView;


       // return super.getView(position, convertView, parent);
    }
}
