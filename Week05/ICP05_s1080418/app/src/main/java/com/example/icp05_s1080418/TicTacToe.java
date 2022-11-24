package com.example.icp05_s1080418;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicTacToe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TicTacToe extends Fragment {
    int count = 0;

    Button [] btn_arr= new Button[9];
    //Vertical, Horizontal, Slanting
    boolean game_status = true;
    TextView tv01;
    int i;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TicTacToe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TicTacToe.
     */
    // TODO: Rename and change types and number of parameters
    public static TicTacToe newInstance(String param1, String param2) {
        TicTacToe fragment = new TicTacToe();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        tv01 = getActivity().findViewById(R.id.tv02);

        View.OnClickListener btLTR=new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (((Button) v).getText().length() == 0 && game_status) {
                    if (count % 2 == 0) {
                        ((Button) v).setText("O");

                    } else {
                        ((Button) v).setText("X");

                    }
                    count++;
                }
                // Slanting, Vertical, Horizontal
                boolean s1 = btn_arr[0].getText() == btn_arr[4].getText() && btn_arr[0].getText() == btn_arr[8].getText() && btn_arr[0].getText().length() != 0;
                boolean s2 = btn_arr[2].getText() == btn_arr[4].getText() && btn_arr[2].getText() == btn_arr[6].getText() && btn_arr[2].getText().length() != 0;
                boolean v1 = btn_arr[0].getText() == btn_arr[1].getText() && btn_arr[0].getText() == btn_arr[2].getText() && btn_arr[0].getText().length() != 0;
                boolean v2 = btn_arr[3].getText() == btn_arr[4].getText() && btn_arr[3].getText() == btn_arr[5].getText() && btn_arr[3].getText().length() != 0;
                boolean v3 = btn_arr[6].getText() == btn_arr[7].getText() && btn_arr[6].getText() == btn_arr[8].getText() && btn_arr[6].getText().length() != 0;
                boolean h1 = btn_arr[0].getText() == btn_arr[3].getText() && btn_arr[0].getText() == btn_arr[6].getText() && btn_arr[0].getText().length() != 0;
                boolean h2 = btn_arr[1].getText() == btn_arr[4].getText() && btn_arr[1].getText() == btn_arr[7].getText() && btn_arr[1].getText().length() != 0;
                boolean h3 = btn_arr[2].getText() == btn_arr[5].getText() && btn_arr[2].getText() == btn_arr[8].getText() && btn_arr[2].getText().length() != 0;
                boolean cdt = s1 || s2 || v1 || v2 || v3 || h1 || h2 || h3;

                if (cdt) {
                    if (((Button) v).getText() == "O" && ((Button) v).isClickable()) {
                        tv01.setText("O win!");
                        game_status = false;
                    }
                    if (((Button) v).getText() == "X" && ((Button) v).isClickable()) {
                        tv01.setText("X win!");
                        game_status = false;
                    }
                }
                //遊戲結束 將所有按鈕都 unClickable
                if(!game_status) {
                    for (i = 0; i < 9; i++) {
                        btn_arr[i].setClickable(false);
                    }
                }

                //將已按過的設置為 unClickable
                ((Button) v).setClickable(false);
            }
        };
        for (i = 0; i < 9; i++){
            String btn = "button" + (i+1);
            int btn_id = getResources().getIdentifier(btn,"id",getContext().getPackageName());
            btn_arr[i] = v.findViewById(btn_id);
            btn_arr[i].setOnClickListener(btLTR);

        }

        // Inflate the layout for this fragment
        return v;
    }
}