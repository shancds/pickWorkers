package com.s92061491.pickworkers.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.s92061491.pickworkers.Domain.RecentServiceDomain;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.Viewholder> {
    ArrayList<RecentServiceDomain> recentServiceDomains;

    public RecentAdapter(ArrayList<RecentServiceDomain> recentServiceDomains) {
        this.recentServiceDomains = recentServiceDomains;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recent,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String day;
        holder.title.setText(recentServiceDomains.get(position).getTitle());
        if(Double.valueOf(recentServiceDomains.get(position).getTime()) > 1){
            day = " Days";
        }
        else {
            day = " Day";
        }
        holder.time.setText(String.valueOf(recentServiceDomains.get(position).getTime())+day);
        holder.star.setText(String.valueOf(recentServiceDomains.get(position).getStar()));


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(recentServiceDomains.get(position).getImg(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.img);




    }

    @Override
    public int getItemCount() {
        return recentServiceDomains.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title,time,star;
        ImageView img;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.recentImg);
            star = itemView.findViewById(R.id.textView12);
            time = itemView.findViewById(R.id.time);
        }
    }
}
