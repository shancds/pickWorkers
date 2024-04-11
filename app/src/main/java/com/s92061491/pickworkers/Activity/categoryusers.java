package com.s92061491.pickworkers.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.s92061491.pickworkers.Adapter.UserCategoryAdapter;
import com.s92061491.pickworkers.Domain.UsercategoryListDomain;
import com.s92061491.pickworkers.R;

import java.util.ArrayList;

public class categoryusers extends AppCompatActivity implements CatRecyclerViewInterface {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewUsers;
    private TextView textView;
    private ImageView backbtn;
    ArrayList<UsercategoryListDomain> UsersList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryusers);
        String catName = getIntent().getStringExtra("CatName");
        LinearLayoutManager liearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewUsers = findViewById(R.id.userlistrecyclerview);
        recyclerViewUsers.setLayoutManager(liearLayoutManager);
        TextView cat_name = findViewById(R.id.cat_username);
        cat_name.setText(catName);

        UsersList.add(new UsercategoryListDomain("Thilina","Electrical Engineer","Kandy","electrical engineer can vary depending on the industry they work in, the specific role they perform, and their level of experience. However, in general, the job title of an electrical engineer typically reflects their responsibilities and area of specialization."));
        UsersList.add(new UsercategoryListDomain("Nuwan","Civil Engineer","Colombo","responsible for designing electrical systems and components for a wide range of applications, including power distribution, control systems, and electronic devices."));
        UsersList.add(new UsercategoryListDomain("Thushara","Mechanic Engineer","Gampaha","responsible for designing and maintaining electrical power systems, including transmission lines, substations, and generators."));

        adapter = new UserCategoryAdapter(this,UsersList);
        recyclerViewUsers.setAdapter(adapter);

        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onClickCatItems(int position) {
        Intent intent = new Intent(categoryusers.this,user_detalis.class);
        intent.putExtra("UserName",UsersList.get(position).getUsername());
        intent.putExtra("JobTitle",UsersList.get(position).getJobtitle());
        intent.putExtra("Location",UsersList.get(position).getLocation());
        intent.putExtra("Desc",UsersList.get(position).getDesc());
        startActivity(intent);

    }
}