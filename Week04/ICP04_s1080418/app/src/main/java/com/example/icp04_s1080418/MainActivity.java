package com.example.icp04_s1080418;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    ImageView iv1, iv2 ;
    FrameLayout fl;
    Boolean [] isChecked = {false, false, false, false, false, false, false, false};

    float sp_x,sp_y,ep_x,ep_y;
    float pic_x0,pic_x1,pic_y0,pic_y1;
    float slope;
    boolean in_state;
    boolean out_state;
    boolean pass_state;
    float SQR3 = (float) Math.sqrt(3);

    //custom
    String ges = "";

    AnimatorSet set;

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    };
    public static int spToPx(Context context, int spValue) {
        DisplayMetrics displayMetrics = context.getResources()
                .getDisplayMetrics();
        return (int) ((spValue * displayMetrics.scaledDensity) + 0.5);
    }
    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAndDisplayDialog();

        //Constraint Layout
        ConstraintLayout cl = findViewById(R.id.cl1);
        ConstraintSet cs = new ConstraintSet();

        //Construct
        fl = new FrameLayout(this);
        fl.setId(View.generateViewId());

        cl.addView(fl);

        //fl set Constraint
        iv2 = new ImageView(this);
        iv2.setImageResource(R.drawable.pic9);
        iv1 = new ImageView(this);
        iv1.setImageResource(android.R.drawable.btn_star_big_on);


        ViewGroup.LayoutParams fl_params = fl.getLayoutParams();
        fl.setBackgroundColor(Color.BLACK);
        fl_params.width = dip2px(MainActivity.this,360);
        fl_params.height = dip2px(MainActivity.this, 500);
        fl.setLayoutParams(fl_params);

        FrameLayout.LayoutParams iv1_params= new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        iv1_params.gravity= Gravity.NO_GRAVITY;
        iv1.setLayoutParams(iv1_params);

        FrameLayout.LayoutParams iv2_params= new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        iv2_params.gravity= Gravity.CENTER;
        iv2.setBackgroundColor(Color.WHITE);
        iv2.setLayoutParams(iv2_params);

        fl.addView(iv2);
        fl.addView(iv1);


        cs.clone(cl);
        cs.connect(fl.getId(), ConstraintSet.LEFT, cl.getId(), ConstraintSet.LEFT,0);
        cs.connect(fl.getId(), ConstraintSet.RIGHT, cl.getId(), ConstraintSet.RIGHT,0);
        cs.connect(fl.getId(), ConstraintSet.BOTTOM, cl.getId(), ConstraintSet.BOTTOM, dip2px(MainActivity.this,50));
        cs.applyTo(cl);


        //old
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        //old
        /* iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);*/


        /*//加入Custom Fragment
        CustomDFrag df = new CustomDFrag();
        df.show(getFragmentManager(), "Test");*/


        //觸控區

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
    private void createAndDisplayDialog(){
        AlertDialog.Builder cdlog = new AlertDialog.Builder(this);


        TableRow[] tr_arr = new TableRow[8];
        CheckBox[] cb_arr = new CheckBox[8];
        ImageView [] iv_arr = new ImageView[8];

        //Constraint

        ConstraintSet cs = new ConstraintSet();

        TableLayout tl = new TableLayout(this);
        tl.setId(View.generateViewId());

        for(int i=0;i<8;i++){
            iv_arr[i] = new ImageView(this);
            iv_arr[i].setId(View.generateViewId());
            iv_arr[i].setLayoutParams(new TableRow.LayoutParams(dip2px(this,60)
                    , dip2px(this,60)));
            String pic = "pic" + (i+1);
            int pic_id = getResources().getIdentifier(pic,"drawable",this.getPackageName());
            iv_arr[i].setImageResource(pic_id);;

        }

        for(int j =0; j<8;j++){
            cb_arr[j] = new CheckBox(this);
            cb_arr[j].setId(View.generateViewId());
            cb_arr[j].setLayoutParams(new TableRow.LayoutParams(dip2px(this,240),
                    dip2px(this,60)));
            String str = "d" + (j+1);
            int str_id = getResources().getIdentifier(str,"string",this.getPackageName());
            cb_arr[j].setText(str_id);
            cb_arr[j].setTextSize(34);
        }

        //tl setting
        ViewGroup.LayoutParams tl_params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tl_params.width= dip2px(this,300 );
        tl_params.height = dip2px(this,480 );
        //tl.setBackgroundColor(Color.BLACK);
        tl.setLayoutParams(tl_params);



        int k =-1;
        for(TableRow tr: tr_arr){
            tr= new TableRow(this);
            tr.setId(View.generateViewId());
            tr.setLayoutParams(new TableRow.LayoutParams(dip2px(this,300 ), dip2px(this,60)));
            tl.addView(tr);
            k+=1;

            tr.addView(cb_arr[k]);
            tr.addView(iv_arr[k]);
        }


        tv2 = findViewById(R.id.textView2);
        //animator
        ObjectAnimator c2l = ObjectAnimator.ofFloat(tv2, "TranslationX", 0f, 450f);
        ObjectAnimator r2l = ObjectAnimator.ofFloat(tv2, "TranslationX", 450f, -450f);
        ObjectAnimator l2r = ObjectAnimator.ofFloat(tv2, "TranslationX", -450f, 450f);


        set = new AnimatorSet();

        set.setDuration(3000);
        set.playSequentially(c2l, r2l, l2r);

        cdlog.setView(tl)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(cb_arr[0].isChecked()) {
                            ges += cb_arr[0].getText() + "\t";
                            isChecked[0] = true;
                        }
                        if(cb_arr[1].isChecked()) {
                            ges += cb_arr[1].getText() + "\t";
                            isChecked[1] = true;
                        }
                        if(cb_arr[2].isChecked()) {
                            ges += cb_arr[2].getText() + "\t";
                            isChecked[2] = true;
                        }
                        if(cb_arr[3].isChecked()) {
                            ges += cb_arr[3].getText() + "\t";
                            isChecked[3] = true;
                        }
                        if(cb_arr[4].isChecked()) {
                            ges += cb_arr[4].getText() + "\t";
                            isChecked[4] = true;
                        }
                        if(cb_arr[5].isChecked()) {
                            ges += cb_arr[5].getText() + "\t";
                            isChecked[5] = true;
                        }
                        if(cb_arr[6].isChecked()) {
                            ges += cb_arr[6].getText() + "\t";
                            isChecked[6] = true;
                        }
                        if(cb_arr[7].isChecked()) {
                            ges += cb_arr[7].getText() + "\t";
                            isChecked[7] = true;
                        }
                        tv2.setText(ges);
                        set.start();
                    }
                })
                .setNegativeButton("Cancel",null)
                .create()
                .show();
    };


}