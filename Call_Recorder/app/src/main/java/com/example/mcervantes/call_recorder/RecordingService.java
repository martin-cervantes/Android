package com.example.mcervantes.call_recorder;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RecordingService extends Service
{
    private MediaRecorder rec;
    private boolean recordsStarted;
    private File file;
    String path = "";

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startID)
    {
        //return super.onStartCommand(intent, flags, startID);
        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        Date date = new Date();

        CharSequence sdf = DateFormat.format("yyyy-MM-dd-hh-mm-ss", date.getTime());

        rec = new MediaRecorder();
        rec.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        rec.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        rec.setOutputFile(file.getAbsolutePath() + "/" + sdf + ".mp3");
        rec.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

        TelephonyManager manager = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        manager.listen(new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String phoneNumber)
            {
                super.onCallStateChanged(state, phoneNumber)
                {
                    if(TelephonyManager.CALL_STATE_IDLE == state && rec ==  null)
                    {
                        rec.stop();
                        rec.reset();
                        rec.release();

                        recordsStarted = false;

                        stopSelf();
                    }
                    else if(TelephonyManager.CALL_STATE_OFFHOOK == state)
                    {
                        try
                        {
                            rec.prepare();
                        }
                        catch (IOException ex)
                        {
                            ex.printStackTrace();
                        }

                        rec.start();

                        recordsStarted = true;
                    }
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);

        return START_STICKY;
    }

}
