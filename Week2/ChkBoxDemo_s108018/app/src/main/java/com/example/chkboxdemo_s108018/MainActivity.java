package com.example.chkboxdemo_s108018;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox cb01, cb02, cb03;
    int amt, qt;
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb01 = findViewById(R.id.checkBox1);
        cb02 = findViewById(R.id.checkBox2);
        cb03 = findViewById(R.id.checkBox3);

        et = findViewById(R.id.editTextNumber);
        Button bt = findViewById(R.id.button);
        tv = findViewById(R.id.textView);


        //anonymous
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qt=Integer.valueOf(et.getText().toString());
                if(cb01.isChecked())
                    amt += 250*qt;
                if(cb02.isChecked())
                    amt += 275*qt;
                if(cb03.isChecked())
                    amt += 350*qt;
                tv.setText(String.valueOf(amt));
            }
        });

    }
}