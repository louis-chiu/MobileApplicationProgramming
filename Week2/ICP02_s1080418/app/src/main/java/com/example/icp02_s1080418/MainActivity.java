package com.example.icp02_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.FloatProperty;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button [] num_arr = new Button[10];
    Button [] opr_arr = new Button[4];
    Button btnEql, btnDel, btnClr, btnDot;
    Button opr;
    RadioGroup rg;
    RadioButton rbD, rbB, rbH;
    TextView tv;
    ImageView iv;
    float tol1, tol2;
    boolean status,eql_status;
    int rb_status;
    String temp;
    CharSequence cur_str;

    //16進制轉10進制
    public static String hexToDecimal(String num){
        String s_temp;
        float res = 0f ;
        num = num.substring(2);
        for(int i = 0;i<num.length();i++) {

            switch (num.substring(i,i+1)){
                case "a":
                    s_temp="10";
                    break;
                case "b":
                    s_temp="11";
                    break;
                case "c":
                    s_temp="12";
                    break;
                case "d":
                    s_temp="13";
                    break;
                case "e":
                    s_temp="14";
                    break;
                case "f":
                    s_temp="15";
                    break;
                default:
                    s_temp = num.substring(i,i+1);
                    break;
            }
            res += Float.valueOf(s_temp) * (float)Math.pow(16, -(i+1));
        }
        return String.valueOf(res).substring(2);
    }

    //2進制轉10進制
    public static String binaryToDecimal(float num){
        String s_num;
        float res = 0f ;
        s_num = String.valueOf(num);
        s_num = s_num.substring(2);
        for(int i = 0;i<s_num.length();i++) {
            res += Float.valueOf(s_num.substring(i,i+1)) * (float)Math.pow(2, -(i+1));
        }
        return String.valueOf(res).substring(2);
    }
    //處理小數點部分轉二進位
    public static String decimalToBinary(float num){
        String s="";
        do{
            num*=2;
            if(num >= 1f){
                s+="1";
                num -= 1f;
            }else{
                s+="0";
            }
        }while(num!=0);
        return s;
    }

    //處理小數點部分轉十六進位
    public static String decimalToHex(float num){
        String s="";
        do{
            num*=16;
            if(num >= 1f){
                if((int)num<10) {
                    s += (int) num;
                }else if((int)num==10){
                    s += "a";
                }else if((int)num==11){
                    s += "b";
                }else if((int)num==12){
                    s += "c";
                }else if((int)num==13){
                    s += "d";
                }else if((int)num==14){
                    s += "e";
                }else if((int)num==15){
                    s += "f";
                }
                num -= (int) num;
            }else{
                s+="0";
            }
        }while(num!=0);
        return s;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        btnDot= findViewById(R.id.buttonDot);
        btnDel = findViewById(R.id.buttonDel);
        btnEql = findViewById(R.id.buttonEql);
        btnClr = findViewById(R.id.buttonClr);
        rbD = findViewById(R.id.radioButton1);
        rbB = findViewById(R.id.radioButton2);
        rbH = findViewById(R.id.radioButton3);
        rb_status = rbD.getId();
        rg = findViewById(R.id.radioGroup);
        iv = findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.decimal);
        //
        View.OnClickListener num_btLTR = new View.OnClickListener() {


            //number LTR
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                //tv 設置數字
                if (!status) {
                    cur_str = tv.getText();
                } else {
                    cur_str = "";
                }
                tv.setText((String) cur_str + ((Button) view).getText());

                status=false;
            }
        };

        View.OnClickListener opr_btLTR = new View.OnClickListener() {
            //operator LTR
            @Override
            public void onClick(View view) {
                if(tv.getText().length()!=0)
                    tol1 = Float.parseFloat(tv.getText().toString());

                //Toast.makeText(MainActivity.this, sign,Toast.LENGTH_LONG).show();
                //+ - * /
                opr = ((Button)view);
                status = true;
                eql_status=false;
            }
        };

        btnDot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                cur_str = tv.getText();
                tv.setText((String)cur_str + ".");
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv.getText().length()!=0)
                    tol2 = Float.parseFloat(tv.getText().toString());
                if(opr == opr_arr[0]&& !eql_status){
                    tol1 += tol2;
                }else if (opr == opr_arr[1]&& !eql_status){
                    tol1 -= tol2;
                }else if (opr == opr_arr[2]&& !eql_status){
                    tol1 *= tol2;
                }else if (opr == opr_arr[3]&& !eql_status){
                    if(tol2 != 0f)
                        tol1 /= tol2;
                    else
                        Toast.makeText(MainActivity.this,"0 can not be denominator!",Toast.LENGTH_LONG).show();
                }
                if(tol1 == (int)tol1)
                    temp = String.valueOf((int)tol1);
                else
                    temp = String.valueOf(tol1);
                tv.setText(temp);
                eql_status=true;
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv.getText().length() != 0) {
                    cur_str = tv.getText();
                    cur_str = cur_str.toString().substring(0, cur_str.length() - 1);
                    tv.setText(cur_str);
                }
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("0");
                status = true;
                eql_status=false;
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                float num, num_dec;
                int num_int;
                String output="",output_dec ,str_num, hex_num_int, hex_num_dec;
                String [] split_num={};
                if(i == rbD.getId()) {
                    iv.setImageResource(R.drawable.decimal);
                    if(rb_status == rbB.getId() && tv.getText().length() != 0){
                        str_num = tv.getText().toString();
                        if(!str_num.contains(".")){
                            output = String.valueOf(Integer.parseInt(str_num, 2));
                        }else {
                            split_num = str_num.split("\\.");
                            num_int = Integer.valueOf(split_num[0]);
                            num_dec = Float.valueOf("0." + split_num[1]);
                            //整數部分 + "." + 小數部分 分別轉為十進制
                            output = Integer.parseInt(String.valueOf(num_int), 2) + "." + binaryToDecimal(num_dec);
                        }
                    }else if(rb_status == rbH.getId()  && tv.getText().length() != 0){
                        str_num = tv.getText().toString();
                        if(!str_num.contains(".")){
                            output = String.valueOf(Integer.parseInt(str_num, 16));
                        }else {
                            split_num = str_num.split("\\.");
                            hex_num_int = split_num[0];
                            hex_num_dec = "0."+split_num[1];
                            //整數部分 + "." + 小數部分 分別轉為十進制
                            output = Integer.parseInt(String.valueOf(hex_num_int), 16) + "." + hexToDecimal(hex_num_dec);
                        }
                    }
                    tv.setText(output);

                    for(int j = 2; j < 10; j++){
                        num_arr[j].setEnabled(true);
                    }
                    for(int j = 2; j < 4; j++){
                        opr_arr[j].setEnabled(true);
                    }
                    rb_status = i;
                }
                if(i == rbB.getId()){
                    iv.setImageResource(R.drawable.binary);
                    if(rb_status == rbD.getId() && tv.getText().length() != 0){
                        str_num = tv.getText().toString();
                        if(!str_num.contains(".")){
                            output = Integer.toString(Integer.valueOf(str_num), 2);
                        }else{
                            split_num = str_num.split("\\.");
                            num_int = Integer.valueOf(split_num[0]);
                            num_dec = Float.valueOf("0." + split_num[1]);
                            //整數部分 + "." + 小數部分 分別轉為二進制
                            output = Integer.toString(num_int, 2) + "." + decimalToBinary(num_dec);
                        }
                    }else if(rb_status == rbH.getId() && tv.getText().length() != 0){
                        str_num = tv.getText().toString();
                        if(!str_num.contains(".")){
                            output_dec = String.valueOf(Integer.parseInt(str_num, 16));
                        }else{
                            split_num = str_num.split("\\.");
                            hex_num_int = split_num[0];
                            hex_num_dec = "0."+split_num[1];
                            //整數部分 + "." + 小數部分 分別轉為十進制
                            output_dec = Integer.parseInt(String.valueOf(hex_num_int), 16) + "." + hexToDecimal(hex_num_dec);
                        }

                        if(!output_dec.contains(".")){
                            output = Integer.toString(Integer.valueOf(output_dec), 2);
                        }else {
                            split_num = output_dec.split("\\.");
                            num_int = Integer.valueOf(split_num[0]);
                            num_dec = Float.valueOf("0." + split_num[1]);
                            //整數部分 + "." + 小數部分 分別轉為二進制
                            output = Integer.toString(num_int, 2) + "." + decimalToBinary(num_dec);
                        }
                    }
                    tv.setText(output);

                    for(int j = 2; j < 10; j++){
                        num_arr[j].setEnabled(false);
                        //num_arr[j].setText("X");

                    }
                    for(int j = 2; j < 4; j++){
                        opr_arr[j].setEnabled(false);
                        //opr_arr[j].setText("X");

                    }
                    rb_status = i;
                }
                if(i == rbH.getId()) {
                    iv.setImageResource(R.drawable.hex);
                    if(rb_status == rbD.getId() && tv.getText().length() != 0){
                        str_num = tv.getText().toString();
                        if(!str_num.contains(".")){
                            output = Integer.toString(Integer.valueOf(str_num), 16);
                        }else {
                            split_num = str_num.split("\\.");
                            num_int = Integer.valueOf(split_num[0]);
                            num_dec = Float.valueOf("0." + split_num[1]);
                            //整數部分 + "." + 小數部分 分別轉為十六進制
                            output = Integer.toString(num_int, 16) + "." + decimalToHex(num_dec);
                        }
                    }else if(rb_status == rbB.getId() && tv.getText().length() != 0){
                        str_num = tv.getText().toString();
                        if(!str_num.contains(".")){
                            output_dec = String.valueOf(Integer.parseInt(str_num, 2));
                        }else {
                            split_num = str_num.split("\\.");
                            num_int = Integer.valueOf(split_num[0]);
                            num_dec = Float.valueOf("0." + split_num[1]);
                            //整數部分 + "." + 小數部分 分別轉為十進制
                            output_dec = Integer.parseInt(String.valueOf(num_int), 2) + "." + binaryToDecimal(num_dec);
                        }

                        if(!output_dec.contains(".")){
                            output = Integer.toString(Integer.parseInt(output_dec), 16);
                        }else {
                            split_num = output_dec.split("\\.");
                            num_int = Integer.valueOf(split_num[0]);
                            num_dec = Float.valueOf("0." + split_num[1]);

                            //整數部分 + "." + 小數部分 分別轉為十六進制
                            output = Integer.toString(num_int, 16) + "." + decimalToHex(num_dec);
                        }
                    }
                    tv.setText(output);

                    for(int j = 2; j < 10; j++){
                        num_arr[j].setEnabled(true);
                    }
                    for(int j = 2; j < 4; j++){
                        opr_arr[j].setEnabled(true);
                    }
                    rb_status = i;
                }
            }
        });

        for (int i = 0; i < 10; i++){
            String btn = "button" + (i);
            int btn_id = getResources().getIdentifier(btn,"id",getPackageName());
            num_arr[i] = findViewById(btn_id);
            num_arr[i].setOnClickListener(num_btLTR);
        }
        for (int j = 11; j < 15; j++){
            String btn = "button" + (j);
            int btn_id = getResources().getIdentifier(btn,"id",getPackageName());
            opr_arr[j-11] = findViewById(btn_id);
            opr_arr[j-11].setOnClickListener(opr_btLTR);
        }





    }
}