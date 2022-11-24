package com.example.icp1_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    int [] arr= new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //int btn1id = getResources().getIdentifier("button 1","id",getPackageName());
        Button bt01 = findViewById(R.id.button1);


        View.OnClickListener btLTR=new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(count % 2 ==0)
                    bt01.setText("O");
                else
                    bt01.setText("x");
            }
        };
        bt01.setOnClickListener(btLTR);

    }
}