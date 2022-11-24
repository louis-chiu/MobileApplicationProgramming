package com.example.dialogdemo_s1080418;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

public class LoginFrag extends DialogFragment {
    int a = 10;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder cdlog = new AlertDialog.Builder(getActivity());

        LayoutInflater iflat = getActivity().getLayoutInflater();
        cdlog.setView(iflat.inflate(R.layout.login,null))
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoginFrag.this.getDialog().cancel();
                    }
                });

        return cdlog.create();
    }
}
