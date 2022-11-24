package com.example.icp06_s1080418;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckoutFragment extends Fragment {
    String s,  all_name, all_num, name ;
    String [] items_arr;
    String [][] item_arr;
    int total=0, num=0, price=0;
    Button btnNext;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckoutFragment newInstance(String param1, String param2) {
        CheckoutFragment fragment = new CheckoutFragment();
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
        View v =inflater.inflate(R.layout.fragment_checkout, container, false);

        MainActivity.title.setText("結帳");
        s = getArguments().getString("Total");
        items_arr = s.split(";");
        item_arr = new String[items_arr.length][3];
        for(int i=0;i<items_arr.length;i++){
           item_arr[i] = items_arr[i].split(",");
        }
        TextView tvTotal = v.findViewById(R.id.textTotal);
        TextView tvName = v.findViewById(R.id.textName);
        TextView tvQuan = v.findViewById(R.id.textQuan);
        for(String [] item : item_arr){

            name = item[0];
            price = Integer.parseInt(item[1]);
            num = Integer.parseInt(item[2]);
            total += num * price;

            if(all_name == null )
                all_name = name;
            else
                all_name = all_name + "\n\n" + name;

            if(all_num == null)
                all_num = String.valueOf(num);
            else
                all_num = all_num + "\n\n" + num;
        }


        tvName.setText(all_name);
        tvQuan.setText(all_num);
        tvTotal.setText(String.valueOf(total));

        btnNext = getActivity().findViewById(R.id.buttonNext);
        btnNext.setText("Return");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CheckoutFragment.this).navigate(R.id.action_checkoutFragment_to_foodFragment);
            }
        });
        return v;
    }
}