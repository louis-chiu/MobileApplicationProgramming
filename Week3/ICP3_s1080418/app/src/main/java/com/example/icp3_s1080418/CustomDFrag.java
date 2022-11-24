package com.example.icp3_s1080418;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;



public class CustomDFrag extends DialogFragment {

    CheckBox cb1, cb2, cb3 ,cb4, cb5, cb6, cb7, cb8;

    String ges = "";
    TextView tv2;
    Boolean[] isChecked;
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder cdlog = new AlertDialog.Builder(getActivity());

        LayoutInflater iflat = getActivity().getLayoutInflater();
        View v = iflat.inflate(R.layout.custom_dialog,null);
        isChecked = MainActivity.isChecked;
        tv2 = getActivity().findViewById(R.id.textView2);
        cb1 = v.findViewById(R.id.checkBox1);
        cb2 = v.findViewById(R.id.checkBox2);
        cb3 = v.findViewById(R.id.checkBox3);
        cb4 = v.findViewById(R.id.checkBox4);
        cb5 = v.findViewById(R.id.checkBox5);
        cb6 = v.findViewById(R.id.checkBox6);
        cb7 = v.findViewById(R.id.checkBox7);
        cb8 = v.findViewById(R.id.checkBox8);

        cdlog.setView(v)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(cb1.isChecked()) {
                            ges += cb1.getText() + "\t";
                            isChecked[0] = true;
                        }
                        if(cb2.isChecked()) {
                            ges += cb2.getText() + "\t";
                            isChecked[1] = true;
                        }
                        if(cb3.isChecked()) {
                            ges += cb3.getText() + "\t";
                            isChecked[2] = true;
                        }
                        if(cb4.isChecked()) {
                            ges += cb4.getText() + "\t";
                            isChecked[3] = true;
                        }
                        if(cb5.isChecked()) {
                            ges += cb5.getText() + "\t";
                            isChecked[4] = true;
                        }
                        if(cb6.isChecked()) {
                            ges += cb6.getText() + "\t";
                            isChecked[5] = true;
                        }
                        if(cb7.isChecked()) {
                            ges += cb7.getText() + "\t";
                            isChecked[6] = true;
                        }
                        if(cb8.isChecked()) {
                            ges += cb8.getText() + "\t";
                            isChecked[7] = true;
                        }
                        tv2.setText(ges);
                    }
                })
                .setNegativeButton("Cancel",null);

        return cdlog.create();

    }



}
