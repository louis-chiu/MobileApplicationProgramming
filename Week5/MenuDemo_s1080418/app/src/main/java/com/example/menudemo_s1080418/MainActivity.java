package com.example.menudemo_s1080418;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionMode am;
    TextView tv01, tv02;
    PopupMenu pmTv01,pmTv02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout cl = findViewById(R.id.ConstraintLayout);
        cl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(am!=null)
                    return false;
                am=MainActivity.this.startActionMode(amc);
                Toast.makeText(MainActivity.this, "testing", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        tv01=findViewById(R.id.textView1);
        tv02=findViewById(R.id.textView2);
        pmTv01 = new PopupMenu(this,tv01);
        pmTv02 = new PopupMenu(this,tv02);
        tv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            pmTv01.show();
            }
        });

        PopupMenu.OnMenuItemClickListener pmLTR= new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.pm01:
                    case R.id.pm02:
                        tv02.setText(tv01.getText());
                        break;
                    default:
                        return true;
                }
                return false;
            }
        };


        pmTv01.inflate(R.menu.pmenu);
        pmTv01.setOnMenuItemClickListener(pmLTR);


        pmTv02.inflate(R.menu.pmenu);


    }

    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //將 menu 與主程式串接
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        menu.add(10, 5, 1, "MenuAddItem01");
        menu.add(10, 6, 0, "MenuAddItem02");

        return super.onCreateOptionsMenu(menu);

    }

    //


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.color:
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                break;
            case R.id.setting:

                break;
            case R.id.calc:
                break;
            case R.id.car:
                break;
            case 5:
                TextView tv = findViewById(R.id.textView1);
                tv.setText(String.valueOf(item.getItemId()));
                break;
            case 6:

                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //Context Menu -ActionMode
    ActionMode.Callback amc = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.cmenu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.cm01:
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    actionMode.finish();
                    break;
                case R.id.cm02:
                    break;
                default:
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            actionMode=null;
        }
    };
}