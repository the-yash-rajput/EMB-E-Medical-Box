package com.example.embapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Intro extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro4);
        viewPager=findViewById(R.id.viewpager);

        SharedPreferences sharedPreferences= getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        String FirstTime=sharedPreferences.getString("FirstTimeInstall","");

        if(FirstTime.equals("Yes")){
            Intent intent=new Intent(Intro.this, navigationnew.class);
            startActivity(intent);
        }
        else{


        IntroAdapter eadapter= new IntroAdapter(getSupportFragmentManager());
        viewPager.setAdapter(eadapter);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("FirstTimeInstall", "Yes");
        editor.apply();
        }
    }
}
