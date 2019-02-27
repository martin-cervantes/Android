package com.example.mcervantes.coffee_shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.text.NumberFormat;
import android.net.Uri;

public class MainActivity extends AppCompatActivity
{
    int quantity = 1;
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


        if (!nameEditText.getText().toString().equals(""))
        {
            name = nameEditText.getText().toString();
        }

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary);
        String message = createOrderSummary(calculatePrice(), name);
        orderSummaryTextView.setText(message);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "cervantes.martine@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    public String createOrderSummary(int price, String customer)
    {
        return getString(R.string.hint) + " = " + customer +"\n" +
                getString(R.string.topping1) + " " + hasWhippedCream +"\n" +
                getString(R.string.topping2) + " " + hasChololate +"\n" +
                getString(R.string.quantity) + " = " + quantity + "\n" +
                getString(R.string.total) + " = " + NumberFormat.getCurrencyInstance().format(price) + "\n" +
                getString(R.string.thanks);
    }

    public void increment(View view)
    {
        if(quantity < 50)
        {
            quantity = quantity + 1;
        }
        else
        {
            Toast.makeText(this, R.string.more_than_error, Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, R.string.less_than_error, Toast.LENGTH_LONG).show();
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
        quantityTextView.setText(String.valueOf(quantity));
    }
}
