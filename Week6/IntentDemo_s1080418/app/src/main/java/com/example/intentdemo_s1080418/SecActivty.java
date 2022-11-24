package com.example.intentdemo_s1080418;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecActivty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Intent sItt = this.getIntent();
        TextView tv = findViewById(R.id.textView2);
        tv.setText(sItt.getStringExtra("A")+"\t"+sItt.getStringExtra("B"));
        Button btn03=findViewById(R.id.button3);
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
