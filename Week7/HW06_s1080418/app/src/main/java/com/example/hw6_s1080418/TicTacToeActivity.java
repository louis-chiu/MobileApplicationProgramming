package com.example.hw6_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToeActivity extends MainActivity {
    int count = 0;

    ActionMode am;
    ImageButton[] btn_arr= new ImageButton[9];

    boolean game_status = true, temp = true , all_btn_isDisabled = false;
    TextView tv01;
    int i;
    static Intent itt2;
    Bundle bdSID;
    RadioGroup rg;
    RadioButton rbO, rbX, main_player, sec_player;
    Drawable first_icon, second_icon;
    PopupMenu pmTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        rg  = findViewById(R.id.radioGroup);
        rbO =findViewById(R.id.radioButton);
        rbX =findViewById(R.id.radioButton2);

        tv01 = findViewById(R.id.textView);
        itt2 = new Intent(this, MainActivity.class);
        bdSID = this.getIntent().getExtras();
        tvSID = findViewById(R.id.TTT_sid);
        tvSID.setText(bdSID.getString("SID"));




        // Context Menu
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ConstraintLayout cl = findViewById(R.id.ConstraintLayout);
        cl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //LongClick 可用時機
                if (!(rbO.isChecked() || rbX.isChecked())) {
                    if (am != null)
                        return false;
                    am = TicTacToeActivity.this.startActionMode(amc);
                }
                return true;
            }
        });


        //radio button checked
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == rbO.getId()) {
                    first_icon = rbO.getCompoundDrawables()[2];
                    second_icon = rbX.getCompoundDrawables()[2];

                    main_player = rbO;
                    sec_player = rbX;
                } else if(i == rbX.getId()) {
                    first_icon = rbX.getCompoundDrawables()[2];
                    second_icon = rbO.getCompoundDrawables()[2];

                    main_player = rbX;
                    sec_player = rbO;
                }
                //If rg is checked Make them disable
                rbO.setEnabled(false);
                rbX.setEnabled(false);

            }
        });

        //pm

        pmTV = new PopupMenu(this,tv01);

        tv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pmTV.show();
            }
        });

        PopupMenu.OnMenuItemClickListener pmLTR= new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.pm01:
                        Launcher.launch(itt2);
                        game_status = true;
                        break;
                    case R.id.pm02:
                        for(int k=0;k<9;k++){
                            btn_arr[k].setImageDrawable(null);
                            btn_arr[k].setEnabled(true);

                        }
                        game_status = true;
                        rg.clearCheck();
                        rbO.setEnabled(true);
                        rbX.setEnabled(true);
                        count=0;
                        tv01.setText("");

                        break;
                    default:
                        return true;
                }
                return false;
            }
        };


        //Setting Popup Menu When Somebody Win or Tie
        pmTV.inflate(R.menu.pm);
        pmTV.setOnMenuItemClickListener(pmLTR);

        //tic tac toe

        View.OnClickListener btLTR=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ImageButton) v).getDrawable() == null && game_status && (rbO.isChecked()|| rbX.isChecked() )) {
                    if (count % 2 == 0) {
                        ((ImageButton) v).setImageDrawable(first_icon);
                    } else {
                        ((ImageButton) v).setImageDrawable(second_icon);
                    }
                    count++;
                }
                // Slanting, Vertical, Horizontal
                boolean s1 = btn_arr[0].getDrawable() == btn_arr[4].getDrawable() && btn_arr[0].getDrawable() == btn_arr[8].getDrawable() && btn_arr[0].getDrawable() != null;
                boolean s2 = btn_arr[2].getDrawable() == btn_arr[4].getDrawable() && btn_arr[2].getDrawable() == btn_arr[6].getDrawable() && btn_arr[2].getDrawable() != null;
                boolean v1 = btn_arr[0].getDrawable() == btn_arr[1].getDrawable() && btn_arr[0].getDrawable() == btn_arr[2].getDrawable() && btn_arr[0].getDrawable() != null;
                boolean v2 = btn_arr[3].getDrawable() == btn_arr[4].getDrawable() && btn_arr[3].getDrawable() == btn_arr[5].getDrawable() && btn_arr[3].getDrawable() != null;
                boolean v3 = btn_arr[6].getDrawable() == btn_arr[7].getDrawable() && btn_arr[6].getDrawable() == btn_arr[8].getDrawable() && btn_arr[6].getDrawable() != null;
                boolean h1 = btn_arr[0].getDrawable() == btn_arr[3].getDrawable() && btn_arr[0].getDrawable() == btn_arr[6].getDrawable() && btn_arr[0].getDrawable() != null;
                boolean h2 = btn_arr[1].getDrawable() == btn_arr[4].getDrawable() && btn_arr[1].getDrawable() == btn_arr[7].getDrawable() && btn_arr[1].getDrawable() != null;
                boolean h3 = btn_arr[2].getDrawable() == btn_arr[5].getDrawable() && btn_arr[2].getDrawable() == btn_arr[8].getDrawable() && btn_arr[2].getDrawable() != null;

                boolean cdt = s1 || s2 || v1 || v2 || v3 || h1 || h2 || h3;
                //Who Win
                if (cdt) {
                    if (((ImageButton) v).getDrawable() == main_player.getCompoundDrawables()[2] && ((ImageButton) v).isEnabled()) {
                        tv01.setText("You Win!");
                        game_status = false;
                    }else if (((ImageButton) v).getDrawable() == sec_player.getCompoundDrawables()[2] && ((ImageButton) v).isEnabled()) {
                        tv01.setText("You Lose!");
                        game_status = false;
                    }
                }else if(count==9) {
                    tv01.setText("Tie!");
                    game_status =false;
                }


                //遊戲結束 將所有按鈕都 unClickable
                if(!game_status) {
                    for (i = 0; i < 9; i++) {
                        btn_arr[i].setEnabled(false);
                    }
                }
                //將已按過的設置為 unClickable
                if(((ImageButton) v).getDrawable() != null) {
                    ((ImageButton) v).setEnabled(false);
                }else{
                    Toast.makeText(TicTacToeActivity.this, "Please Choose Your Icon!", Toast.LENGTH_SHORT).show();
                }





            }


        };

        for (i = 0; i < 9; i++){
            String btn = "button" + (i+1);
            int btn_id = getResources().getIdentifier(btn,"id",getPackageName());
            btn_arr[i] = findViewById(btn_id);
            btn_arr[i].setOnClickListener(btLTR);

        }




    }

    //Context Menu
    final ActionMode.Callback amc = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.cmenu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.circle:
                    rbO.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(TicTacToeActivity.this, R.drawable.circle),null);
                    rbX.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(TicTacToeActivity.this, R.drawable.cross), null);
                    actionMode.finish();
                    break;
                case R.id.moon:
                    rbO.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(TicTacToeActivity.this, R.drawable.moon),null);
                    rbX.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(TicTacToeActivity.this, R.drawable.star), null);
                    actionMode.finish();
                    break;
                case R.id.rat:
                    rbO.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(TicTacToeActivity.this, R.drawable.rat),null);
                    rbX.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(TicTacToeActivity.this, R.drawable.monkey), null);
                    actionMode.finish();
                    break;
                default:
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            actionMode = null;
        }
    };

}