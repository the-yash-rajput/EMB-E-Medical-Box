package com.example.embapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.embapp.Input2;
import com.example.embapp.Input3;
import com.example.embapp.Input4;
import com.example.embapp.Input5;
import com.example.embapp.InputActivity;
import com.example.embapp.R;

public class HomeFragment extends Fragment {




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


       
        Button but1 =root.findViewById(R.id.button1);
        Button but2 = root.findViewById(R.id.button2);
        Button but3 = root.findViewById(R.id.button3);
        Button but4 = root.findViewById(R.id.button4);
        Button but5 = root.findViewById(R.id.button5);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), Input2.class);
                HomeFragment.this.startActivity(myIntent);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), Input3.class);
                HomeFragment.this.startActivity(myIntent);
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), Input4.class);
                HomeFragment.this.startActivity(myIntent);
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), Input5.class);
                HomeFragment.this.startActivity(myIntent);
            }
        });

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), InputActivity.class);
                HomeFragment.this.startActivity(myIntent);

            }
        });





        return root;
    }

}
