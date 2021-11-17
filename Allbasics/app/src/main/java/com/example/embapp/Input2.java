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

public class Input2 extends AppCompatActivity {

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
    public static final String SHARED_PREFS = "sharedprefs2";
    public static  final String Sd2 ="sd2";
    public static  final String St2 = "st2";
    public static  final String Md2="md2";
    public static final String Qn2="qn2";
    public static final String Add22="ad12";
    public static final String Add23="ad23";
    public static final String Cou2="cou2";

    private String sdd2;
    private String stt2;
    private String mdd2;
    private String qnn2;
    private String add22;
    private String add23;
    private String couu2;
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
        setContentView(R.layout.activity_input2);
        course2 = findViewById(R.id.course2);
        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        startdate2= findViewById(R.id.startdate2);
        enddate2=findViewById(R.id.edate2);
        startdate2.setInputType(InputType.TYPE_NULL);
        enddate2.setInputType(InputType.TYPE_NULL);
        L2=findViewById(R.id.layout26);
        my2=findViewById(R.id.success2);
        showadd=findViewById(R.id.myaddress2);
        st51=findViewById(R.id.st21);
        st52=findViewById(R.id.st22);
        st53=findViewById(R.id.st23);




        course2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String limit;
                limit = course2.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu2)) {
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
                    if (TextUtils.isEmpty(couu2)) {
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
                    if (TextUtils.isEmpty(couu2)) {
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

        drop2=findViewById(R.id.smore2);

        drop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L2.setVisibility(View.VISIBLE);
                drop2.setClickable(false);
            }
        });



        addm2 = findViewById(R.id.addm2);
        selecttime2 = findViewById(R.id.time_picker2);
        addtime22 = findViewById(R.id.add_time22);
        addtime23 = findViewById(R.id.add_time23);
        addtime22.setInputType(InputType.TYPE_NULL);
        addtime23.setInputType(InputType.TYPE_NULL);
        selecttime2.setInputType(InputType.TYPE_NULL);
        st51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog2 = new TimePickerDialog(Input2.this, new TimePickerDialog.OnTimeSetListener() {
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

                timePickerDialog2 = new TimePickerDialog(Input2.this, new TimePickerDialog.OnTimeSetListener() {
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

                timePickerDialog2 = new TimePickerDialog(Input2.this, new TimePickerDialog.OnTimeSetListener() {
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
        medname2 = findViewById(R.id.med_name2);
        quanname2 = findViewById(R.id.qua_name2);
        savedata2 = findViewById(R.id.save_data2);
        bh2 = findViewById(R.id.bh2);
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
        receiveadd();
        updateViews();
        cleardata2 = findViewById(R.id.clear_data2);
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
        box1.remove(Sd2);
        box1.remove(St2);
        box1.remove(Md2);
        box1.remove(Add22);
        box1.remove(Add23);
        box1.remove(Qn2);
        box1.remove(Cou2);
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
        private boolean ConnectSuccess = true; //if it's here, it's almost connected
        ConnectDialog connectDialog=new ConnectDialog(Input2.this);
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
        ConnectDialog connectDialog=new ConnectDialog(Input2.this);

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
    public void sharedata(){
        if(TextUtils.isEmpty(add23)){
            data=new String[]{"1",couu2,stt2,add22,mdd2,qnn2};
        }
        else if(TextUtils.isEmpty(add23) && TextUtils.isEmpty(add22)){
            data=new String[]{"1",couu2,stt2,mdd2,qnn2};
        }
        else{
            data=new String[]{"1",couu2,stt2,add22,add23,mdd2,qnn2};
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
    public void receiveadd(){
        SharedPreferences result = getSharedPreferences("sharedprefs", MODE_PRIVATE);
        addd=result.getString("add","");
        showadd.setText(addd);

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
        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor box2 =sharedPreferences2.edit();


        box2.putString(St2,selecttime2.getText().toString());
        box2.putString(Md2,medname2.getText().toString());
        box2.putString(Qn2,quanname2.getText().toString());
        box2.putString(Add22,addtime22.getText().toString());
        box2.putString(Add23,addtime23.getText().toString());
        box2.putString(Cou2,course2.getText().toString());
        savedata2.setText("Connect");




        box2.commit();
        makeText(this, "Data Saved To EMB App", LENGTH_LONG).show();





    }
    public  void loadData(){

        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        sdd2= sharedPreferences2.getString(Sd2,"");
        stt2= sharedPreferences2.getString(St2,"");
        mdd2= sharedPreferences2.getString(Md2,"");
        qnn2= sharedPreferences2.getString(Qn2,"");
        add23= sharedPreferences2.getString(Add23,"");
        add22= sharedPreferences2.getString(Add22,"");
        couu2= sharedPreferences2.getString(Cou2,"");}



    public void updateViews(){


        selecttime2.setText(stt2);
        medname2.setText(mdd2);
        quanname2.setText(qnn2);
        if(TextUtils.isEmpty(add22)){
            addtime22.setVisibility(View.GONE);
        }else{
            addtime22.setText(add22);}
        if(TextUtils.isEmpty(add23)){
            addtime23.setVisibility(View.GONE);
        }else{
            addtime23.setText(add23);}
        course2.setText(couu2);
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







