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
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {
    String s , s1, s2,s3,s4;
    CheckBox cb1, cb2, cb3, cb4;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    Button btnNext;
    TextView p1, p2, p3, p4;
    EditText et1, et2, et3, et4;
    Bundle bd;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
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
        View v = inflater.inflate(R.layout.fragment_food, container, false);
        tv1 = v.findViewById(R.id.textItemName1);
        tv2 = v.findViewById(R.id.textItemName2);
        tv3 = v.findViewById(R.id.textItemName3);
        tv4 = v.findViewById(R.id.textItemName4);

        et1 = v.findViewById(R.id.editQuantities1);
        et2 = v.findViewById(R.id.editQuantities2);
        et3 = v.findViewById(R.id.editQuantities3);
        et4 = v.findViewById(R.id.editQuantities4);

        p1 = v.findViewById(R.id.textPrice1);
        p2 = v.findViewById(R.id.textPrice2);
        p3 = v.findViewById(R.id.textPrice3);
        p4 = v.findViewById(R.id.textPrice4);

        cb1 =v.findViewById(R.id.checkBox1);
        cb2 =v.findViewById(R.id.checkBox2);
        cb3 =v.findViewById(R.id.checkBox3);
        cb4 =v.findViewById(R.id.checkBox4);

        bd = new Bundle();

        MainActivity.title.setText("輕食");
        btnNext = getActivity().findViewById(R.id.buttonNext);
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
                NavHostFragment.findNavController(FoodFragment.this).navigate(R.id.action_foodFragment_to_drinkFragment2, bd);

            }
        });


        return v;
    }
}