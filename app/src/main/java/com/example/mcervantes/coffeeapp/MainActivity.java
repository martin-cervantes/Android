package com.example.mcervantes.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    int quantity = 0;
    boolean hasWhippedCream = false;
    boolean hasChololate = false;
    String name = "Martin Cervantes";

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
        String Name = nameEditText.getText().toString();

        if (!Name.equals(""))
        {
            name = nameEditText.getText().toString();
        }

        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary);
        //orderSummaryTextView.setText(createOrderSummary(calculatePrice(), name));

        createOrderSummary(calculatePrice(), name);

    }

    public void createOrderSummary(int price, String customer)
    {
        String message =  "Name = "+ customer +"\n" +
                "Add whipped cream? "+ hasWhippedCream +"\n" +
                "Add chocolate? "+ hasChololate +"\n" +
                "Quantity = " + quantity + "\n" +
                "Total = " + NumberFormat.getCurrencyInstance().format(price) + "\n" +
                "Thank you!! :D";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "cervantes.martine@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee App");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }

    }

    public void increment(View view)
    {
        if(quantity < 50)
        {
            quantity = quantity + 1;
        }
        else
        {
            Toast.makeText(this, "You cannot have more than 50 coffees :(", Toast.LENGTH_LONG).show();
        }

        displayQuantity();
    }

    public void decrement(View view)
    {
        if(quantity > 1)
        {
            quantity = quantity - 1;
        }
        else
        {
            Toast.makeText(this, "You cannot have less than 1 coffee :(", Toast.LENGTH_LONG).show();
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
