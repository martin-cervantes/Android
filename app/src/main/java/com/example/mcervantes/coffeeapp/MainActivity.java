package com.example.mcervantes.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    int quantity = 0;
    boolean hasWhippedCream = false;
    boolean hasChololate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view)
    {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_Chk);
        hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox ChololateCheckBox = (CheckBox) findViewById(R.id.chocolate_Chk);
        hasChololate = ChololateCheckBox.isChecked();

        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();

        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary);
        orderSummaryTextView.setText(createOrderSummary(calculatePrice(), name));
    }

    public String createOrderSummary(int price, String customer)
    {
        return "Name = "+ customer +"\n" +
                "Add whipped cream? "+ hasWhippedCream +"\n" +
                "Add chocolate? "+ hasChololate +"\n" +
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
        int total = 5;

        if(hasWhippedCream) total += 1;

        if(hasChololate) total += 2;

        return quantity * total;
    }

    public void displayQuantity()
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
    }
}
