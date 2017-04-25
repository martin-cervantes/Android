package com.example.mcervantes.miwok;

/**
 * Created by mcervantes on 23/04/17.
 */

public class Word
{
    private String defaultTranslation;

    private String miwokTranslation;

    private int imageResourceID;


    public Word(String defaultWord, String miwokWord)
    {
        defaultTranslation = defaultWord;

        miwokTranslation = miwokWord;
    }

    public Word(String defaultWord, String miwokWord, int resourceID)
    {
        defaultTranslation = defaultWord;

        miwokTranslation = miwokWord;

        imageResourceID = resourceID;
    }

    public String getDefaultTranslation()
    {
        return defaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return miwokTranslation;
    }

    public int getImageResourceID()
    {
        return imageResourceID;
    }
}
