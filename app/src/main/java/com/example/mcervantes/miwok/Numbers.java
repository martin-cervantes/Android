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
        setContentView(R.layout.activity_numbers);


        ArrayList<Word> words = new ArrayList<Word>();

        //words.add("one");  <---forma original
        //Word w = new Word("one", "lutti");  <---nueva forma creando el objeto
        //words.add(w); <---agregando el objeto a la lista

        words.add(new Word("one", "lutti"));  //<---pasos resumidos

        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo'e"));
        words.add(new Word("ten", "na'aacha"));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
