package com.s92061491.pickworkers.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.s92061491.pickworkers.Adapter.CategoryAdapter;
import com.s92061491.pickworkers.Adapter.RecentAdapter;
import com.s92061491.pickworkers.Domain.CategoryDomain;
import com.s92061491.pickworkers.Domain.RecentServiceDomain;
import com.s92061491.pickworkers.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class firstFragment extends Fragment implements CatRecyclerViewInterface{
    private RecyclerView.Adapter adapter,adapter2;
    private TextView textView;
    private ArrayList<CategoryDomain> categoryDomains = new ArrayList<>();
    private RecyclerView recyclerViewCategory, recycleViewRecentList;

    private ImageView profileImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1,view2;
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        view1 = recyclerViewCategory(view,inflater,container);
        view2 = recyclerRecentService(view1,inflater,container);

        profileImageView = view2.findViewById(R.id.profileimageView);
        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),imageStories.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment

        return view2;

    }

    private View recyclerViewCategory(View view,LayoutInflater inflater,ViewGroup container){
        LinearLayoutManager liearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = view.findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(liearLayoutManager);


        categoryDomains.add(new CategoryDomain("Eletrical","cat_1"));
        categoryDomains.add(new CategoryDomain("Civil","cat_2"));
        categoryDomains.add(new CategoryDomain("Plumber","cat_3"));
        categoryDomains.add(new CategoryDomain("Wood","cat_4"));

        adapter = new CategoryAdapter(categoryDomains,this);
        recyclerViewCategory.setAdapter(adapter);
        return view;
    }
    private View recyclerRecentService(View view1,LayoutInflater inflater,ViewGroup container){

        LinearLayoutManager liearLayoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleViewRecentList = view1.findViewById(R.id.view2);
        recycleViewRecentList.setLayoutManager(liearLayoutManager1);

        ArrayList<RecentServiceDomain> RecentServiceDomains = new ArrayList<>();
        RecentServiceDomains.add(new RecentServiceDomain("Home decoration","fast_1",5.0,1.0));
        RecentServiceDomains.add(new RecentServiceDomain("Welding plant gate","fast_2",4.0,2.0));
        RecentServiceDomains.add(new RecentServiceDomain("Plumb work","fast_3",3.5,3.0));

        adapter2 = new RecentAdapter(RecentServiceDomains);
        recycleViewRecentList.setAdapter(adapter2);
        return view1;
    }


    @Override
    public void onClickCatItems(int position) {
        Intent intent = new Intent(getActivity(),categoryusers.class);
        intent.putExtra("CatName",categoryDomains.get(position).getTitle());
        startActivity(intent);


    }
}