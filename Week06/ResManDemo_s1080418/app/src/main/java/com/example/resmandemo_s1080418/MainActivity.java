package com.example.resmandemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float imgX;
    AnimatorSet set;
    Animation an;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.textView1);
        ImageView iv1 = findViewById(R.id.imageView1);
        ObjectAnimator translateX = ObjectAnimator.ofFloat(iv1, "TranslationX", -200f,200f);
        ObjectAnimator translateY = ObjectAnimator.ofFloat(iv1, "TranslationY", 0f,1000f);

        translateX.setRepeatCount(10);
        translateY.setRepeatCount(10);
        set = new AnimatorSet();

        set.setDuration(3000);
        set.playTogether(translateX, translateY);


        translateX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                imgX = (Float) valueAnimator.getAnimatedValue();//起始為0開始計算
                tv1.setText(String.valueOf(imgX));

            }
        });

        an = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fad_out);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.startAnimation(an);
                set.end();

            }

        });

    }
}