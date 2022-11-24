package com.example.icp3_s1080418;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    ImageView iv1, iv2 ;
    static Boolean [] isChecked = {false, false, false, false, false, false, false, false};

    float sp_x,sp_y,ep_x,ep_y;
    float pic_x0,pic_x1,pic_y0,pic_y1;
    float slope;
    boolean in_state;
    boolean out_state;
    boolean pass_state;
    float SQR3 = (float) Math.sqrt(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);


        //手勢提示


        CustomDFrag df = new CustomDFrag();
        df.show(getFragmentManager(), "Test");
        //觸控區
        FrameLayout fl = findViewById(R.id.frameLayout);
        fl.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int act= motionEvent.getAction();
                pic_x0 = iv2.getX();
                pic_x1 = iv2.getX() + iv2.getWidth();
                pic_y0 = iv2.getY();
                pic_y1 = iv2.getY() + iv2.getHeight();

                switch (act){
                    case MotionEvent.ACTION_DOWN:
                        sp_x = motionEvent.getX();
                        sp_y = motionEvent.getY();
                        break;

                    case MotionEvent.ACTION_UP:
                        ep_x = motionEvent.getX();
                        ep_y = motionEvent.getY();
                        slope = (ep_y - sp_y) / (ep_x - sp_x);

                        if (out_state) {
                            if (ep_x - sp_x > 0) { // 往右 +
                                if (ep_y - sp_y > 0) { // 下 +
                                    if (Math.abs(slope) > (1f / SQR3) && Math.abs(slope) < SQR3 && isChecked[5])
                                        iv2.setImageResource(R.drawable.pic6);  //右下
                                    else if(Math.abs(slope) > SQR3 && isChecked[1])
                                        iv2.setImageResource(R.drawable.pic2); //下
                                    else if(Math.abs(slope) < (1f / SQR3) && isChecked[3])
                                        iv2.setImageResource(R.drawable.pic4); //右
                                } else if (ep_y - sp_y < 0) {  // 上 -
                                    if (Math.abs(slope) > (1f / SQR3) && Math.abs(slope) < SQR3 && isChecked[4])
                                        iv2.setImageResource(R.drawable.pic5); //右上
                                    else if(Math.abs(slope) > SQR3 && isChecked[0])
                                        iv2.setImageResource(R.drawable.pic1); //上
                                    else if(Math.abs(slope) < (1f / SQR3) && isChecked[3])
                                        iv2.setImageResource(R.drawable.pic4); //右

                                }

                            } else if (ep_x - sp_x < 0) {  //往左 -
                                if (ep_y - sp_y > 0) { // 下 +
                                    if (Math.abs(slope) > (1f / SQR3) && Math.abs(slope) < SQR3 && isChecked[7])
                                        iv2.setImageResource(R.drawable.pic8); //左下
                                    else if(Math.abs(slope) > SQR3 && isChecked[1])
                                        iv2.setImageResource(R.drawable.pic2); //下
                                    else if(Math.abs(slope) < (1f / SQR3) && isChecked[2])
                                        iv2.setImageResource(R.drawable.pic3); //左

                                } else if (ep_y - sp_y < 0) {  // 上 -
                                    if (Math.abs(slope) > (1f / SQR3) && Math.abs(slope) < SQR3 && isChecked[6])
                                        iv2.setImageResource(R.drawable.pic7);  //左上
                                    else if(Math.abs(slope) > SQR3 && isChecked[0])
                                        iv2.setImageResource(R.drawable.pic1); //上
                                    else if(Math.abs(slope) < (1f / SQR3) && isChecked[2])
                                        iv2.setImageResource(R.drawable.pic3); //左

                                }
                            }
                        }

                        //
                        in_state=false;
                        pass_state=false;
                        out_state = false;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        //取得座標
                        tv1.setText(motionEvent.getX()+"\n"+motionEvent.getY());
                        iv1.setX(motionEvent.getX() - iv1.getWidth()/2);
                        iv1.setY(motionEvent.getY() - iv1.getHeight()/2);

                        //判斷 1. 起點是否位於 Image 外
                        //     2. 是否拖曳過程中有經過圖片
                        //      3. 鬆開螢幕時是否位於 Image 外
                        if(!(sp_x > pic_x0 && sp_x < pic_x1 && sp_y > pic_y0 && sp_y < pic_y1))
                            in_state = true;
                        if(motionEvent.getX() > pic_x0 && motionEvent.getX() < pic_x1 && motionEvent.getY() > pic_y0 && motionEvent.getY() < pic_y1)
                            pass_state = true;
                        else if(in_state && pass_state)
                            out_state = true;




                        //姿勢判斷

                        break;
                }
                return true;
            }
        });


    }


}