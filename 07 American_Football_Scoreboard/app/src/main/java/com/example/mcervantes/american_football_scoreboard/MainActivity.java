package com.example.mcervantes.american_football_scoreboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    EditText ET_to_go_counter;

    Button touchdown;
    Button field_goal;
    Button safety;
    Button down;
    Button switchs;

    Button reset;

    public void Reset()
    {
        home = true;
        home_points = 0;
        guest_points = 0;
        downs_counter = 1;
        to_go_counter = 10;
    }

    public void Change_Text()
    {
        if(touchdown.getText() == "Touchdown +6")
        {
            touchdown.setText(R.string.two_point);
            field_goal.setText(R.string.extra_point);
        }
        else
        {
            touchdown.setText(R.string.touchdown);
            field_goal.setText(R.string.field_goal);
        }
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

        TV_home_points.setText("" + home_points);
        TV_guest_points.setText("" + guest_points);
        TV_downs_counter.setText("" + downs_counter);
        ET_to_go_counter.setText("" + to_go_counter);

        Toast.makeText(MainActivity.this, message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reset();

        TV_home_points = (TextView) findViewById(R.id.home_points);
        TV_guest_points = (TextView) findViewById(R.id.guest_points);
        TV_downs_counter = (TextView) findViewById(R.id.downs_counter);
        ET_to_go_counter = (EditText) findViewById(R.id.to_go_counter);

        touchdown = (Button) findViewById(R.id.touchdown);
        field_goal = (Button) findViewById(R.id.field_goal);
        safety = (Button) findViewById(R.id.safety);
        down = (Button) findViewById(R.id.down);
        switchs = (Button) findViewById(R.id.switchs);

        reset = (Button) findViewById(R.id.reset);


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
                }
                else
                {
                    if(home)
                        home_points += 2;
                    else
                        guest_points += 2;

                    Show(R.string.two_point);

                    touchdown.setText(R.string.touchdown);
                    field_goal.setText(R.string.field_goal);
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

                    touchdown.setText(R.string.touchdown);
                    field_goal.setText(R.string.field_goal);
                }
            }
        });

        safety.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(home)
                    home_points += 2;
                else
                    guest_points += 2;

                Show(R.string.safety);
            }
        });

        down.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                downs_counter++;

                Show(R.string.down);
            }
        });

        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Reset();

                Show(R.string.reset);
            }
        });

        switchs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                home = !home;

                downs_counter = 1;

                to_go_counter = 10;

                Show(R.string.switchs);

                touchdown.setText(R.string.touchdown);
                field_goal.setText(R.string.field_goal);
            }
        });
    }
}
