package com.s92061491.pickworkers.Activity;


import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.s92061491.pickworkers.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategory, recycleViewRecentList;
    BottomNavigationView bottomNavigationView;

    NotificatioFragment notificatioFragment = new NotificatioFragment();
    SubMenuFragment subMenuFragment = new SubMenuFragment();
    firstFragment firstFragment = new firstFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,firstFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
                        transaction.replace(R.id.container,firstFragment).commit();

                        return true;
                    case R.id.notificatiom:
                        transaction.replace(R.id.container,notificatioFragment).commit();
                        return true;
                    case R.id.submenu:
                        transaction.replace(R.id.container,subMenuFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }

}