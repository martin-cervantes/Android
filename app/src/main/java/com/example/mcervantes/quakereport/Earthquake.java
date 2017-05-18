package com.example.mcervantes.quakereport;

/**
 * Created by mcervantes on 11/05/17.
 */

public class Earthquake
{
    private double mMagnitude;

    private String mLocation;

    private long mTimeInMilliseconds;


    public Earthquake(double magnitude, String location, long time)
    {
        mMagnitude = magnitude;

        mLocation = location;

        mTimeInMilliseconds = time;
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
}
