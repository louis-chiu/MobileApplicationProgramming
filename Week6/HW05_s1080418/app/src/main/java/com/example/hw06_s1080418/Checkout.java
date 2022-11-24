package com.example.hw06_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Checkout extends MainActivity {
    String s,  all_name, all_num, name ;
    String [] items_arr;
    String [][] item_arr;
    int total=0, num=0, price=0;
    Bundle bdDrink;
    Button btnReturn;
    Intent itt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        bdDrink = this.getIntent().getExtras();
        itt =new Intent(this,MainActivity.class);

        s = bdDrink.getString("Total");
        items_arr = s.split(";");
        item_arr = new String[items_arr.length][3];
        for(int i=0;i<items_arr.length;i++){
            item_arr[i] = items_arr[i].split(",");
        }
        TextView tvTotal = findViewById(R.id.textTotal);
        TextView tvName = findViewById(R.id.textName);
        TextView tvQuan = findViewById(R.id.textQuan);
        for(String [] item : item_arr){

            name = item[0];
            price = Integer.parseInt(item[1]);
            num = Integer.parseInt(item[2]);
            total += num * price;

            if(all_name == null )
                all_name = name;
            else
                all_name = all_name + "\n\n" + name;

            if(all_num == null)
                all_num = String.valueOf(num);
            else
                all_num = all_num + "\n\n" + num;
        }


        tvName.setText(all_name);
        tvQuan.setText(all_num);
        tvTotal.setText(String.valueOf(total));
        btnReturn = findViewById(R.id.button2);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Launcher.launch(itt);
            }
        });
    }
}