package com.example.imgbtndemo_s1080418;

import static com.example.imgbtndemo_s1080418.R.id.imageButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imgBtn;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn= findViewById(R.id.imageButton);
        View.OnClickListener LTR = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count % 2 == 0)
                    imgBtn.setImageDrawable(getResources().getDrawable(R.drawable.front, null));
                else
                    imgBtn.setImageDrawable(getResources().getDrawable(R.drawable.back, null));
                count++;
            }
        };

        imgBtn.setOnClickListener(LTR);
    }
}