package com.s92061491.pickworkers.Adapter;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.s92061491.pickworkers.Activity.CatRecyclerViewInterface;
import com.s92061491.pickworkers.Activity.firstFragment;
import com.s92061491.pickworkers.Activity.user_detalis;
import com.s92061491.pickworkers.Domain.CategoryDomain;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private final CatRecyclerViewInterface catRecyclerViewInterface;
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains, firstFragment catRecyclerViewInterface ) {
        this.categoryDomains = categoryDomains;
        this.catRecyclerViewInterface = catRecyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int veiwType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflater, catRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String imgUrl ="";
        switch (position){
            case 0:{
                imgUrl="cat_1";
                break;
            }
            case 1:{
                imgUrl="cat_2";
                break;
            }
            case 2:{
                imgUrl="cat_3";
                break;
            }
            case 3:{
                imgUrl="cat_4";
                break;
            }

        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(imgUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryImg);




    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryImg;

        public ViewHolder(@NonNull View itemView, CatRecyclerViewInterface catRecyclerViewInterface) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryImg = itemView.findViewById(R.id.categoryImg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (catRecyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            catRecyclerViewInterface.onClickCatItems(pos);
                        }

                    }
                }
            });
        }

    }
}
