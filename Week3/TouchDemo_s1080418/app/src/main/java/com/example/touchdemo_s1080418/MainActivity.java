package com.example.touchdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout fl01 = findViewById(R.id.fl);
        tv = findViewById(R.id.textView);
        iv = findViewById(R.id.imageView);

        fl01.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int act= motionEvent.getAction();
                switch (act){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        tv.setText(motionEvent.getX()+"\n"+motionEvent.getY());
                        iv.setX(motionEvent.getX() - iv.getWidth()/2);
                        iv.setY(motionEvent.getY() - iv.getHeight()/2);
                        break;
                }
                return true;
            }
        });
    }

}