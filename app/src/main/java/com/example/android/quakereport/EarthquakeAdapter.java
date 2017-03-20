package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by swati on 14/03/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    String locationOffset;
    String primaryLocation;

    private final String LOCATION_SEPARATOR = " of ";

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

        updateUI(listItemView,localEarthquake);

        return listItemView;
    }

    private void updateUI(View listItemView,Earthquake localEarthquake){
        String formattedMagnitude = formatMagnitude(localEarthquake.getMagnitude());

        // Find the textview with View ID Magnitude
        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.mag_text_view);
        //Display the magnitude of current earthquake
        magnitudeTextView.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable)magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(localEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = localEarthquake.getLocation();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        // Find the textview with View ID location
        TextView offsetTextView = (TextView)listItemView.findViewById(R.id.offset_text_view);
        //Display the location of current earthquake
        offsetTextView.setText(locationOffset);


        // Find the textview with View ID location
        TextView primaryLocationTextView = (TextView)listItemView.findViewById(R.id.primary_location_text_view);
        //Display the location of current earthquake
        primaryLocationTextView.setText(primaryLocation);

        // Create a new date object from the time in milliseconds of the current earthquake
        Date dateObject = new Date(localEarthquake.getTimeInMilliSeconds());

        // Find the textview with View ID date
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date_text_view);

        //Format the date String
        String formattedDate = formatDate(dateObject);

        dateTextView.setText(formattedDate);

        //Find the textView with View ID Time
        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time_text_view);

        //Format the time String
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);

    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){

        int magnitueFloor = (int)Math.floor(magnitude);
        int magnitudeColorResourceId;
        switch (magnitueFloor){
            case 1:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return  magnitudeColorResourceId;

    }
}
