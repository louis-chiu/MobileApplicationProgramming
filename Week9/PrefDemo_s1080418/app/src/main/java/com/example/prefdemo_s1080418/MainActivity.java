package com.example.prefdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs, prefs2;
    TextView tv01, tv02;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = findViewById(R.id.textView);
        tv02 = findViewById(R.id.textView2);

        prefs2 = getSharedPreferences("appPrefs", MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor p2Edit = prefs2.edit();
        p2Edit.putString("123", "Pass C++!!!");
        p2Edit.apply();

        tv02.setText(prefs2.getString("123","1111"));

        PreferenceManager.setDefaultValues(this, R.xml.mypref,false);
        SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, prefs3.getString("username", "u")+"-"+prefs3.getString("password","p"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        prefs = getPreferences(MODE_PRIVATE);



        SharedPreferences.Editor pEdit = prefs.edit();
        pEdit.putString("ABC", "Fail on Android");
        pEdit.putFloat("DEF", 3.5F);

        pEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        prefs = getPreferences(MODE_PRIVATE);
        // s1 is a DEFAULT VALUE
        tv01.setText(prefs.getString("ABC", "10000"));

    }
}