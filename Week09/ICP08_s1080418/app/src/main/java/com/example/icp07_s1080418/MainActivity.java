package com.example.icp07_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private List<FoodData> lstCNT =new ArrayList<>();
    myAdapter a1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView rclv = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager rclvLM = new LinearLayoutManager(this);



        //rclv.addOnItemTouchListener(new RecyclerItemClickListener());
        a1 = new myAdapter(MainActivity.this, lstCNT);
        rclv.setLayoutManager(rclvLM);
        rclv.setAdapter(a1);
        try {
            initData();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void initData() throws IOException {
        /* FoodData temp = new FoodData("1號餐", "地瓜蒙布朗",R.drawable.img1, "$80/單片");
        lstCNT.add(temp);

        temp = new FoodData("2號餐", "地瓜朵朵",R.drawable.img2, "$65/單片");
        lstCNT.add(temp);

        temp = new FoodData("3號餐", "美荔紫薯波士頓派",R.drawable.img3, "$65/單片");
        lstCNT.add(temp);
        temp = new FoodData("4號餐", "雙重可可軟餅乾",R.drawable.img4, "$68/單片");
        lstCNT.add(temp);
        temp = new FoodData("5號餐", "生酮乳酪捲",R.drawable.img5, "$25/單片");
        lstCNT.add(temp);
        temp = new FoodData("6號餐", "生酮伯爵茶乳酪捲",R.drawable.img6, "$65/單片");
        lstCNT.add(temp);
        temp = new FoodData("7號餐", "輕乳酪焦糖布丁蛋糕",R.drawable.img7, "$65/單片");
        lstCNT.add(temp);
        temp = new FoodData("8號餐", "焦糖核桃咖啡派",R.drawable.img8, "$60/單片");
        lstCNT.add(temp);
        temp = new FoodData("9號餐", "岩燒黃金乳酪派",R.drawable.img9, "$85/單片");
        lstCNT.add(temp);
        temp = new FoodData("10號餐", "粉紅泡泡慕斯蛋糕",R.drawable.img10, "$60/單片");
        lstCNT.add(temp);
        temp = new FoodData("11號餐", "檸檬脆皮泡芙",R.drawable.img11, "$40/單顆");
        lstCNT.add(temp);
        temp = new FoodData("12號餐", "深黑巧克脆皮泡芙",R.drawable.img12, "$40/單顆");
        lstCNT.add(temp);
        temp = new FoodData("13號餐", "義式摩卡脆皮泡芙",R.drawable.img13, "$40/單顆");
        lstCNT.add(temp);
        temp = new FoodData("14號餐", "草莓脆皮泡芙",R.drawable.img14, "$40/單顆");
        lstCNT.add(temp);
        temp = new FoodData("15號餐", "芝麻小嗜慕斯派",R.drawable.img15, "$70/單片");
        lstCNT.add(temp);*/

        InputStream is = this.getResources().openRawResource(R.raw.s1080418);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String ss, id, name, pic, price;
        String [] ss_arr;
        prefs = getSharedPreferences("s1080418", MODE_PRIVATE);
        SharedPreferences.Editor pEdit = prefs.edit();
        try {
            while ((ss=br.readLine()) != null){
                ss_arr = ss.split(",");
                id = ss_arr[0];
                name = ss_arr[1];
                pic =ss_arr[2];
                price = ss_arr[3];
                int pic_id = getResources().getIdentifier(pic, "drawable",getPackageName());

                pEdit.putString(id,name+","+pic+","+price);
                ss = prefs.getString(id,"null,null,null");
                ss_arr = ss.split(",");
                name = ss_arr[0];
                pic = ss_arr[1];
                price =ss_arr[2];
                pic_id = getResources().getIdentifier(pic, "drawable",getPackageName());

                FoodData temp = new FoodData(id,name,pic_id,price);
                lstCNT.add(temp);
                pEdit.apply();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }









    }
}