package com.example.mcervantes.american_football_scoreboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    boolean home;
    int home_points;
    int guest_points;
    int downs_counter;
    int to_go_counter;

    TextView TV_home_points;
    TextView TV_guest_points;
    TextView TV_downs_counter;
    TextView TV_to_go_counter;

    Button touchdown;
    Button field_goal;
    Button safety;
    Button down;
    Button switchs;
    Button less_one;
    Button plus_one;

    Button reset;

    public void Reset()
    {
        home = true;
        home_points = 0;
        guest_points = 0;
        downs_counter = 1;
        to_go_counter = 10;
    }

    public void Switch()
    {
        home = !home;

        downs_counter = 1;

        to_go_counter = 10;

        Show(R.string.switchs);

        touchdown.setText(R.string.touchdown);
        field_goal.setText(R.string.field_goal);
        down.setEnabled(true);
    }

    public void Show(int message)
    {
        if(home)
        {
            TV_home_points.setTextColor(Color.RED);
            TV_guest_points.setTextColor(Color.BLACK);
        }
        else
        {
            TV_home_points.setTextColor(Color.BLACK);
            TV_guest_points.setTextColor(Color.RED);
        }

        TV_home_points.setText(String.valueOf(home_points));
        TV_guest_points.setText(String.valueOf(guest_points));
        TV_downs_counter.setText(String.valueOf(downs_counter));
        TV_to_go_counter.setText(String.valueOf(to_go_counter));

        Toast.makeText(MainActivity.this, message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reset();

        TV_home_points = findViewById(R.id.home_points);
        TV_guest_points = findViewById(R.id.guest_points);
        TV_downs_counter = findViewById(R.id.downs_counter);
        TV_to_go_counter = findViewById(R.id.to_go_counter);

        touchdown = findViewById(R.id.touchdown);
        field_goal = findViewById(R.id.field_goal);
        safety = findViewById(R.id.safety);
        down = findViewById(R.id.down);
        switchs = findViewById(R.id.switchs);
        less_one = findViewById(R.id.less_one);
        plus_one = findViewById(R.id.plus_one);

        reset = findViewById(R.id.reset);


        touchdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(touchdown.getText().equals("Touchdown +6"))
                {
                    if(home)
                        home_points += 6;
                    else
                        guest_points += 6;

                    Show(R.string.touchdown);

                    touchdown.setText(R.string.two_point);
                    field_goal.setText(R.string.extra_point);
                    down.setEnabled(false);
                }
                else
                {
                    if(home)
                        home_points += 2;
                    else
                        guest_points += 2;

                    Show(R.string.two_point);

                    Switch();
                }
            }
        });

        field_goal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(field_goal.getText().equals("Field goal +3"))
                {
                    if (home)
                        home_points += 3;
                    else
                        guest_points += 3;

                    Show(R.string.field_goal);
                }
                else
                {
                    if (home)
                        home_points += 1;
                    else
                        guest_points += 1;

                    Show(R.string.extra_point);
                }

                Switch();
            }
        });

        safety.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!home)
                    home_points += 2;
                else
                    guest_points += 2;

                Show(R.string.safety);

                Switch();
            }
        });

        down.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                downs_counter++;

                Show(R.string.down);

                if(downs_counter == 5)
                    Switch();
            }
        });

        switchs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Switch();
            }
        });

        less_one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                to_go_counter--;
                Show(R.string.less_one);
            }
        });

        plus_one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                to_go_counter++;
                Show(R.string.plus_one);
            }
        });

        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Reset();

                Show(R.string.reset);

                touchdown.setText(R.string.touchdown);
                field_goal.setText(R.string.field_goal);
            }
        });


    }
}
