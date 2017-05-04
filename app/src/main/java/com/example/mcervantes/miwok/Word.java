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

    private int audioResourceID;


    public Word(String defaultWord, String miwokWord, int audioID)
    {
        defaultTranslation = defaultWord;

        miwokTranslation = miwokWord;

        audioResourceID = audioID;
    }

    public Word(String defaultWord, String miwokWord, int imageID, int audioID)
    {
        defaultTranslation = defaultWord;

        miwokTranslation = miwokWord;

        imageResourceID = imageID;

        audioResourceID =  audioID;
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

    public int getAudioResourceID()
    {
        return audioResourceID;
    }
}
