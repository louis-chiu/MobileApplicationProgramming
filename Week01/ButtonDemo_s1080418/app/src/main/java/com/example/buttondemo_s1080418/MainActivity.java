package com.example.buttondemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button bt01=findViewById(R.id.btn01);
        Button bt02=findViewById(R.id.btn02);
        bt03=findViewById(R.id.btn03);

        View.OnClickListener btLTR=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt03.setText(((Button)v).getText());
            }
        };
        bt01.setOnClickListener(btLTR);
        bt02.setOnClickListener(btLTR);

    }
}