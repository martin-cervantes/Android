package com.example.mcervantes.miwok;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumbersList (View view)
    {
        Intent i = new Intent(this, Numbers.class);
        startActivity(i);
    }

    public void openFamilyMembersList (View view)
    {
        Intent i = new Intent(this, FamilyMembers.class);
        startActivity(i);
    }

    public void openColorsList (View view)
    {
        Intent i = new Intent(this, Colors.class);
        startActivity(i);
    }

    public void openPhrasesList (View view)
    {
        Intent i = new Intent(this, Phrases.class);
        startActivity(i);
    }
}
