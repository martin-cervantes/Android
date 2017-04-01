package com.example.mcervantes.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText("Total = " + NumberFormat.getCurrencyInstance().format(calculatePrice(quantity)) + "\nThank you!! :D");
    }

    public void increment(View view)
    {
        quantity = quantity + 1;

        displayQuantity();
    }

    public void decrement(View view)
    {
        if(quantity > 0)
        {
            quantity = quantity - 1;
        }

        displayQuantity();
    }

    private int calculatePrice(int quantity)
    {
        int price = quantity * 5;
        return price;
    }

    public void displayQuantity()
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
    }
}
