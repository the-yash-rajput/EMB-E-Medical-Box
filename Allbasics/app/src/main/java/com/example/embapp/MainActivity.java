package com.example.embapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 2500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O ){
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent inputIntent = new Intent(MainActivity.this,Intro.class);
                startActivity(inputIntent);
                finish();

            }
        },SPLASH_TIME_OUT);}
        else {
            Intent inputIntent = new Intent(MainActivity.this,Intro.class);
            startActivity(inputIntent);
            finish();
        }
    }
}
