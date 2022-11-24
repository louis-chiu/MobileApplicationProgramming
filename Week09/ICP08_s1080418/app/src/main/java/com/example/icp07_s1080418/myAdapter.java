package com.example.icp07_s1080418;

import static android.graphics.Color.parseColor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    int row_index;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        /*if (holder instanceof HeaderViewHolder){
            //setheadersdata_flag = true;
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

            // You have to set your header items values with the help of model class and you can modify as per your needs
            //headerViewHolder.txt_needsreview.setText(“YOUR _HEADERVIEW_STRING”);

        }
        else*/
        if (holder instanceof ItemViewHolder){
            /*final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;*/

            // Following code give a row of header and decrease the one position from listview items
            //final LatestTabModel.ViewItemsModel data = clst.get(position-1);

            // You have to set your listview items values with the help of model class and you can modify as per your needs
            //itemViewHolder.title.setText(data.getTitle());
            ((ItemViewHolder) holder).tv01.setText(clst.get(position-1).getId());
            ((ItemViewHolder) holder).tv02.setText(clst.get(position-1).getName());
            ((ItemViewHolder) holder).iv.setImageResource(clst.get(position-1).getPic());
            ((ItemViewHolder) holder).tv03.setText(clst.get(position-1).getPrice());

           ((ItemViewHolder) holder).ll.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   row_index=position;
                   notifyDataSetChanged();
               }
           });
            if(row_index==position) {
                ((ItemViewHolder) holder).ll.setBackgroundColor(Color.parseColor("#567845"));
            }
            else
            {
                ((ItemViewHolder) holder).ll.setBackgroundColor(Color.parseColor("#ffffff"));
            }


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
    public int getItemCount(){ return (clst.size()+1); }

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
        LinearLayout ll;
        public ItemViewHolder(View v){
            super(v);

            iv = v.findViewById(R.id.imageView);
            tv01 = v.findViewById(R.id.textViewId);
            tv02 = v.findViewById(R.id.textViewName);
            tv03 = v.findViewById(R.id.textViewPrice);
            ll = v.findViewById(R.id.item);


        }


//

        /*@Override
        public void onClick(View view) {
           // Toast.makeText(view.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            Object object = (Object) view.getTag();
            if (clst.contains(object)) {
                mSelectedObjects.remove(object);
                v.setBackground(null);
            } else {
                mSelectedObjects.add(object);
                v.setBackgroundColor(Color.GRAY);
            }

        }*/

    }
}

