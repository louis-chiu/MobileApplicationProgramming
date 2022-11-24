package com.example.icp1_s1080418;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    Button [] btn_arr= new Button[9];
    //Vertical, Horizontal, Slanting
    boolean game_status = true;
    TextView tv01;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv01 = findViewById(R.id.textView);

        View.OnClickListener btLTR=new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (((Button) v).getText().length() == 0 && game_status) {
                    if (count % 2 == 0) {
                        ((Button) v).setText("O");
                    } else {
                        ((Button) v).setText("X");
                    }
                count++;
                }

                // Slanting, Vertical, Horizontal
                boolean s1 = btn_arr[0].getText() == btn_arr[4].getText() && btn_arr[0].getText() == btn_arr[8].getText() && btn_arr[0].getText().length() != 0;
                boolean s2 = btn_arr[2].getText() == btn_arr[4].getText() && btn_arr[2].getText() == btn_arr[6].getText() && btn_arr[2].getText().length() != 0;
                boolean v1 = btn_arr[0].getText() == btn_arr[1].getText() && btn_arr[0].getText() == btn_arr[2].getText() && btn_arr[0].getText().length() != 0;
                boolean v2 = btn_arr[3].getText() == btn_arr[4].getText() && btn_arr[3].getText() == btn_arr[5].getText() && btn_arr[3].getText().length() != 0;
                boolean v3 = btn_arr[6].getText() == btn_arr[7].getText() && btn_arr[6].getText() == btn_arr[8].getText() && btn_arr[6].getText().length() != 0;
                boolean h1 = btn_arr[0].getText() == btn_arr[3].getText() && btn_arr[0].getText() == btn_arr[6].getText() && btn_arr[0].getText().length() != 0;
                boolean h2 = btn_arr[1].getText() == btn_arr[4].getText() && btn_arr[1].getText() == btn_arr[7].getText() && btn_arr[1].getText().length() != 0;
                boolean h3 = btn_arr[2].getText() == btn_arr[5].getText() && btn_arr[2].getText() == btn_arr[8].getText() && btn_arr[2].getText().length() != 0;
                boolean cdt = s1 || s2 || v1 || v2 || v3 || h1 || h2 || h3;

                if (cdt) {

                    if (((Button) v).getText() == "O" && ((Button) v).isClickable()) {
                        tv01.setText("O win!");
                        game_status = false;
                    }

                    if (((Button) v).getText() == "X" && ((Button) v).isClickable()) {
                        tv01.setText("X win!");
                        game_status = false;
                    }
                }

                //遊戲結束 將所有按鈕都 unClickable
                if(!game_status) {
                    for (i = 0; i < 9; i++) {
                        btn_arr[i].setClickable(false);
                    }
                }

                //將已按過的設置為 unClickable
                ((Button) v).setClickable(false);
            }
        };
        for (i = 0; i < 9; i++){
            String btn = "button" + (i+1);
            int btn_id = getResources().getIdentifier(btn,"id",getPackageName());
            btn_arr[i] = findViewById(btn_id);
            btn_arr[i].setOnClickListener(btLTR);

        }


    }
    public boolean WinOrLose{

    }
}