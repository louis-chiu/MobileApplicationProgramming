package com.example.recyclerviewdemo_s1080418;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myVH> {
    private List<CntData> clst;

    public myAdapter(List<CntData> lst){
        clst = lst;
    }

    @NonNull
    @Override
    public myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new myVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myVH holder, int position) {
        holder.iv.setImageResource(R.drawable.icon);
        holder.tv01.setText(clst.get(position).getName());
        holder.tv02.setText(clst.get(position).getId());
        holder.tv03.setText(clst.get(position).getEmail());
    }




    @Override
    public int getItemCount(){ return clst.size(); }

    public class myVH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv01, tv02, tv03;

        public myVH(View v){
            super(v);
            iv = v.findViewById(R.id.imageView2);
            tv01 = v.findViewById(R.id.textView);
            tv02 = v.findViewById(R.id.textView2);
            tv03 = v.findViewById(R.id.textView3);
        }
    }
}

