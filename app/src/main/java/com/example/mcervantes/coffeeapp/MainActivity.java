package com.example.mcervantes.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity
{
    int numberOfCoffes = 2;
    int quantity = 0;
    

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
       // displayPrice(quantity * 5);
        String priceMessage = "Total = " + NumberFormat.getCurrencyInstance().format(quantity * 5) + "\nThank you!! :D";
        displayMessage(priceMessage);
    }

    public void increment(View view)
    {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view)
    {
        if(quantity > 0)
        {
            quantity = quantity - 1;
        }

        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(message);
    }
}
