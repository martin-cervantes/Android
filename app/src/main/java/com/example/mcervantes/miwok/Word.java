package com.example.mcervantes.miwok;

/**
 * Created by mcervantes on 23/04/17.
 */

public class Word
{
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation)
    {
        mDefaultTranslation = defaultTranslation;

        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }
}
