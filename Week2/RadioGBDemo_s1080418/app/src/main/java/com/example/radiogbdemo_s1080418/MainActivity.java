package com.example.radiogbdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton rb01, rb02, rb03;
    TextView tv02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = findViewById(R.id.radioGroup);

        rb01 = findViewById(R.id.radioButton1);
        rb02 = findViewById(R.id.radioButton2);
        rb03 = findViewById(R.id.radioButton3);

        tv02 = findViewById(R.id.textView2);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == rb01.getId())
                    tv02.setText(rb01.getText());
                if(i == rb02.getId())
                    tv02.setText(rb02.getText());
                if(i == rb03.getId())
                    tv02.setText(rb03.getText());
            }
        });

    }
}