package com.example.mcervantes.booklistingapp;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mcervantes on 6/14/17.
 */

public class SettingsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class BookPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener
    {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue)
        {
            return false;
        }

        private void bindPreferenceChangeListener(Preference preference)
        {

        }
    }
}
