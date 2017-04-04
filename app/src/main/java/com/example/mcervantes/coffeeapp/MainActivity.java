package com.example.mcervantes.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_Chk);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox ChololateCheckBox = (CheckBox) findViewById(R.id.chocolate_Chk);
        boolean hasChololate = ChololateCheckBox.isChecked();

        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary);
        orderSummaryTextView.setText(createOrderSummary(calculatePrice(), hasWhippedCream, hasChololate));
    }

    public String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate)
    {
        return "Name = Martin Cervantes\n" +
                "Add whipped cream? "+ addWhippedCream +"\n" +
                "Add chocolate? "+ addChocolate +"\n" +
                "Quantity = " + quantity + "\n" +
                "Total = " + NumberFormat.getCurrencyInstance().format(price) + "\n" +
                "Thank you!! :D";
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

    private int calculatePrice()
    {
        return quantity * 5;
    }

    public void displayQuantity()
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
    }
}
