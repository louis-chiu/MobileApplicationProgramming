package com.example.fragdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        FragmentManager fn = getSupportFragmentManager();

        TextView tv01 = findViewById(R.id.textView1);
        Button btn01 = findViewById(R.id.button1);
        Button btn02 = findViewById(R.id.button2);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn.beginTransaction()
                        .replace(R.id.fragmentContainerView,BlankFragment02.class, null)
                        .commit();

            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment01 bf01 = (BlankFragment01) fn.findFragmentById(R.id.fragmentContainerView);
                bf01.setFgTVText("Text Change from MainActivity");
            }
        });


    }

}