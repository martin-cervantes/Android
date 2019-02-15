package com.example.super_duper_app;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button button;
    private static final ComponentName LAUNCHER_COMPONENT_NAME = new ComponentName("com.example.super_duper_app", "com.example.super_duper_app.Launcher");

    public static int REQUEST_PERMISSIONS = 1;
    boolean boolean_permission;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        fn_permission();
        listener();
    }

    private void init()
    {
        button = (Button) findViewById(R.id.button);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle(R.string.dialog_title);
        progressDialog.setMessage("Please wait...");

        if (isLauncherIconVisible())
        {
            button.setText(R.string.hide);
        }
        else
        {
            button.setText(R.string.unhide);
        }
    }

    private void listener()
    {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button:

                progressDialog.show();
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        progressDialog.dismiss();
                        if (isLauncherIconVisible())
                        {
                            button.setText(R.string.hide);
                        }
                        else
                        {
                            button.setText(R.string.unhide);
                        }
                    }
                }, 10000);


                if (boolean_permission)
                {

                    if (isLauncherIconVisible())
                    {
                        fn_hideicon();
                    }
                    else
                    {
                        fn_unhide();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), R.string.allow_permission, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private boolean isLauncherIconVisible()
    {
        int enabledSetting = getPackageManager().getComponentEnabledSetting(LAUNCHER_COMPONENT_NAME);
        return enabledSetting != PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
    }

    private void fn_hideicon()
    {
        getPackageManager().setComponentEnabledSetting(LAUNCHER_COMPONENT_NAME,
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
    }

    private void fn_unhide()
    {
        PackageManager p = getPackageManager();
        p.setComponentEnabledSetting(LAUNCHER_COMPONENT_NAME,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void fn_permission()
    {
        if ((ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED) ||
                (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED))
        {
            if ((ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.PROCESS_OUTGOING_CALLS)))
            {
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.PROCESS_OUTGOING_CALLS}, REQUEST_PERMISSIONS);
            }

            if ((ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.PROCESS_OUTGOING_CALLS)))
            {
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS}, REQUEST_PERMISSIONS);
            }
        }
        else
        {
            boolean_permission = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                boolean_permission = true;
            }
            else
            {
                Toast.makeText(getApplicationContext(), R.string.allow_permission, Toast.LENGTH_LONG).show();
            }
        }
    }
}