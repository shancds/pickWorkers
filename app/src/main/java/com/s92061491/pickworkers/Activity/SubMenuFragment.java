package com.s92061491.pickworkers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.s92061491.pickworkers.R;


public class SubMenuFragment extends Fragment {

    private CardView aboutUscardView, settingCardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sub_menu, container, false);
        aboutUscardView = rootView.findViewById(R.id.cardviewAboutus);
        aboutUscardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), aboutUs.class);
                startActivity(intent);
            }
        });

        settingCardView = rootView.findViewById(R.id.cardViewSettings);
        settingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }
}