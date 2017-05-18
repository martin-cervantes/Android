package com.example.mcervantes.quakereport;

/**
 * Created by mcervantes on 11/05/17.
 */

public class Earthquake
{
    private double mMagnitude;

    private String mLocation;

    private long mTimeInMilliseconds;

    private String mUrl;


    public Earthquake(double magnitude, String location, long time, String url)
    {
        mMagnitude = magnitude;

        mLocation = location;

        mTimeInMilliseconds = time;

        mUrl = url;
    }

    public double getMagnitude()
    {
        return mMagnitude;
    }

    public String getLocation()
    {
        return mLocation;
    }

    public long getTimeInMilleseconds()
    {
        return mTimeInMilliseconds;
    }

    public String getUrl()
    {
        return mUrl;
    }
}
