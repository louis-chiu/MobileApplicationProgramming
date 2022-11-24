package com.example.hw06_s1080418;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  Intent itt;
    String s , s1, s2,s3,s4;
    CheckBox cb1, cb2, cb3, cb4;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView p1, p2, p3, p4;
    EditText et1, et2, et3, et4;
    Bundle bd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textItemName1);
        tv2 = findViewById(R.id.textItemName2);
        tv3 = findViewById(R.id.textItemName3);
        tv4 = findViewById(R.id.textItemName4);

        et1 = findViewById(R.id.editQuantities1);
        et2 = findViewById(R.id.editQuantities2);
        et3 = findViewById(R.id.editQuantities3);
        et4 = findViewById(R.id.editQuantities4);

        p1 = findViewById(R.id.textPrice1);
        p2 = findViewById(R.id.textPrice2);
        p3 = findViewById(R.id.textPrice3);
        p4 = findViewById(R.id.textPrice4);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);

        bd = new Bundle();
        itt =new Intent(this,Drink.class);
        Button btnNext = findViewById(R.id.button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s1 = tv1.getText().toString() + "," + p1.getText().toString() + "," + et1.getText().toString();
                    if (s == null)
                        s = s1;
                    else
                        s = s + ";" +s1;
                }if(cb2.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s2 = tv2.getText().toString() + "," + p2.getText().toString() + "," + et2.getText().toString();
                    if (s == null)
                        s = s2;
                    else
                        s = s + ";" +s2;
                }if(cb3.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s3 = tv3.getText().toString() + "," + p3.getText().toString() + "," + et3.getText().toString();
                    if (s == null)
                        s = s3;
                    else
                        s = s + ";" +s3;
                }if(cb4.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s4 = tv4.getText().toString() + "," + p4.getText().toString() + "," + et4.getText().toString();
                    if (s == null)
                        s = s4;
                    else
                        s = s + ";" +s4;
                };
                bd.putString("Food",s);
                itt.putExtras(bd);
                Launcher.launch(itt);
            }
        });

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




    //option 區
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
            case R.id.location:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}