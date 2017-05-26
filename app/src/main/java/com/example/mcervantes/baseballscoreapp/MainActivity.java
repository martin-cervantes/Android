package com.example.mcervantes.baseballscoreapp;

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
    int inners_counter = 1;
    int balls_counter = 0;
    int strikes_counter = 0;
    int outs_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button guestButton = (Button) findViewById(R.id.guest_button);

        guestButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                guest_points += 1;

                TextView guestPoints = (TextView) findViewById(R.id.guest_points);

                guestPoints.setText(String.valueOf(guest_points));
            }
        });

        Button homeButton = (Button) findViewById(R.id.home_button);

        homeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                home_points += 1;

                TextView homePoints = (TextView) findViewById(R.id.home_points);

                homePoints.setText(String.valueOf(home_points));
            }
        });

        Button ballsButton = (Button) findViewById(R.id.balls_button);

        ballsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (balls_counter < 4)
                    balls_counter += 1;

                if (balls_counter == 4)
                {
                    balls_counter = 0;

                    strikes_counter = 0;

                    Toast.makeText(MainActivity.this, R.string.base_on_balls, Toast.LENGTH_SHORT).show();

                    TextView strikesCounter = (TextView) findViewById(R.id.strikes_counter);

                    strikesCounter.setText(String.valueOf(strikes_counter));
                }

                TextView ballsCounter = (TextView) findViewById(R.id.balls_counter);

                ballsCounter.setText(String.valueOf(balls_counter));
            }
        });

        Button strikesButton = (Button) findViewById(R.id.strikes_button);

        strikesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(strikes_counter < 3)
                    strikes_counter += 1;

                if(strikes_counter == 3)
                {
                    strikes_counter = 0;

                    Toast.makeText(MainActivity.this, R.string.strikeout, Toast.LENGTH_SHORT).show();

                    outsCounter();
                }

                TextView strikesCounter = (TextView) findViewById(R.id.strikes_counter);

                strikesCounter.setText(String.valueOf(strikes_counter));
            }
        });

        Button outsButton = (Button) findViewById(R.id.outs_button);

        outsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                outsCounter();
            }
        });
    }

    public void outsCounter()
    {
        if(outs_counter < 3)
            outs_counter += 1;

        if(outs_counter == 3 && he == true)
        {
            outs_counter = 0;

            he = false;

            Toast.makeText(MainActivity.this, R.string.half_inning, Toast.LENGTH_SHORT).show();

            Button homeButton = (Button) findViewById(R.id.home_button);

            homeButton.setEnabled(true);

            Button guestButton = (Button) findViewById(R.id.guest_button);

            guestButton.setEnabled(false);
        }
        else if(outs_counter == 3 && he == false)
        {
            outs_counter = 0;

            he = true;

            inners_counter += 1;

            Toast.makeText(MainActivity.this, R.string.new_inning, Toast.LENGTH_SHORT).show();

            Button homeButton = (Button) findViewById(R.id.home_button);

            homeButton.setEnabled(false);

            Button guestButton = (Button) findViewById(R.id.guest_button);

            guestButton.setEnabled(true);

            TextView innersCounter = (TextView) findViewById(R.id.inning_counter);

            innersCounter.setText(String.valueOf(inners_counter));
        }

        TextView outsCounter = (TextView) findViewById(R.id.outs_counter);

        outsCounter.setText(String.valueOf(outs_counter));
    }
}
