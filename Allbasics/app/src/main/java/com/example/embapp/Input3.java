package com.example.embapp;


import androidx.appcompat.app.AppCompatActivity;



import android.animation.Animator;

import android.app.TimePickerDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.AsyncTask;

import android.os.Bundle;

import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.widget.TimePicker;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class Input3 extends AppCompatActivity {

    EditText  selecttime2 ,medname2,quanname2,addtime22,addtime23,course2,startdate2,enddate2,showadd;
    TimePickerDialog timePickerDialog2;
    LinearLayout L2;

    Calendar calendar;
    int currentHour;
    int currentMinute;

    String amPm;
    String[] data;
    Button savedata2,cleardata2,addm2,bh2;
    ImageButton drop2,st51,st52,st53;

    LottieAnimationView my2;

    public static int count=0;
    public static int clear=1;
    public static final String SHARED_PREFS = "sharedprefs3";
    public static  final String Sd3 ="sd3";
    public static  final String St3 = "st3";
    public static  final String Md3="md3";
    public static final String Qn3="qn3";
    public static final String Add32="ad32";
    public static final String Add33="ad33";
    public static final String Cou3="cou3";

    private String sdd3;
    private String stt3;
    private String mdd3;
    private String qnn3;
    private String add32;
    private String add33;
    private String couu3;
    public String addd;

    public long alarmstarttime;




    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;

    private static final int REQUEST_ENABLE_BT=1;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input3);
        course2 = findViewById(R.id.course3);
        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        startdate2= findViewById(R.id.startdate3);
        enddate2=findViewById(R.id.edate3);
        startdate2.setInputType(InputType.TYPE_NULL);
        enddate2.setInputType(InputType.TYPE_NULL);
        L2=findViewById(R.id.layout37);
        my2=findViewById(R.id.success3);
        showadd=findViewById(R.id.myaddress3);
         st51=findViewById(R.id.st31);
         st52=findViewById(R.id.st32);
         st53=findViewById(R.id.st33);
        receiveadd();


        course2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String limit;
                limit = course2.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu3)) {
                        startdate2.setText(" ");
                        enddate2.setText(" ");
                    }
                    if (!course2.getText().toString().isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        startdate2.setText(" " + dateFormat.format(new Date()));
                        String dateInString = startdate2.getText().toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        Calendar c = Calendar.getInstance();

                        try {
                            c.setTime(sdf.parse(dateInString));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String temp = course2.getText().toString();
                        int days = 0;
                        if (!"".equals(temp)) {
                            days = Integer.parseInt(temp);
                            System.out.println(days);
                        }
                        c.add(Calendar.DATE, days);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
                        String output = sdf1.format(c.getTime());
                        enddate2.setText(output);
                    }
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String limit;
                limit = course2.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu3)) {
                        startdate2.setText(" ");
                        enddate2.setText(" ");
                    }
                    if (!course2.getText().toString().isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        startdate2.setText(" " + dateFormat.format(new Date()));
                        String dateInString = startdate2.getText().toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        Calendar c = Calendar.getInstance();

                        try {
                            c.setTime(sdf.parse(dateInString));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String temp = course2.getText().toString();
                        int days = 0;
                        if (!"".equals(temp)) {
                            days = Integer.parseInt(temp);
                            System.out.println(days);
                        }
                        c.add(Calendar.DATE, days);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
                        String output = sdf1.format(c.getTime());
                        enddate2.setText(output);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                String limit;
                limit = course2.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu3)) {
                        startdate2.setText(" ");
                        enddate2.setText(" ");
                    }
                    if (!course2.getText().toString().isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        startdate2.setText(" " + dateFormat.format(new Date()));
                        String dateInString = startdate2.getText().toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        Calendar c = Calendar.getInstance();

                        try {
                            c.setTime(sdf.parse(dateInString));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String temp = course2.getText().toString();
                        int days = 0;
                        if (!"".equals(temp)) {
                            days = Integer.parseInt(temp);
                            System.out.println(days);
                        }
                        c.add(Calendar.DATE, days);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
                        String output = sdf1.format(c.getTime());
                        enddate2.setText(output);
                    }
                }
            }
        });

        drop2=findViewById(R.id.smore3);

        drop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L2.setVisibility(View.VISIBLE);
                drop2.setClickable(false);
            }
        });



        addm2 = findViewById(R.id.addm3);
        selecttime2 = findViewById(R.id.time_picker3);
        addtime22 = findViewById(R.id.add_time32);
        addtime23 = findViewById(R.id.add_time33);
        addtime22.setInputType(InputType.TYPE_NULL);
        addtime23.setInputType(InputType.TYPE_NULL);
        selecttime2.setInputType(InputType.TYPE_NULL);
        st51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog2 = new TimePickerDialog(Input3.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        Calendar startTime=Calendar.getInstance();
                        startTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        startTime.set(Calendar.MINUTE,minutes);
                        startTime.set(Calendar.SECOND,0);
                        alarmstarttime=startTime.getTimeInMillis();
                        if (hourOfDay == 0) {
                            hourOfDay += 12;
                            amPm = "AM";
                        }
                        else if (hourOfDay == 12) {
                            amPm = "PM";
                        }
                        else if (hourOfDay > 12) {
                            hourOfDay -= 12;
                            amPm = "PM";
                        }
                        else {
                            amPm = "AM";
                        }
                        selecttime2.setText(String.format("%02d:%02d", hourOfDay, minutes) + " " + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog2.show();
            }
        });

        addm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addtime22.getVisibility() == View.VISIBLE) {
                    addtime23.setVisibility(View.VISIBLE);
                    st53.setVisibility(View.VISIBLE);
                }
                if (addtime22.getVisibility() == View.GONE) {
                    addtime22.setVisibility(View.VISIBLE);
                    st52.setVisibility(View.VISIBLE);
                }
                if (addtime22.getVisibility() == View.VISIBLE && addtime23.getVisibility() == View.VISIBLE) {
                    Toast.makeText(getApplicationContext(), "Time Count Exceeded , Can't Add More !!", LENGTH_SHORT).show();
                }
            }
        });
        st53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog2 = new TimePickerDialog(Input3.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay == 0) {
                            hourOfDay += 12;
                            amPm = "AM";
                        }
                        else if (hourOfDay == 12) {
                            amPm = "PM";
                        }
                        else if (hourOfDay > 12) {
                            hourOfDay -= 12;
                            amPm = "PM";
                        }
                        else {
                            amPm = "AM";
                        }
                        addtime23.setText(String.format("%02d:%02d", hourOfDay, minutes) + " " + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog2.show();
            }
        });
        st52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog2 = new TimePickerDialog(Input3.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay == 0) {
                            hourOfDay += 12;
                            amPm = "AM";
                        }
                        else if (hourOfDay == 12) {
                            amPm = "PM";
                        }
                        else if (hourOfDay > 12) {
                            hourOfDay -= 12;
                            amPm = "PM";
                        }
                        else {
                            amPm = "AM";
                        }

                        addtime22.setText(String.format("%02d:%02d", hourOfDay, minutes) + " " + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog2.show();
            }
        });
        medname2 = findViewById(R.id.med_name3);
        quanname2 = findViewById(R.id.qua_name3);
        savedata2 = findViewById(R.id.save_data3);
        bh2 = findViewById(R.id.bh3);
        bh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btSocket!=null) //If the btSocket is busy
                {
                    try
                    {
                        btSocket.close(); //close connection
                    }
                    catch (IOException e)
                    { msg("Error");}
                }
                finish(); //return to the first layout
            }
        });


        savedata2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (medname2.getText().toString().trim().length() == 0 || course2.getText().toString().trim().length() == 0 || quanname2.getText().toString().trim().length() == 0 || (selecttime2.getText().toString().trim().length() == 0 && addtime22.getText().toString().trim().length() == 0 && addtime23.getText().toString().trim().length() == 0)) {
                    if (medname2.getText().toString().trim().length() == 0 || course2.getText().toString().trim().length() == 0 || quanname2.getText().toString().trim().length() == 0) {
                        makeText(getApplicationContext(), "Please Enter All Data", LENGTH_LONG).show();
                    }
                    if (selecttime2.getText().toString().trim().length() == 0 && addtime22.getText().toString().trim().length() == 0 && addtime23.getText().toString().trim().length() == 0) {
                        makeText(getApplicationContext(), "Please Enter All Data", LENGTH_LONG).show();
                    }
                }
                else {
                    saveData();
                    showanimation();
                    my2.setVisibility(View.VISIBLE);


                    savedata2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(showadd.getText().toString().trim().length() == 0){
                                msg("First Add the MAC Address Of Device ");
                            }else{
                                enablebt();}
                            savedata2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(showadd.getText().toString().trim().length() == 0){
                                        msg("First Add the MAC Address Of Device ");
                                    }else{
                                        if(count==1){
                                            enablebt();
                                        }}
                                    if(count==2){
                                        sharedata();
                                    }

                                }
                            });
                        }
                    });
                }
            }
        });



        loadData();
        ;
        updateViews();
        cleardata2 = findViewById(R.id.clear_data3);
        cleardata2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showadd.getText().toString().trim().length() == 0){
                    msg("First Add the MAC Address Of Device ");
                }else{
                    enablebt12();}

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_ENABLE_BT){
            if(resultCode==RESULT_OK){
                new ConnectBT().execute();
            }
            else{
                msg("Bluetooth Request Rejected");
            }
        }
    }
    public void cleardata1(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor box1 = sharedPreferences.edit();
        box1.remove(Sd3);
        box1.remove(St3);
        box1.remove(Md3);
        box1.remove(Add32);
        box1.remove(Add33);
        box1.remove(Qn3);
        box1.remove(Cou3);
        box1.apply();

        selecttime2.setText("");
        medname2.setText("");
        quanname2.setText("");
        addtime22.setText("");
        addtime22.setVisibility(View.GONE);
        addtime23.setVisibility(View.GONE);
        addtime23.setText("");
        course2.setText("");
        L2.setVisibility(View.GONE);

        makeText(getApplicationContext(), "Data Cleared Successfully", LENGTH_LONG).show();

    }


    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }



    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true;
        ConnectDialog connectDialog=new ConnectDialog(Input3.this);
        @Override
        protected void onPreExecute()
        {
            connectDialog.startconnectdialog();
        }

        @Override
        protected Void doInBackground(Void... devices)
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(addd);
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();//start connection

                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. There Is No Nearby EMB Device ");
                count=1;

            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
                savedata2.setText("Share Data");
                my2.setVisibility(View.VISIBLE);
                showanimation();
                count=2;
            }
            connectDialog.dismissdialod();
        }

    }

    private class ConnectBT12 extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected
        ConnectDialog connectDialog=new ConnectDialog(Input3.this);

        @Override
        protected void onPreExecute()
        {
            connectDialog.startconnectdialog();  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(addd);//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();//start connection

                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. There Is No Nearby EMB Device ");


            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
                cleardata1();
                clearshare1();
                my2.setVisibility(View.VISIBLE);
                showanimation();


            }
            connectDialog.dismissdialod();
        }

    }

    public void enablebt(){
        if (myBluetooth == null) {

            Toast.makeText(getApplicationContext(), "Bluetooth is not supported", Toast.LENGTH_LONG).show();


        }
        if (!myBluetooth.isEnabled()) {

            Intent btintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(btintent, REQUEST_ENABLE_BT);
        }



        if (myBluetooth.isEnabled()) {
            new ConnectBT().execute();
        }
    }
    public void enablebt12(){
        if (myBluetooth == null) {

            Toast.makeText(getApplicationContext(), "Bluetooth is not supported", Toast.LENGTH_LONG).show();


        }
        if (!myBluetooth.isEnabled()) {

            Intent btintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(btintent, REQUEST_ENABLE_BT);
        }



        if (myBluetooth.isEnabled()) {
            new ConnectBT12().execute();
        }
    }
    public void receiveadd(){
        SharedPreferences result = getSharedPreferences("sharedprefs", MODE_PRIVATE);
        addd=result.getString("add","");
        showadd.setText(addd);

    }
    public void sharedata(){
        if(TextUtils.isEmpty(add33)){
            data=new String[]{"1",couu3,stt3,add32,mdd3,qnn3};
        }
        else if(TextUtils.isEmpty(add33) && TextUtils.isEmpty(add32)){
            data=new String[]{"1",couu3,stt3,mdd3,qnn3};
        }
        else{
            data=new String[]{"1",couu3,stt3,add32,add33,mdd3,qnn3};
        }
        if(btSocket!=null){
            try{
                btSocket.getOutputStream().write(data.toString().getBytes());
                //OutputStream os=btSocket.getOutputStream();
                //                ObjectOutputStream oos= new ObjectOutputStream(os);
                //                oos.writeObject(data);
                btSocket.close();
            }
            catch(IOException e)
            {
                msg("Error In Sending Data");
            }
        }

    }
    public void clearshare1(){
        if(btSocket!=null){
            try{
                btSocket.getOutputStream().write("clear".getBytes());
                //OutputStream os=btSocket.getOutputStream();
                //                ObjectOutputStream oos= new ObjectOutputStream(os);
                //                oos.writeObject(data);
                btSocket.close();
            }
            catch(IOException e)
            {
                msg("Error In Clearing Data");
            }
        }

    }
    public void saveData() {
        SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor box3=sharedPreferences3.edit();


        box3.putString(St3,selecttime2.getText().toString());
        box3.putString(Md3,medname2.getText().toString());
        box3.putString(Qn3,quanname2.getText().toString());
        box3.putString(Add32,addtime22.getText().toString());
        box3.putString(Add33,addtime23.getText().toString());
        box3.putString(Cou3,course2.getText().toString());
        savedata2.setText("Connect");




        box3.apply();
        makeText(this, "Data Saved To EMB App", LENGTH_LONG).show();





    }
    public  void loadData(){

        SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        sdd3= sharedPreferences3.getString(Sd3,"");
        stt3= sharedPreferences3.getString(St3,"");
        mdd3= sharedPreferences3.getString(Md3,"");
        qnn3= sharedPreferences3.getString(Qn3,"");
        add33= sharedPreferences3.getString(Add33,"");
        add32= sharedPreferences3.getString(Add32,"");
        couu3= sharedPreferences3.getString(Cou3,"");}



    public void updateViews(){
        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        selecttime2.setText(stt3);
        medname2.setText(mdd3);
        quanname2.setText(qnn3);
        if(TextUtils.isEmpty(add32)){
            addtime22.setVisibility(View.GONE);
        }else{
            addtime22.setText(add32);}
        if(TextUtils.isEmpty(add33)){
            addtime23.setVisibility(View.GONE);
        }else{
            addtime23.setText(add33);}
        course2.setText(couu3);
    }
    public  void showanimation(){
        my2.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                my2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                my2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                my2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                my2.setVisibility(View.INVISIBLE);
            }


        });


    }





}
