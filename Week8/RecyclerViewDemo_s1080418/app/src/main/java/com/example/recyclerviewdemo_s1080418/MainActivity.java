package com.example.recyclerviewdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CntData> lstCNT =new ArrayList<>();
    myAdapter a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView rclv = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager rclvLM = new LinearLayoutManager(this);
        rclv.setLayoutManager(rclvLM);



        a1 = new myAdapter(lstCNT);
        rclv.setAdapter(a1);

        initData();
        lstCNT.remove(0);
    }

    private void initData(){
        CntData temp = new CntData("John", "123456", "aa@gmail.ocm");
        lstCNT.add(temp);

        temp = new CntData("Joe", "123457", "bb@gmail.com");
        lstCNT.add(temp);

        temp = new CntData("Tom", "123458", "cc@gmail.com");
        lstCNT.add(temp);

        temp = new CntData("Jack", "123459", "dd@gmail.com");
        lstCNT.add(temp);

        temp = new CntData("Jay", "123460", "ee@gmail.com");
        lstCNT.add(temp);

        temp = new CntData("Alan", "123461", "ff@gmail.com");
        lstCNT.add(temp);

        temp = new CntData("Andrew", "123462", "gg@gmail.com");
        lstCNT.add(temp);

        a1.notifyDataSetChanged();

    }
}