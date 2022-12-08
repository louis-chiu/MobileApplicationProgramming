package com.example.icp09_s1080418;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class SRV1080418 extends Service {
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private static final String CH_ID = "MyMusicPlayer";
    public final Uri MEDIA_URI = Uri.parse("content://com.example.icp09_s1080418/exmedia/lucid_dream.mp3");


    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, MEDIA_URI);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService", "onDestroy");
        mediaPlayer.stop();
        super.onDestroy();
    }

}