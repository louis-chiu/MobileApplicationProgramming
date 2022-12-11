package com.example.brdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn01 = findViewById(R.id.button);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itt01 = new Intent();
                itt01.setAction("com.example.broadcast.MY_NOTIFICATION");
                sendBroadcast(itt01);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btn02 = findViewById(R.id.button2);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et01 = findViewById(R.id.editTextTextPersonName);
                Long seconds = Long.parseLong(et01.getText().toString());
                Intent it = new Intent(MainActivity.this, AlarmBR.class);
                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 1234, it, 0);
                AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (seconds * 1000),pi);
            }
        });

    }
}