package com.example.uieventdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv01=findViewById(R.id.textView);
        //
        Button btn01 = findViewById(R.id.button);


        //
        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv01.setText("Testing");
                Toast.makeText(MainActivity.this, "Button is clicked", Toast.LENGTH_LONG).show();
                Log.d("Chiu", "Clicked");
            }
        });
    }
}