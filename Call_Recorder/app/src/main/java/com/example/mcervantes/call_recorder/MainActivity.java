package com.example.mcervantes.call_recorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Switch startAndStop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAndStop = (Switch) findViewById(R.id.toggleButton);

    }

    public void toogleButton(View view)
    {
        boolean checked = ((Switch)view).isChecked();

        if(checked)
        {
            Intent intent = new Intent(this,RecordingService.class);
            startService(intent);

            Toast.makeText(getApplicationContext(), "Call Recording STARTED", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this,RecordingService.class);
            stopService(intent);

            Toast.makeText(getApplicationContext(), "Call Recording STOPED", Toast.LENGTH_SHORT).show();
        }
    }
}
