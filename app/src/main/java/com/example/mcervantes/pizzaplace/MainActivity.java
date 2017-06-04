package com.example.mcervantes.pizzaplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Pizza pizza = new Pizza();

    private int toppingsLimit = 1;
    private int toppingsCouter = 0;

    RadioButton small;
    RadioButton medium;
    RadioButton large;

    RadioButton one;
    RadioButton two;
    RadioButton three;
    RadioButton four;

    CheckBox onion;
    CheckBox beacon;
    CheckBox sausage;
    CheckBox pepperoni;
    CheckBox mushrooms;
    CheckBox extCheese;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        small = (RadioButton) findViewById(R.id.small);
        small.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pizza.setSize(1);
            }
        });

        medium = (RadioButton) findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pizza.setSize(2);
            }
        });

        large = (RadioButton) findViewById(R.id.large);
        large.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pizza.setSize(3);
            }
        });

        one = (RadioButton) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toppingsLimit = 1;

                clearSelection();
            }
        });

        two = (RadioButton) findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(toppingsLimit < 2)
                    enableToppings();
                else
                    clearSelection();

                toppingsLimit = 2;
            }
        });

        three = (RadioButton) findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(toppingsLimit < 3)
                    enableToppings();
                else
                    clearSelection();

                toppingsLimit = 3;
            }
        });

        four = (RadioButton) findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(toppingsLimit < 4)
                    enableToppings();
                else
                    clearSelection();

                toppingsLimit = 4;
            }
        });

        onion = (CheckBox) findViewById(R.id.onion);
        onion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (onion.isChecked())
                {
                    toppingsCouter++;
                    pizza.setOnion(true);
                }
                else
                {
                    toppingsCouter--;
                    pizza.setOnion(false);
                }

                toppingsLimit();
            }
        });

        beacon = (CheckBox) findViewById(R.id.beacon);
        beacon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(beacon.isChecked())
                {
                    toppingsCouter++;
                    pizza.setBeacon(true);
                }
                else
                {
                    toppingsCouter--;
                    pizza.setBeacon(false);
                }

                toppingsLimit();
            }
        });

        sausage = (CheckBox) findViewById(R.id.sausage);
        sausage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(sausage.isChecked())
                {
                    toppingsCouter++;
                    pizza.setSausage(true);
                }
                else
                {
                    toppingsCouter--;
                    pizza.setSausage(false);
                }

                toppingsLimit();
            }
        });

        pepperoni = (CheckBox) findViewById(R.id.peperoni);
        pepperoni.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(pepperoni.isChecked())
                {
                    toppingsCouter++;
                    pizza.setPepperoni(true);
                }
                else
                {
                    toppingsCouter--;
                    pizza.setPepperoni(false);
                }

                toppingsLimit();
            }
        });

        mushrooms = (CheckBox) findViewById(R.id.mushrooms);
        mushrooms.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mushrooms.isChecked())
                {
                    toppingsCouter++;
                    pizza.setMushrooms(true);
                }
                else
                {
                    toppingsCouter--;
                    pizza.setMushrooms(false);
                }

                toppingsLimit();
            }
        });

        extCheese = (CheckBox) findViewById(R.id.extCheese);
        extCheese.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(extCheese.isChecked())
                {
                    toppingsCouter++;
                    pizza.setExtCheese(true);
                }
                else
                {
                    toppingsCouter--;
                    pizza.setExtCheese(false);
                }

                toppingsLimit();
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                small.setChecked(true);

                one.setChecked(true);

                toppingsLimit = 1;

                clearSelection();

                Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_LONG).show();
            }
        });

        Button total = (Button) findViewById(R.id.total);
        total.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(toppingsCouter == toppingsLimit)
                    Toast.makeText(MainActivity.this, "Your Total is ->"+pizza.getTotal(), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Change number of toppings", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void toppingsLimit() {
        if (toppingsCouter == toppingsLimit) {
            if (!onion.isChecked())
                onion.setEnabled(false);

            if (!beacon.isChecked())
                beacon.setEnabled(false);

            if (!sausage.isChecked())
                sausage.setEnabled(false);

            if (!pepperoni.isChecked())
                pepperoni.setEnabled(false);

            if (!mushrooms.isChecked())
                mushrooms.setEnabled(false);

            if (!extCheese.isChecked())
                extCheese.setEnabled(false);
        }
        else
            enableToppings();
    }

    public void enableToppings()
    {
        onion.setEnabled(true);

        beacon.setEnabled(true);

        sausage.setEnabled(true);

        pepperoni.setEnabled(true);

        mushrooms.setEnabled(true);

        extCheese.setEnabled(true);
    }

    public void clearSelection()
    {
        toppingsCouter = 0;

        onion.setChecked(false);
        pizza.setOnion(false);

        beacon.setChecked(false);
        pizza.setBeacon(false);

        sausage.setChecked(false);
        pizza.setSausage(false);

        pepperoni.setChecked(false);
        pizza.setPepperoni(false);

        mushrooms.setChecked(false);
        pizza.setMushrooms(false);

        extCheese.setChecked(false);
        pizza.setExtCheese(false);

        enableToppings();
    }
}
