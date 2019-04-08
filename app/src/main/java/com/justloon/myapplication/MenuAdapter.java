package com.justloon.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<ModelMenu> mList;
    private Context mContext;

    MenuAdapter(Context context, ArrayList<ModelMenu> list){
        mContext = context;
        mList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.list_menu_items, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        ModelMenu menuItem = mList.get(position);
        ImageView image = viewHolder.item_image;
        TextView name,price,deskripsi;

        name = viewHolder.item_name;
        price = viewHolder.item_price;
        deskripsi = viewHolder.item_deskripsi;

        image.setImageResource(menuItem.getImage());
        name.setText(menuItem.getName());
        price.setText(menuItem.getPrice());
        deskripsi.setText(menuItem.getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_name,item_price, item_deskripsi;

        public ViewHolder(View itemView){
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_deskripsi = itemView.findViewById(R.id.item_deskripsi);
        }
    }
}
