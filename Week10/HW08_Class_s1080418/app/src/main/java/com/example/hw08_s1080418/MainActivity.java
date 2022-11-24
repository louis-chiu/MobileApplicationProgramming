package com.example.hw08_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public final Uri MODELS_URI = Uri.parse("content://com.example.hw08_s1080418/exmodels/s1080418.txt");
    InputStream is;// /sdcard/Android/data/com.example.hw08_s1080418/files/emdl/s1080418.txt
    DataInputStream dis;
    String str = "";
    String [] str_arr, single_data;
    String id, name, pic, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv = findViewById(R.id.textView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn = findViewById(R.id.button);
        try {
            is = getContentResolver().openInputStream(MODELS_URI);
            dis = new DataInputStream(is);
            byte  buffer [] = new byte[dis.available()];
            for (int rlen = -9999;rlen != -1;) {
                rlen = dis.read(buffer);
                if (rlen != -1)
                    str = str + new String(buffer);
            }
            is.close();
            dis.close();
        } catch (FileNotFoundException ee){
            ee.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 處理 Data
        // contentProvider
        ContentValues valu = new ContentValues();
        str_arr = str.split("\n");
        for (int i = 0; i < str_arr.length  ; i++) {
            single_data = str_arr[i].split(",");
            id = single_data[0];
            name = single_data[1];
            pic = single_data[2];
            price =single_data[3];
            valu.put(MyContentProvider.name, single_data[1]);
            valu.put(MyContentProvider.pic, single_data[2]);
            valu.put(MyContentProvider.price, single_data[3]);

            getContentResolver().insert(MyContentProvider.CONTENT_URI, valu);
        }
        Toast.makeText(getBaseContext(),str_arr[14], Toast.LENGTH_LONG).show();



        // show data
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, str_arr.length, Toast.LENGTH_SHORT).show();
                tv.setText(str);
            }
        });
    }
}