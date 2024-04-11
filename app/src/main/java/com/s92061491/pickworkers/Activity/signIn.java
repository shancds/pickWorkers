package com.s92061491.pickworkers.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Owner;

import com.s92061491.pickworkers.R;
import com.s92061491.pickworkers.databinding.ActivitySignInBinding;

public class signIn extends AppCompatActivity {
    ActivitySignInBinding binding;
    DatabaseHelper databaseHelper;
    private Button sign_in_next;
    private TextView user_name, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signInNextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.signInEmailedittxt.getText().toString();
                String password = binding.signInEditTextTextPassword.getText().toString();

                if(email.equals("") || password.equals(""))
                    Toast.makeText(signIn.this,"All fileds are mandatory",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = databaseHelper.checkUserEmailPassword(email,password);

                    if(checkCredentials ==true){
                        Toast.makeText(signIn.this,"Login successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(signIn.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        binding.createAccounttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signIn.this, signUp.class);
                startActivity(intent);
            }
        });




    }
}