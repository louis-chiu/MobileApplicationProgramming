package com.example.hw09_s1080418;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Preschool> lstData;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public myAdapter(List<Preschool> lst){
        lstData = lst;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView id, type, name, address, number_of_enrollment;
        public ItemViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            type = itemView.findViewById(R.id.type);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            number_of_enrollment = itemView.findViewById(R.id.number_of_enrollment);
        }
    }
    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber;

        public HeaderViewHolder(View headerView) {
            super(headerView);
            tvNumber =  headerView.findViewById(R.id.number);

        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == TYPE_HEADER) {
            // Here Inflating your header view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new HeaderViewHolder(itemView);
        } else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.tvNumber.setText(String.valueOf(lstData.size()));
        } else if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.id.setText(String.valueOf(lstData.get(position-1).getId()));
            itemViewHolder.type.setText(lstData.get(position-1).getType());
            itemViewHolder.name.setText(lstData.get(position-1).getName());
            itemViewHolder.address.setText(lstData.get(position-1).getAddress());
            itemViewHolder.number_of_enrollment.setText(lstData.get(position-1).getNumber_of_enrollment());
        }
    }

    @Override
    public int getItemCount() {
        return lstData.size()+1;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }
}
