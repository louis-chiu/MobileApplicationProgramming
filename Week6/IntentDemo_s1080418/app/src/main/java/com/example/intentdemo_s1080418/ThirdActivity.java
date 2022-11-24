package com.example.intentdemo_s1080418;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    Intent rpInt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bd02=this.getIntent().getExtras();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv04 = findViewById(R.id.textView4);

        tv04.setText(bd02.getString("h")+"--"+bd02.getString("w"));
        int ww=Integer.valueOf(bd02.getString("w"));
        float hh=Integer.valueOf(bd02.getString("h"))/100f;
        float bmi=(ww/(hh*hh));

        Button btn04=findViewById(R.id.button4);

        rpInt = new Intent();
        rpInt.putExtra("res",bmi);
        setResult(0, rpInt);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rpInt.putExtra("res", bmi);
                setResult(0,rpInt);
                finish();
            }
        });
    }
}
