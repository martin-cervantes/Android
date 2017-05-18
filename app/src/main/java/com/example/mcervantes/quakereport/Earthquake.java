package com.example.mcervantes.quakereport;

/**
 * Created by mcervantes on 11/05/17.
 */

public class Earthquake
{
    private String mMagnitude;

    private String mLocation;

    private long mTimeInMilliseconds;


    public Earthquake(String magnitude, String location, long time)
    {
        mMagnitude = magnitude;

        mLocation = location;

        mTimeInMilliseconds = time;
    }

    public String getMagnitude()
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
}
