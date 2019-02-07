package com.example.mcervantes.eat_cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    boolean status = true;

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
        TextView myText = (TextView) findViewById(R.id.status_text_view);
        Button myButton =  (Button) findViewById(R.id.button);

        if(status)
        {
            myImage.setImageResource(R.drawable.after_cookies);
            myText.setText(R.string.status_after);
            myButton.setText(R.string.reset);
        }
        else
        {
            myImage.setImageResource(R.drawable.before_cookies);
            myText.setText(R.string.status_before);
            myButton.setText(R.string.app_name);
        }

        status = !status;

    }
}
