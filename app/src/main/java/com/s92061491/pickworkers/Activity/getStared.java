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

public class getStared extends AppCompatActivity {
    private Button get_Stared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_stared);

        // login selector button click
        get_Stared = findViewById(R.id.getStarted);
        get_Stared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getStared.this, signInUp.class);
                startActivity(intent);
            }
        });
    }
}