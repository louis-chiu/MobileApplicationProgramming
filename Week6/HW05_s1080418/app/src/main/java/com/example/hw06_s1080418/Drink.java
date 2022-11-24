package com.example.hw06_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Drink extends MainActivity {
    Bundle bd, bdFood;
    String s, s5,s6,s7,s8;
    CheckBox cb5 ,cb6, cb7, cb8;
    TextView tv5, tv6, tv7, tv8;
    TextView  p5,p6,p7, p8;
    EditText et5, et6, et7, et8;
    String temp="";
    Intent itt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);


        et5 = findViewById(R.id.editQuantities5);
        et6 = findViewById(R.id.editQuantities6);
        et7 = findViewById(R.id.editQuantities7);
        et8 = findViewById(R.id.editQuantities8);


        tv5 = findViewById(R.id.textItemName5);
        tv6 = findViewById(R.id.textItemName6);
        tv7 = findViewById(R.id.textItemName7);
        tv8 = findViewById(R.id.textItemName8);


        p5 = findViewById(R.id.textPrice5);
        p6 = findViewById(R.id.textPrice6);
        p7 = findViewById(R.id.textPrice7);
        p8 = findViewById(R.id.textPrice8);
        bd = new Bundle();
        itt =new Intent(this,Checkout.class);
        bdFood = this.getIntent().getExtras();

        Button btnNext = findViewById(R.id.button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb5.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s5 = tv5.getText().toString() + "," + p5.getText().toString() + "," + et5.getText().toString();
                    if (s == null)
                        s = s5;
                    else
                        s = s + ";" +s5;
                }if(cb6.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s6 = tv6.getText().toString() + "," + p6.getText().toString() + "," + et6.getText().toString();
                    if (s == null)
                        s = s6;
                    else
                        s = s + ";" +s6;
                }if(cb7.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s7 = tv7.getText().toString() + "," + p7.getText().toString() + "," + et7.getText().toString();
                    if (s == null)
                        s = s7;
                    else
                        s = s + ";" +s7;
                }if(cb8.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s8 = tv8.getText().toString() + "," + p8.getText().toString() + "," + et8.getText().toString();
                    if (s == null)
                        s = s8;
                    else
                        s = s + ";" +s8;
                }


                temp = bdFood.getString("Food");

                if (s == null)
                    s = temp;
                else if(temp ==null)
                    s = s;
                else
                    s = temp + ";" +s;
                bd.putString("Total", s);
                itt.putExtras(bd);
                Launcher.launch(itt);
            }
        });
    }
}