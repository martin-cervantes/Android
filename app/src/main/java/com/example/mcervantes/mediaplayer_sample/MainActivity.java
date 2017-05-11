package com.example.mcervantes.mediaplayer_sample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.comedia);

        Button playButton = (Button)findViewById(R.id.play_button);

        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();

                Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_SHORT).show();
            }
        });

        Button pauseButton = (Button)findViewById(R.id.play_button);

        pauseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();

                Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
