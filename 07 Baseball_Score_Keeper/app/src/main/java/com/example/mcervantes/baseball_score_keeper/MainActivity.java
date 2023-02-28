package com.example.mcervantes.baseball_score_keeper;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int guest_points = 0;
    int home_points = 0;
    boolean he = true;
    int innings_counter = 1;
    int outs_counter = 0;
    int strikes_counter = 0;
    int balls_counter = 0;

    TextView guestPoints;
    TextView homePoints;
    TextView innersCounter;
    TextView outsCounter;
    TextView strikesCounter;
    TextView ballsCounter;

    Button guestButton;
    Button homeButton;
    Button outsButton;
    Button strikesButton;
    Button ballsButton;
    Button resetButton;

    public void Show()
    {
        guestPoints.setText(String.valueOf(guest_points));
        homePoints.setText(String.valueOf(home_points));
        innersCounter.setText(String.valueOf(innings_counter));
        outsCounter.setText(String.valueOf(outs_counter));
        strikesCounter.setText(String.valueOf(strikes_counter));
        ballsCounter.setText(String.valueOf(balls_counter));
    }

    public void outsCounter()
    {
        outs_counter += 1;

        if(outs_counter == 3)
        {
            outs_counter = 0;
            balls_counter = 0;
            strikes_counter = 0;

            he = !he;

            guestButton.setEnabled(!guestButton.isEnabled());
            homeButton.setEnabled(!homeButton.isEnabled());

            if(he)
            {
                innings_counter += 1;

                Toast.makeText(MainActivity.this, R.string.new_inning, Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, R.string.half_inning, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guestPoints = findViewById(R.id.guest_points);
        homePoints = findViewById(R.id.home_points);
        innersCounter = findViewById(R.id.inning_counter);
        outsCounter = findViewById(R.id.outs_counter);
        strikesCounter = findViewById(R.id.strikes_counter);
        ballsCounter = findViewById(R.id.balls_counter);

        guestButton = findViewById(R.id.guest_button);
        homeButton = findViewById(R.id.home_button);
        outsButton = findViewById(R.id.outs_button);
        strikesButton = findViewById(R.id.strikes_button);
        ballsButton = findViewById(R.id.balls_button);
        resetButton = findViewById(R.id.reset);

        guestButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                guest_points += 1;

                Show();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                home_points += 1;

                Show();
            }
        });

        outsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                outsCounter();

                Show();
            }
        });

        strikesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                strikes_counter += 1;

                if(strikes_counter == 3)
                {
                    balls_counter = 0;
                    strikes_counter = 0;

                    Toast.makeText(MainActivity.this, R.string.strikeout, Toast.LENGTH_SHORT).show();

                    outsCounter();
                }

                Show();
            }
        });

        ballsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                balls_counter += 1;

                if (balls_counter == 4)
                {
                    balls_counter = 0;
                    strikes_counter = 0;

                    Toast.makeText(MainActivity.this, R.string.base_on_balls, Toast.LENGTH_SHORT).show();
                }

                Show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                guest_points = 0;
                home_points = 0;
                he = true;
                innings_counter = 1;
                outs_counter = 0;
                strikes_counter = 0;
                balls_counter = 0;

                Show();
            }
        });
    }
}
