package com.example.crossmultiplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText EditText_A = (EditText) findViewById(R.id.A);
        final EditText EditText_B = (EditText) findViewById(R.id.B);
        final EditText EditText_C = (EditText) findViewById(R.id.C);
        final TextView TextView_X = (TextView) findViewById(R.id.X);

        Button btn_Calcular = (Button) findViewById(R.id.calcular);
        btn_Calcular.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if(EditText_A.getText().toString().equals("") ||
                   EditText_B.getText().toString().equals("") ||
                   EditText_C.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, R.string.missing_data, Toast.LENGTH_LONG).show();
                }
                else
                {
                    float A = Float.parseFloat(EditText_A.getText().toString());
                    float B = Float.parseFloat(EditText_B.getText().toString());
                    float C = Float.parseFloat(EditText_C.getText().toString());

                    float X = C * B / A;

                    TextView_X.setText("" + X);
                }
            }
        });


        EditText_A.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(keyCode == KeyEvent.KEYCODE_DEL)
                {
                    EditText_A.setText("");
                    EditText_B.setText("");
                    EditText_C.setText("");
                    TextView_X.setText("X");
                }
                return false;
            }
        });
    }
}
