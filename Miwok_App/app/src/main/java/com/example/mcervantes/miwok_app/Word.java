package com.example.mcervantes.miwok_app;

public class Word
{
    private int defaultTranslation;

    private String miwokTranslation;

    private int imageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int audioResourceID;

    public Word(int defaultWordID, String miwokWord, int audioID)
    {
        defaultTranslation = defaultWordID;

        miwokTranslation = miwokWord;

        audioResourceID = audioID;
    }

    public Word(int defaultWordID, String miwokWord, int imageID, int audioID)
    {
        defaultTranslation = defaultWordID;

        miwokTranslation = miwokWord;

        imageResourceID = imageID;

        audioResourceID =  audioID;
    }

    public int getDefaultTranslation()
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
