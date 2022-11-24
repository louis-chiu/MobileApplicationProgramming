package com.example.custcontprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues valu = new ContentValues();
        valu.put(MyContentProvider.name, "YRChiu");
        valu.put(MyContentProvider.name, "EM2Lab");
        getContentResolver().insert(MyContentProvider.CONTENT_URI, valu);
        Toast.makeText(getBaseContext(), valu.toString(), Toast.LENGTH_LONG).show();
    }
}