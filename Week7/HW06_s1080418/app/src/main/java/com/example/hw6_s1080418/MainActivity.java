package com.example.hw6_s1080418;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSID;
    Bundle bd;
    Intent itt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tvSID = findViewById(R.id.tvSID);
        bd = new Bundle();
        itt = new Intent(this, TicTacToeActivity.class);

    }


    ActivityResultLauncher<Intent> Launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();

                    }
                }
            });


    //串接 optionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.om, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //optionMenu Item Selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sid:
                Launcher.launch(TicTacToeActivity.itt2);
                break;
            case R.id.tictactoe:
                // move to TicTacToeActivity
                String s = (String) tvSID.getText();
                bd.putString("SID", s);
                itt.putExtras(bd);

                Launcher.launch(itt);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}