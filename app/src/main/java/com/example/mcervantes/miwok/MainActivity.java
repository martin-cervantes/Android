package com.example.mcervantes.miwok;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * */

        /*NumbersClickListener clickListener = new NumbersClickListener();*/

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * */
        TextView numbers = (TextView)findViewById(R.id.numbers);


        //numbers.setOnClickListener(clickListener);
        //numbers.setOnclickListener(new NumbersClickListener());
        numbers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, Numbers.class);
                startActivity(i);
            }
        });


         /* * * * * * * * * * * * * * * * * * * * * * * * * * * */


        TextView familyMembers = (TextView)findViewById(R.id.family);

        familyMembers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of family members", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, FamilyMembers.class);
                startActivity(i);
            }
        });


         /* * * * * * * * * * * * * * * * * * * * * * * * * * * */
        TextView colors = (TextView)findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of colors", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, Colors.class);
                startActivity(i);
            }
        });


         /* * * * * * * * * * * * * * * * * * * * * * * * * * * */
        TextView phrases = (TextView)findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of phrases", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, Phrases.class);
                startActivity(i);
            }
        });
    }
}
