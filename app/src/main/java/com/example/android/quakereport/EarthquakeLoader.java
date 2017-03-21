package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by swati on 20/03/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl = "";

    public EarthquakeLoader(Context context,String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG," onStartLoading");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        // Don't perform the request if there are no URLs, or the first URL is null
        if ( mUrl == null) {
            return null;
        }
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        Log.e(LOG_TAG," in loadbackgrd");
        return earthquakes;
    }

}
