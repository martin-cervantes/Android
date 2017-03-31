package com.example.mcervantes.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    int scoreTeamA = 0, scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dispalyForTeamA(8);
    }
    
    public void displayForTeamA(int score)
    {
        TextView scoreViewA = (TextView) findViewById(R.id.counterA);
        scoreViewA.setText(String.valueOf(score));
    }
    
    public void addThreeForTeamA(View view)
    {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }
    
    public void addTwoForTeamA(View view)
    {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }
    
    public void addOneForTeamA(View view)
    {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void displayForTeamB(int score)
    {
        TextView scoreViewB = (TextView) findViewById(R.id.counterB);
        scoreViewB.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View view)
    {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View view)
    {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB(View view)
    {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }
}
