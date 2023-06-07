package com.example.example2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHorder> {

    private ArrayList<item_list> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<item_list> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHorder holder = new CustomViewHorder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHorder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getP_pic())
                .into(holder.p_pic);
        holder.p_name.setText(arrayList.get(position).getP_name());
        holder.p_say.setText(arrayList.get(position).getP_say());
        holder.p_price.setText(String.valueOf(arrayList.get(position).getP_price()));

    }

    @Override
    public int getItemCount() {
        // 삼항연산자 if 참 array~ 거짓 0
        return (arrayList !=null ? arrayList.size() : 0);
    }

    public class CustomViewHorder extends RecyclerView.ViewHolder {
        ImageView p_pic;
        TextView p_name;
        TextView p_say;
        TextView p_price;
        public CustomViewHorder(@NonNull View itemView) {
            super(itemView);
            this.p_pic= itemView.findViewById(R.id.p_pic);
            this.p_name= itemView.findViewById(R.id.p_name);
            this.p_say= itemView.findViewById(R.id.p_say);
            this.p_price= itemView.findViewById(R.id.p_price);
        }
    }
}
