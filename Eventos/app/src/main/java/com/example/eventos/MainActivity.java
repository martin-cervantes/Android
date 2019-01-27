package com.example.eventos;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                Toast.makeText(MainActivity.this,"Text Changed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                Toast.makeText(MainActivity.this, "Before Text Changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Toast.makeText(MainActivity.this, "After Text Changed", Toast.LENGTH_SHORT).show();
            }
        });

        Button boton = (Button) findViewById(R.id.button);
//        boton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(MainActivity.this,"Button Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        boton.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Toast.makeText(MainActivity.this,"Long Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        boton.setOnFocusChangeListener(new View.OnFocusChangeListener()
//        {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus)
//            {
//                Toast.makeText(MainActivity.this, "Focus", Toast.LENGTH_SHORT).show();
//            }
//        });



    }
}
