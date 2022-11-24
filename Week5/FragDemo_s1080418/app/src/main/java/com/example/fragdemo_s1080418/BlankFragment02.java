package com.example.fragdemo_s1080418;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment02#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment02 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment02() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment02.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment02 newInstance(String param1, String param2) {
        BlankFragment02 fragment = new BlankFragment02();
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
        View fg02view =  inflater.inflate(R.layout.fragment_blank02, container, false);
        Button btn04 = fg02view.findViewById(R.id.button4);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView main_tv= getActivity().findViewById(R.id.textView1);
                main_tv.setText("Change by FG02");

            }
        });
        return fg02view;
    }
}