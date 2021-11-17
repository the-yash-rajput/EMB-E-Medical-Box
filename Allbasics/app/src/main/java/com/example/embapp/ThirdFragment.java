package com.example.embapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThirdFragment extends Fragment {
    ViewPager viewPager;
    Button getstart,Back3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.activity_intro3, container, false);
        viewPager=getActivity().findViewById(R.id.viewpager);
        Back3=view.findViewById(R.id.back3);
        getstart=view.findViewById(R.id.getsartted);

        Back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        getstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });

        return view;
    }
}
