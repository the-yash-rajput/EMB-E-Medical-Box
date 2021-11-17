package com.example.embapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.embapp.R;

public class GalleryFragment extends Fragment {
    LottieAnimationView email;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        email=root.findViewById(R.id.mailani);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                String [] recipients={"manojsirvi2602@gmail.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL,recipients);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"");
                emailIntent.putExtra(Intent.EXTRA_TEXT," ");
                emailIntent.putExtra(Intent.EXTRA_CC," ");
                emailIntent.setType("text/html");
               emailIntent.setPackage("com.google.android.gm");
               startActivity(Intent.createChooser(emailIntent,"Send mail"));
            }
        });
        return root;
    }
}
