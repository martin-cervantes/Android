package com.example.mcervantes.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;


import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity
{
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "lutti", R.drawable.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
