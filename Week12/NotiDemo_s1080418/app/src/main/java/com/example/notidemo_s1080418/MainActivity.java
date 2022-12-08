package com.example.notidemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 須設定 channel
        String chId = "channel_1";
        Notification.Builder notiBlr = new Notification.Builder(this, chId);
        Intent it = new Intent(this, NotiAct.class);
        it.putExtra("NOTIFICATION_ID", 1234);
        PendingIntent pi= PendingIntent.getActivity(this, 0, it, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notiFm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 自行查詢部分
        NotificationChannel channel = new NotificationChannel(chId, "Testing", NotificationManager.IMPORTANCE_HIGH);
        notiFm.createNotificationChannel(channel);
        //

        notiBlr.setContentTitle("NotiDemo")
                .setContentText("Testing Notification!!!")
                .setCategory(Notification.CATEGORY_EVENT)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pi)
                .setAutoCancel(true);
        Notification noti = notiBlr.build();

        notiFm.notify(1234, noti);
    }
}