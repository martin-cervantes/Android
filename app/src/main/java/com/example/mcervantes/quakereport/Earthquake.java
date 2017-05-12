package com.example.mcervantes.quakereport;

/**
 * Created by mcervantes on 11/05/17.
 */

public class Earthquake
{
    private String mMagnitude;

    private String mLocation;

    private String mDate;

    public Earthquake(String magnitude, String location, String date)
    {
        mMagnitude = magnitude;

        mLocation = location;

        mDate = date;
    }

    public String getMagnitude()
    {
        return mMagnitude;
    }

    public String getLocation()
    {
        return mLocation;
    }

    public String getDate()
    {
        return mDate;
    }
}
