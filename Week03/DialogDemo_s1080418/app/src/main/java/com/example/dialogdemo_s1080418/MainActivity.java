package com.example.dialogdemo_s1080418;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn2;
    String [] items= {"Android", "iOS", "Windows Mobile"};
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1, btn3, btn4;
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);


        btn1.setOnClickListener(view -> {
            AlertDialog.Builder cfm = new AlertDialog.Builder(MainActivity.this);
            cfm.setTitle("Testing Confirmation")
                    .setMessage("This is a message Test!!!")
                    .setNegativeButton("OK",null)
                    .setPositiveButton("Cancel",null)
                    .create()
                    .show();
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder sc = new AlertDialog.Builder(MainActivity.this);

                String [] options = {"Red", "Yellow", "Green"};
                sc.setItems(options,new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i){
                                    case 0:
                                        btn2.setBackgroundColor(Color.RED);
                                        break;
                                    case 1:
                                        btn2.setBackgroundColor(Color.YELLOW);
                                        break;
                                    case 2:
                                        btn2.setBackgroundColor(Color.GREEN);
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create()
                        .show();
            }
        });

        tv = findViewById(R.id.textView);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean [] itemChecked = new boolean[items.length];
                AlertDialog.Builder sm = new AlertDialog.Builder(MainActivity.this);
                sm.setMultiChoiceItems(items, itemChecked, null)

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String msg = "";
                                for (int j = 0;j<items.length;j++){
                                    if(itemChecked[j])
                                        msg += items[j] + "\t";
                                }
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                                tv.setText(msg);
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .create()
                        .show();
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFrag lf = new LoginFrag();
                int a = lf.a;
                lf.show(getFragmentManager(), "Testing");
            }
        });
    }
}