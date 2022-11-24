package com.example.intentdemo_s1080418;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private  Intent itt, itt02;
    EditText et01,et02;
    Bundle bd;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itt =new Intent(this,SecActivty.class);
        itt.putExtra("A","First Value");
        itt.putExtra("B", "Second Value");
        Button btn01 = findViewById(R.id.button1);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(itt);
            }
        });


        et01=findViewById(R.id.editTextNumberDecimal);
        et02=findViewById(R.id.editTextNumberDecimal3);
        itt02=new Intent(this, ThirdActivity.class);

        bd=new Bundle();
        Button btn02=findViewById(R.id.button2);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.putString("h", et01.getText().toString());
                bd.putString("w", et02.getText().toString());
                itt02.putExtras(bd);
                startActivityForResult(itt02, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView tv05=findViewById(R.id.textView5);
        tv05.setText(String.valueOf(data.getFloatExtra("res", 1)));
        super.onActivityResult(requestCode, resultCode, data);
    }
}