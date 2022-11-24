package com.example.acccontprov;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Uri CONTENT_URI = Uri.parse("content://com.example.custcontprovider/users");
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv = findViewById(R.id.tv);
        Cursor cr = getContentResolver().query(CONTENT_URI, null, null,null,null);
        if (cr.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            while (!cr.isAfterLast()){
                stringBuilder.append("\n" + cr.getString(cr.getColumnIndex("id")) + "-" + cr.getString(cr.getColumnIndex("name")));
                cr.moveToNext();
            }
            tv.setText(stringBuilder);
        }else {
            tv.setText("Nothing Found");
        }
    }
}