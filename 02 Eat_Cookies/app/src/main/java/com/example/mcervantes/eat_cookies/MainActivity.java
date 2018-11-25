package com.example.mcervantes.eat_cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view)
    {
        ImageView myImage = (ImageView) findViewById(R.id.android_cookie_image_view);
        myImage.setImageResource(R.drawable.after_cookies);

        TextView myText = (TextView) findViewById(R.id.status_text_view);
        myText.setText("I'm so full");

    }
}
