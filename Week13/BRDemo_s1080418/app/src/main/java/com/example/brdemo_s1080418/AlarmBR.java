package com.example.brdemo_s1080418;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "The Alarm is received", Toast.LENGTH_LONG).show();
    }
}