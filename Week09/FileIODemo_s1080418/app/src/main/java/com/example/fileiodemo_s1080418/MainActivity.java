package com.example.fileiodemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView tv02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fname = "test";

        TextView tv01 = findViewById(R.id.textView1);
        tv02 = findViewById(R.id.textView2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText et01 = findViewById(R.id.editText);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn01 = findViewById(R.id.button1);
        Button btn02 = findViewById(R.id.button2);


        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream out = openFileOutput(fname, MODE_PRIVATE);
                    OutputStreamWriter sw = new OutputStreamWriter(out);
                    sw.write(et01.getText().toString());
                    sw.flush();
                    sw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream in = openFileInput(fname);
                    InputStreamReader rr = new InputStreamReader(in);
                    char[] buffer = new char[256];
                    int count;
                    String s = "";
                    while((count =rr.read(buffer))>0){
                        String str = String.valueOf(buffer, 0, count);
                        s=s+str;
                    }
                    tv02.setText(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        InputStream is = this.getResources().openRawResource(R.raw.note);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String ss, str = "";
        try {
            while ((ss=br.readLine()) != null){
                str = ss+"\n"+str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv02.setText(str);



    }
}