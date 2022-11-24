package com.example.icp05_s1080418;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fn;
    TextView tv01, tv02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fn = getSupportFragmentManager();

        //top text
        tv01 = findViewById(R.id.tv01);

        //bottom text
        tv02 = findViewById(R.id.tv02);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //將 menu 與主程式串接
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.help:

                break;
            case R.id.game:
                tv01.setText("Tic-Tac-Toe");
                tv02.setVisibility(View.VISIBLE);
                fn.beginTransaction()
                        .replace(R.id.fragmentContainerView,TicTacToe.class, null)
                        .commit();

                break;
            case R.id.calc:
                tv01.setText("Calculator");

                fn.beginTransaction()
                        .replace(R.id.fragmentContainerView,Calculator.class, null)
                        .commit();
                break;



        }

        return super.onOptionsItemSelected(item);
    }

}