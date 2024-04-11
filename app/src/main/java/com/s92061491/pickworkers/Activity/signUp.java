package com.s92061491.pickworkers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.s92061491.pickworkers.R;
import com.s92061491.pickworkers.databinding.ActivitySignUpBinding;

public class signUp extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signUpNextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.signUpUsernameedittxt.getText().toString();
                String email = binding.emailedittxt.getText().toString();
                String phoneNumber = binding.editTextNumber.getText().toString();
                String password = binding.signInEditTextTextPassword.getText().toString();
                String comfirmPassword = binding.conformPassword.getText().toString();

                if(email.equals("") || password.equals("") || comfirmPassword.equals(""))
                    Toast.makeText(signUp.this,"All fileds are mandatory",Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(comfirmPassword)){
                        Boolean checkuserEmail = databaseHelper.checkUserEmail(email);

                        if(checkuserEmail == false){
                            Boolean insert = databaseHelper.insertUserData(userName,email,phoneNumber,password);

                            if(insert == true){
                                Toast.makeText(signUp.this,"Signup Successfuly",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), signIn.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(signUp.this,"Sign up failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(signUp.this,"User already exists, Please login",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(signUp.this,"Invalid Password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signInRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), signIn.class);
                startActivity(intent);
            }
        });

    }
}