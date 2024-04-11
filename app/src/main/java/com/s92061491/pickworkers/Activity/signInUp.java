package com.s92061491.pickworkers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.s92061491.pickworkers.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import java.util.ArrayList;

public class signInUp extends AppCompatActivity {
    private Button sign_up,sign_in,googleconnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);

        // sign Up selector button click
        sign_up = findViewById(R.id.creatNewAccount);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signInUp.this,signUp.class);
                startActivity(intent);
            }
        });

        //sign in on click
        sign_in = findViewById(R.id.signIn);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signInUp.this, signIn.class);
                startActivity(intent);
            }
        });

        googleconnect = findViewById(R.id.other);
        googleconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signInUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}