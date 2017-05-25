package com.example.mcervantes.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by mcervantes on 24/05/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>>
{
    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context, String url)
    {
        super(context);

        mUrl = url;
    }

    @Override
    protected void onStartLoading()
    {
        Log.e(LOG_TAG, "Loader startLoading method");

        forceLoad();
    }

    /** This is on a backgroud thread **/
    @Override
    public List<Earthquake> loadInBackground()
    {
        Log.e(LOG_TAG, "Loader loadInBackgroud method");

        if(mUrl == null)
        {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);

        return earthquakes;
    }
}
