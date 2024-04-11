package com.s92061491.pickworkers.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.s92061491.pickworkers.Domain.NotificationDomain;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    ArrayList<NotificationDomain> notificationAdapters;

    public NotificationAdapter(ArrayList<NotificationDomain> notificationAdapters) {
        this.notificationAdapters = notificationAdapters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_viewholder,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.notificationName.setText(notificationAdapters.get(position).getName());
        holder.datetime.setText(notificationAdapters.get(position).getDatetime());

    }

    @Override
    public int getItemCount() {
        return notificationAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView notificationName, datetime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationName=itemView.findViewById(R.id.notifyName);
            datetime=itemView.findViewById(R.id.datetime);
        }
    }
}
