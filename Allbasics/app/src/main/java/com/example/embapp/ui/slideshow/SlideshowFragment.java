package com.example.embapp.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.embapp.R;

public class SlideshowFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        ImageButton ig1= root.findViewById(R.id.ig1);
        ImageButton ig2= root.findViewById(R.id.ig2);
        ImageButton ig3= root.findViewById(R.id.ig3);
        ImageButton ig4= root.findViewById(R.id.ig4);
        ImageButton ig5= root.findViewById(R.id.ig5);
        ImageButton ig6= root.findViewById(R.id.ig6);
        ImageButton li1= root.findViewById(R.id.li1);
        ImageButton li2= root.findViewById(R.id.li2);
        ImageButton li3= root.findViewById(R.id.li3);
        ImageButton li4= root.findViewById(R.id.li4);
        ImageButton li5= root.findViewById(R.id.li5);
        ImageButton li6= root.findViewById(R.id.li6);


        ig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_man0j26_"));
                startActivity(ig1);
            }
        });
        ig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/onkar_2020"));
                startActivity(ig2);
            }
        });
        ig3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/rutvij_wa"));
                startActivity(ig3);
            }
        });
        ig4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig4=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/tanmaykale25"));
                startActivity(ig4);
            }
        });
        ig5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig5=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/hangman_vedant"));
                startActivity(ig5);
            }
        });
        ig6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/yash.rajput__"));
                startActivity(ig6);
            }
        });
        li3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rutvij-wamanse-b7b7101a2/"));
                startActivity(ig6);
            }
        });
        li4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/tanmay-kale-a12bab190/"));
                startActivity(ig6);
            }
        });
        li2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/onkar-saudagar-83a9a4192"));
                startActivity(ig6);
            }
        });
        li6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/yash-rajput-8b642b18b"));
                startActivity(ig6);
            }
        });
        li1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/manoj-sirvi-83625818b"));
                startActivity(ig6);
            }
        });

        return  root;
    }
}
