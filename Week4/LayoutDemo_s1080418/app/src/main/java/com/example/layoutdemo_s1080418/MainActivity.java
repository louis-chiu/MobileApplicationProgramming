package com.example.layoutdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout cl = findViewById(R.id.ConstL);

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.ic_launcher_background);
        iv.setId(View.generateViewId());

        cl.addView(iv);


        ConstraintSet cs = new ConstraintSet();

        LinearLayout linL =new LinearLayout(this);
        linL.setOrientation(LinearLayout.HORIZONTAL);
        linL.setId(View.generateViewId());
        linL.setGravity(Gravity.LEFT);
        linL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView tv = new TextView(this);
        tv.setText("Testing");

        Button btn = new Button(this);
        btn.setText("Test");

        linL.addView(tv);
        linL.addView(btn);
        cl.addView(linL);


        cs.clone(cl);

        cs.connect(iv.getId(), ConstraintSet.LEFT, cl.getId(), ConstraintSet.LEFT, 150 );
        cs.connect(iv.getId(), ConstraintSet.TOP, cl.getId(), ConstraintSet.TOP, 150);

        cs.connect(linL.getId(), ConstraintSet.LEFT, cl.getId(), ConstraintSet.LEFT, 150);
        cs.connect(linL.getId(), ConstraintSet.TOP, iv.getId(), ConstraintSet.BOTTOM, 150);
        cs.applyTo(cl);






    }
}