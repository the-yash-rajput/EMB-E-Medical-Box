package com.example.embapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

class ConnectDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    ConnectDialog(Activity myactivity){
       activity=myactivity;
    }

    void startconnectdialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        LayoutInflater inflater=activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.connectdialog,null));
        builder.setCancelable(false);


        alertDialog=builder.create();
        alertDialog.show();
    }

    void dismissdialod(){
        alertDialog.dismiss();
    }
}
