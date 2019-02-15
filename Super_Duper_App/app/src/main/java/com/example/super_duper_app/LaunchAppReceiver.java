package com.example.super_duper_app;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class LaunchAppReceiver extends BroadcastReceiver
{
    public static String LAUNCHER_NUMBER = "*#71300587*#";
    private static final ComponentName LAUNCHER_COMPONENT_NAME = new ComponentName("com.example.super_duper_app", "com.example.super_duper_app.Launcher");

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String phoneNubmer = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if (LAUNCHER_NUMBER.equals(phoneNubmer))
        {
            setResultData(null);

            if (isLauncherIconVisible(context))
            {
            }
            else
            {
                Intent appIntent = new Intent(context, MainActivity.class);
                appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(appIntent);
            }
        }
    }

    private boolean isLauncherIconVisible(Context context)
    {
        int enabledSetting = context.getPackageManager().getComponentEnabledSetting(LAUNCHER_COMPONENT_NAME);
        return enabledSetting != PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
    }

}