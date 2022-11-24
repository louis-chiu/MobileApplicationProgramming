package com.example.icp07_s1080418;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<FoodData> clst;
    private Context context;


    public myAdapter(Context context, List<FoodData> lst){
        this.context = context;
        this.clst = lst;

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
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder){
            //setheadersdata_flag = true;
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

            // You have to set your header items values with the help of model class and you can modify as per your needs
            //headerViewHolder.txt_needsreview.setText(“YOUR _HEADERVIEW_STRING”);

        }
        else if (holder instanceof ItemViewHolder){
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            // Following code give a row of header and decrease the one position from listview items
            //final LatestTabModel.ViewItemsModel data = latestlists.get(position-1);

            // You have to set your listview items values with the help of model class and you can modify as per your needs
            //itemViewHolder.title.setText(data.getTitle());
            ((ItemViewHolder) holder).tv01.setText(clst.get(position-1).getId());
            ((ItemViewHolder) holder).tv02.setText(clst.get(position-1).getName());
            ((ItemViewHolder) holder).iv.setImageResource(clst.get(position-1).getPic());
            ((ItemViewHolder) holder).tv03.setText(clst.get(position-1).getPrice());
        }

        //old

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }


    @Override
    public int getItemCount(){ return clst.size()+1; }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvT1, tvT2;

        public HeaderViewHolder(View v) {
            super(v);
            tvT1 =  v.findViewById(R.id.textViewTitle);
            tvT2 =  v.findViewById(R.id.textViewT2);

        }
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv01, tv02, tv03;

        public ItemViewHolder(View v){
            super(v);
            iv = v.findViewById(R.id.imageView);
            tv01 = v.findViewById(R.id.textViewId);
            tv02 = v.findViewById(R.id.textViewName);
            tv03 = v.findViewById(R.id.textViewPrice);
        }
    }}

