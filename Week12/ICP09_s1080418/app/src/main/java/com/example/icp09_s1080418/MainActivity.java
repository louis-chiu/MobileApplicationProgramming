package com.example.icp09_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.GnssAntennaInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        TextView tv = findViewById(R.id.tv);
        int btn1_id= btn1.getId();
        int btn2_id = btn2.getId();
        Intent intent = new Intent(MainActivity.this, SRV1080418.class);
        View.OnClickListener btnLstr=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == btn1_id){
                    tv.setText("1");
                    startService(intent);
                }else if(view.getId() == btn2_id){
                    tv.setText("2");
                    stopService(intent);
                }
            }
        };

        btn1.setOnClickListener(btnLstr);
        btn2.setOnClickListener(btnLstr);

    }
}