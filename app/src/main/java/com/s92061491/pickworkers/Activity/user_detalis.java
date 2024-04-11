package com.s92061491.pickworkers.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.s92061491.pickworkers.R;

public class user_detalis extends AppCompatActivity {
    private TextView user_name,job_title,desc_;
    private ImageView backbtn;

    private Button sucessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detalis);
        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

        user_name = findViewById(R.id.detalisusername);
        job_title = findViewById(R.id.userDetailsJobtitle);
        desc_ = findViewById(R.id.userDetailsDescription);
        backbtn = findViewById(R.id.backbtn);
        sucessButton = findViewById(R.id.sendRequstButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String userName = getIntent().getStringExtra("UserName");
        String jobTitle = getIntent().getStringExtra("JobTitle");
        String desc = getIntent().getStringExtra("Desc");

        user_name.setText(userName);
        job_title.setText(jobTitle);
        desc_.setText(desc);

        sucessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSuccessDialog();
            }
        });



    }
    private void showSuccessDialog(){
        ConstraintLayout successConstraintLayout = findViewById(R.id.successConstraintLayout);
        View view = LayoutInflater.from(user_detalis.this).inflate(R.layout.success_dialog, successConstraintLayout);
        Button successDone = view.findViewById(R.id.successDone);

        AlertDialog.Builder builder = new AlertDialog.Builder(user_detalis.this);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        successDone.findViewById(R.id.successDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(user_detalis.this,"Done", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(user_detalis.this, MainActivity.class);
                startActivity(intent);
            }
        });
        if(alertDialog != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}