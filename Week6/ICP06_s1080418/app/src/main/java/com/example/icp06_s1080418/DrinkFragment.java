package com.example.icp06_s1080418;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinkFragment extends Fragment {
    Bundle bd;
    String s, s5,s6,s7,s8;
    CheckBox cb5 ,cb6, cb7, cb8;
    TextView tv5, tv6, tv7, tv8;
    TextView  p5,p6,p7, p8;
    EditText et5, et6, et7, et8;
    String temp="";
    Button btnNext;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrinkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinkFragment newInstance(String param1, String param2) {
        DrinkFragment fragment = new DrinkFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_drink, container, false);
        cb5 =v.findViewById(R.id.checkBox5);
        cb6 =v.findViewById(R.id.checkBox6);
        cb7 =v.findViewById(R.id.checkBox7);
        cb8 =v.findViewById(R.id.checkBox8);


        et5 = v.findViewById(R.id.editQuantities5);
        et6 = v.findViewById(R.id.editQuantities6);
        et7 = v.findViewById(R.id.editQuantities7);
        et8 = v.findViewById(R.id.editQuantities8);


        tv5 = v.findViewById(R.id.textItemName5);
        tv6 = v.findViewById(R.id.textItemName6);
        tv7 = v.findViewById(R.id.textItemName7);
        tv8 = v.findViewById(R.id.textItemName8);


        p5 = v.findViewById(R.id.textPrice5);
        p6 = v.findViewById(R.id.textPrice6);
        p7 = v.findViewById(R.id.textPrice7);
        p8 = v.findViewById(R.id.textPrice8);
        bd = new Bundle();



        //get

        MainActivity.title.setText("飲料");
        btnNext = getActivity().findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb5.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s5 = tv5.getText().toString() + "," + p5.getText().toString() + "," + et5.getText().toString();
                    if (s == null)
                        s = s5;
                    else
                        s = s + ";" +s5;
                }if(cb6.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s6 = tv6.getText().toString() + "," + p6.getText().toString() + "," + et6.getText().toString();
                    if (s == null)
                        s = s6;
                    else
                        s = s + ";" +s6;
                }if(cb7.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s7 = tv7.getText().toString() + "," + p7.getText().toString() + "," + et7.getText().toString();
                    if (s == null)
                        s = s7;
                    else
                        s = s + ";" +s7;
                }if(cb8.isChecked()) {
                    //tv, p, et 名稱,價錢,數量
                    s8 = tv8.getText().toString() + "," + p8.getText().toString() + "," + et8.getText().toString();
                    if (s == null)
                        s = s8;
                    else
                        s = s + ";" +s8;
                }

                temp = getArguments().getString("Food");

                if (s == null)
                    s = temp;
                else if(temp ==null)
                    s = s;
                else
                    s = temp + ";" +s;
                bd.putString("Total", s);
                NavHostFragment.findNavController(DrinkFragment.this).navigate(R.id.action_drinkFragment_to_checkoutFragment2, bd);
            }
        });




        return v;
    }
}