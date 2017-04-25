package com.example.mcervantes.miwok;

/**
 * Created by mcervantes on 23/04/17.
 */

public class Word
{
    private String defaultTranslation;

    private String miwokTranslation;

    private int imageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


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

    public boolean hasImage()
    {
        return imageResourceID != NO_IMAGE_PROVIDED;
    }
}
