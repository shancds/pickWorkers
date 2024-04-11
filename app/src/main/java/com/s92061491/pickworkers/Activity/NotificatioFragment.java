package com.s92061491.pickworkers.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.s92061491.pickworkers.Adapter.NotificationAdapter;
import com.s92061491.pickworkers.Domain.NotificationDomain;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;


public class NotificatioFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewNotification;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view,view1;
        view = inflater.inflate(R.layout.fragment_notificatio, container, false);
        view1 = recyclerViewNotification(view,inflater,container);
        return view1;

    }
    private View recyclerViewNotification(View view,LayoutInflater inflater,ViewGroup container){
        LinearLayoutManager liearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewNotification = view.findViewById(R.id.notificationrecyclerview);
        recyclerViewNotification.setLayoutManager(liearLayoutManager);

        ArrayList<NotificationDomain> notificationList = new ArrayList<>();
        notificationList.add(new NotificationDomain("Shan","1 Hour ago"));
        notificationList.add(new NotificationDomain("Thilina","7 Hour ago"));
        notificationList.add(new NotificationDomain("Kokila","1 Day"));
        notificationList.add(new NotificationDomain("Sadun","2 Days"));



        adapter = new NotificationAdapter(notificationList);
        recyclerViewNotification.setAdapter(adapter);

        return view;
    }
}