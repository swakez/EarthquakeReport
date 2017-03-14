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

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }
        Earthquake localEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.mag_text_view);
        magnitudeTextView.setText(Float.toString(localEarthquake.getMagnitude()));

        TextView placeTextView = (TextView)listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(localEarthquake.getPlace());

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(localEarthquake.getDate());

        return listItemView;


       // return super.getView(position, convertView, parent);
    }
}
