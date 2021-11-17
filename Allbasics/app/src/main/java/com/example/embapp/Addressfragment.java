package com.example.embapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Addressfragment extends Fragment {
    Button skipadd,nextadd;
    EditText address;
    public static final String Addd="add";
    private String addd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addressfragment, container, false);


        skipadd=root.findViewById(R.id.skipadd);
        nextadd=root.findViewById(R.id.btnadd);
        address=root.findViewById(R.id.macaddress);
        skipadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go =new Intent(Addressfragment.this.getActivity(),navigationnew.class);
                getActivity().startActivity(go);
            }
        });
        nextadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length =address.getText().length();
                if(length==17){
                    String add;
                    add=address.getText().toString();


                    SharedPreferences devviceadd =getActivity().getSharedPreferences("sharedprefs",Context.MODE_PRIVATE);
                    SharedPreferences.Editor devicead =devviceadd.edit();
                    devicead.putString(Addd,add);
                    devicead.apply();
                    Intent go =new Intent(Addressfragment.this.getActivity(),navigationnew.class);
                    startActivity(go);

                }
                else{
                    Toast.makeText(getContext(),"Enter Valid MAC Address",Toast.LENGTH_SHORT).show();
                }
            }
        });
        SharedPreferences devviceadd = getActivity().getSharedPreferences("sharedprefs", Context.MODE_PRIVATE);
        addd=devviceadd.getString(Addd,"");
        address.setText(addd);


    return root;
    }

}
