package com.example.fileprovdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public final Uri MODELS_URI = Uri.parse("content://com.example.fileprovdemo_s1080418/exmodels/t.txt");
    InputStream is;
    DataInputStream dis;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);
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


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                tv.setText(str);
            }
        });
    }
}