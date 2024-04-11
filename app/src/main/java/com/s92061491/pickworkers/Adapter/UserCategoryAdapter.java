package com.s92061491.pickworkers.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.s92061491.pickworkers.Activity.CatRecyclerViewInterface;
import com.s92061491.pickworkers.Domain.UsercategoryListDomain;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;

public class UserCategoryAdapter extends RecyclerView.Adapter<UserCategoryAdapter.Viewholder>{
    private final CatRecyclerViewInterface catRecyclerViewInterface;
    ArrayList<UsercategoryListDomain> usercategoryListAdapter;

    public UserCategoryAdapter(CatRecyclerViewInterface catRecyclerViewInterface, ArrayList<UsercategoryListDomain> usercategoryListAdapter) {
        this.catRecyclerViewInterface = catRecyclerViewInterface;
        this.usercategoryListAdapter = usercategoryListAdapter;
    }

    @NonNull
    @Override
    public UserCategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card_view_holder,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.username.setText(usercategoryListAdapter.get(position).getUsername());
        holder.jobtitle.setText(usercategoryListAdapter.get(position).getJobtitle());
        holder.location.setText(usercategoryListAdapter.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return usercategoryListAdapter.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        TextView username,jobtitle,location;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            jobtitle = itemView.findViewById(R.id.jobtitle);
            location = itemView.findViewById(R.id.location);
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
