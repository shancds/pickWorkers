package com.s92061491.pickworkers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import java.util.ArrayList;
import com.s92061491.pickworkers.R;

public class numberVerification extends AppCompatActivity {
    private Button verifynextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verification);
        verifynextbtn = findViewById(R.id.verifynextbtn);
        verifynextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(numberVerification.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}