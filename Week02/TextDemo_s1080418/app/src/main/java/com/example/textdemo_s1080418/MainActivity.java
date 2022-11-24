package com.example.textdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText et01, et02;
        TextView tv01, tv02,tv03, tv04, tv05;
        Button btn01;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = findViewById(R.id.textView1);
        tv02 = findViewById(R.id.textView2);
        tv03 = findViewById(R.id.textView3);
        tv04 = findViewById(R.id.textView4);
        tv05 = findViewById(R.id.textView5);

        et01 = findViewById(R.id.editText1);
        et02 = findViewById(R.id.editText2);

        Button btn = findViewById(R.id.button);
        View.OnClickListener btnLTR = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ht = Integer.valueOf(et01.getText().toString()) / 100.0;
                double wt = Integer.valueOf(et02.getText().toString());
                double bmi = wt/(ht*ht);
                tv04.setText(String.valueOf(bmi));
            }
        };
        btn.setOnClickListener(btnLTR);

        TextWatcher tLTR = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tv05.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        et01.addTextChangedListener(tLTR);
        et02.addTextChangedListener(tLTR);
    }
}