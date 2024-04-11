package com.s92061491.pickworkers.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.storyViewHolder> {

    private ArrayList<DataClass> dataList;
    private Context context;

    public storyAdapter(ArrayList<DataClass> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public storyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_si, parent, false);
        return new storyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull storyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getImgURL()).into(holder.recyclerImage);
        holder.recyclerCation.setText(dataList.get(position).getCaption());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class storyViewHolder extends RecyclerView.ViewHolder{

        ImageView recyclerImage;
        TextView recyclerCation;
        public storyViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerImage = itemView.findViewById(R.id.recyclerStoryImage);
            recyclerCation = itemView.findViewById(R.id.recycler_caption);


        }
    }

}
