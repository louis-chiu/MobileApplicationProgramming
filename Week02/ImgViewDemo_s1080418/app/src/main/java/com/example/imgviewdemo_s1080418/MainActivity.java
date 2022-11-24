package com.example.imgviewdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioButton rb01, rb02;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = findViewById(R.id.radiogroup);
        rb01 = findViewById(R.id.radioButton1);
        rb02 = findViewById(R.id.radioButton2);
        iv = findViewById(R.id.imageView);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == rb01.getId())
                    iv.setImageResource(R.drawable.mouse);
                if(i == rb02.getId())
                    iv.setImageResource(R.drawable.rabbit);
            }
        });
    }
}