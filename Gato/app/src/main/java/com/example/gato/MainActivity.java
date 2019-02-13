package com.example.gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    String turno = "X";

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    Button reset;

    public void Revisar()
    {
        if ((button1.getText() == "O" && button2.getText() == "O" && button3.getText() == "O") ||
            (button4.getText() == "O" && button5.getText() == "O" && button6.getText() == "O") ||
            (button7.getText() == "O" && button8.getText() == "O" && button9.getText() == "O") ||
            (button1.getText() == "O" && button4.getText() == "O" && button7.getText() == "O") ||
            (button2.getText() == "O" && button5.getText() == "O" && button8.getText() == "O") ||
            (button3.getText() == "O" && button6.getText() == "O" && button9.getText() == "O") ||
            (button1.getText() == "O" && button5.getText() == "O" && button9.getText() == "O") ||
            (button3.getText() == "O" && button5.getText() == "O" && button7.getText() == "O"))
        {
            Deshabilitar();
            Toast.makeText(this,R.string.message, Toast.LENGTH_SHORT).show();
        }

        if ((button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X") ||
            (button4.getText() == "X" && button5.getText() == "X" && button6.getText() == "X") ||
            (button7.getText() == "X" && button8.getText() == "X" && button9.getText() == "X") ||
            (button1.getText() == "X" && button4.getText() == "X" && button7.getText() == "X") ||
            (button2.getText() == "X" && button5.getText() == "X" && button8.getText() == "X") ||
            (button3.getText() == "X" && button6.getText() == "X" && button9.getText() == "X") ||
            (button1.getText() == "X" && button5.getText() == "X" && button9.getText() == "X") ||
            (button3.getText() == "X" && button5.getText() == "X" && button7.getText() == "X"))
        {
            Deshabilitar();
            Toast.makeText(this,R.string.message, Toast.LENGTH_SHORT).show();
        }

        if (turno == "O")
            turno = "X";
        else
            turno = "O";
    }

    public void Deshabilitar()
    {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }

    public void Habilitar()
    {
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        reset = (Button) findViewById(R.id.Reset);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button1.setText(turno);
                button1.setEnabled(false);

                Revisar();
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button2.setText(turno);
                button2.setEnabled(false);

                Revisar();
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button3.setText(turno);
                button3.setEnabled(false);

                Revisar();
            }
        });

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button4.setText(turno);
                button4.setEnabled(false);

                Revisar();
            }
        });

        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button5.setText(turno);
                button5.setEnabled(false);

                Revisar();
            }
        });

        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button6.setText(turno);
                button6.setEnabled(false);

                Revisar();
            }
        });

        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button7.setText(turno);
                button7.setEnabled(false);

                Revisar();
            }
        });

        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button8.setText(turno);
                button8.setEnabled(false);

                Revisar();
            }
        });

        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button9.setText(turno);
                button9.setEnabled(false);

                Revisar();
            }
        });

        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                turno = "X";

                Habilitar();

                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
            }
        });

    }
}
