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


public class InputActivity extends AppCompatActivity {

    EditText  selecttime1 ,medname1,quanname1,addtime12,addtime13,course1,startdate1,enddate1;
    TimePickerDialog timePickerDialog;
    LinearLayout L1;
    
    Calendar calendar;
    int currentHour;
    int currentMinute;

    String amPm;
    String[] data;
    Button savedata1,cleardata1,addm1,bh1;
    ImageButton drop1,st51,st52,st53;

    LottieAnimationView my;
    EditText showadd;

    public static int count=0;
    public static int clear=1;
    public static final String SHARED_PREFS = "sharedprefs";
    public static  final String Sd1 ="sd1";
    public static  final String St1 = "st1";
    public static  final String Md1="md1";
    public static final String Qn1="qn1";
    public static final String Add12="ad12";
    public static final String Add13="ad13";
    public static final String Cou1="cou1";



    private String sdd1;
    private String stt1;
    private String mdd1;
    private String qnn1;
    private String add12;
    private String add13;
    private String couu1;
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
        setContentView(R.layout.activity_input);
        course1 = findViewById(R.id.course1);
        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        startdate1= findViewById(R.id.startdate1);
        enddate1=findViewById(R.id.edate1);
        startdate1.setInputType(InputType.TYPE_NULL);
        enddate1.setInputType(InputType.TYPE_NULL);
        L1=findViewById(R.id.layout1);
        my=findViewById(R.id.success);
        showadd=findViewById(R.id.myaddress);
        st51=findViewById(R.id.st11);
        st52=findViewById(R.id.st12);
        st53=findViewById(R.id.st13);




        course1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String limit;
                limit = course1.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu1)) {
                        startdate1.setText(" ");
                        enddate1.setText(" ");
                    }
                    if (!course1.getText().toString().isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        startdate1.setText(" " + dateFormat.format(new Date()));
                        String dateInString = startdate1.getText().toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        Calendar c = Calendar.getInstance();

                        try {
                            c.setTime(sdf.parse(dateInString));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String temp = course1.getText().toString();
                        int days = 0;
                        if (!"".equals(temp)) {
                            days = Integer.parseInt(temp);
                            System.out.println(days);
                        }
                        c.add(Calendar.DATE, days);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
                        String output = sdf1.format(c.getTime());
                        enddate1.setText(output);
                    }
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String limit;
                limit = course1.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu1)) {
                        startdate1.setText(" ");
                        enddate1.setText(" ");
                    }
                    if (!course1.getText().toString().isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        startdate1.setText(" " + dateFormat.format(new Date()));
                        String dateInString = startdate1.getText().toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        Calendar c = Calendar.getInstance();

                        try {
                            c.setTime(sdf.parse(dateInString));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String temp = course1.getText().toString();
                        int days = 0;
                        if (!"".equals(temp)) {
                            days = Integer.parseInt(temp);
                            System.out.println(days);
                        }
                        c.add(Calendar.DATE, days);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
                        String output = sdf1.format(c.getTime());
                        enddate1.setText(output);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                String limit;
                limit = course1.getText().toString();
                if (limit.length() >= 11) {
                    msg("Please Enter Valid No of days");
                } else {
                    if (TextUtils.isEmpty(couu1)) {
                        startdate1.setText(" ");
                        enddate1.setText(" ");
                    }
                    if (!course1.getText().toString().isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        startdate1.setText(" " + dateFormat.format(new Date()));
                        String dateInString = startdate1.getText().toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        Calendar c = Calendar.getInstance();

                        try {
                            c.setTime(sdf.parse(dateInString));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String temp = course1.getText().toString();
                        int days = 0;
                        if (!"".equals(temp)) {
                            days = Integer.parseInt(temp);
                            System.out.println(days);
                        }
                        c.add(Calendar.DATE, days);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
                        String output = sdf1.format(c.getTime());
                        enddate1.setText(output);
                    }
                }
            }
        });

        drop1=findViewById(R.id.smore1);

        drop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setVisibility(View.VISIBLE);
                drop1.setClickable(false);
            }
        });



        addm1 = findViewById(R.id.addm1);
        selecttime1 = findViewById(R.id.time_picker1);
        addtime12 = findViewById(R.id.add_time12);
        addtime13 = findViewById(R.id.add_time13);
        addtime12.setInputType(InputType.TYPE_NULL);
        addtime13.setInputType(InputType.TYPE_NULL);
        selecttime1.setInputType(InputType.TYPE_NULL);
        st51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(InputActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                        selecttime1.setText(String.format("%02d:%02d", hourOfDay, minutes) + " " + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });

        addm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addtime12.getVisibility() == View.VISIBLE) {
                    addtime13.setVisibility(View.VISIBLE);
                    st53.setVisibility(View.VISIBLE);
                }
                if (addtime12.getVisibility() == View.GONE) {
                    addtime12.setVisibility(View.VISIBLE);
                    st52.setVisibility(View.VISIBLE);
                }
                if (addtime12.getVisibility() == View.VISIBLE && addtime13.getVisibility() == View.VISIBLE) {
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

                timePickerDialog = new TimePickerDialog(InputActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                        addtime13.setText(String.format("%02d:%02d", hourOfDay, minutes) + " " + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });
        st52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(InputActivity.this, new TimePickerDialog.OnTimeSetListener() {
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

                        addtime12.setText(String.format("%02d:%02d", hourOfDay, minutes) + " " + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });
        medname1 = findViewById(R.id.med_name1);
        quanname1 = findViewById(R.id.qua_name1);
        savedata1 = findViewById(R.id.save_data1);
        bh1 = findViewById(R.id.bh1);
        bh1.setOnClickListener(new View.OnClickListener() {
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


        savedata1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (medname1.getText().toString().trim().length() == 0 || course1.getText().toString().trim().length() == 0 || quanname1.getText().toString().trim().length() == 0 || (selecttime1.getText().toString().trim().length() == 0 && addtime12.getText().toString().trim().length() == 0 && addtime13.getText().toString().trim().length() == 0)) {
                    if (medname1.getText().toString().trim().length() == 0 || course1.getText().toString().trim().length() == 0 || quanname1.getText().toString().trim().length() == 0) {
                        makeText(getApplicationContext(), "Please Enter All Data", LENGTH_LONG).show();
                    }
                    if (selecttime1.getText().toString().trim().length() == 0 && addtime12.getText().toString().trim().length() == 0 && addtime13.getText().toString().trim().length() == 0) {
                        makeText(getApplicationContext(), "Please Enter All Data", LENGTH_LONG).show();
                    }
                }
                else {

                    saveData();

                    showanimation();
                    my.setVisibility(View.VISIBLE);


                         savedata1.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 if(showadd.getText().toString().trim().length() == 0){
                                     msg("First Add the MAC Address Of Device ");
                                 }else{
                                 enablebt();}
                                    savedata1.setOnClickListener(new View.OnClickListener() {
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
        cleardata1 = findViewById(R.id.clear_data1);
        cleardata1.setOnClickListener(new View.OnClickListener() {
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
        box1.remove(Sd1);
        box1.remove(St1);
        box1.remove(Md1);
        box1.remove(Add12);
        box1.remove(Add13);
        box1.remove(Qn1);
        box1.remove(Cou1);
        box1.apply();

        selecttime1.setText("");
        medname1.setText("");
        quanname1.setText("");
        addtime12.setText("");
        addtime12.setVisibility(View.GONE);
        addtime13.setVisibility(View.GONE);
        addtime13.setText("");
        course1.setText("");
        L1.setVisibility(View.GONE);

        makeText(getApplicationContext(), "Data Cleared Successfully", LENGTH_LONG).show();

    }


    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }



    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected
        ConnectDialog connectDialog=new ConnectDialog(InputActivity.this);
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
                savedata1.setText("Share Data");
                my.setVisibility(View.VISIBLE);
                showanimation();
                count=2;
            }
            connectDialog.dismissdialod();
        }

    }

    private class ConnectBT12 extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected
        ConnectDialog connectDialog=new ConnectDialog(InputActivity.this);

        @Override
        protected void onPreExecute()
        {
            connectDialog.startconnectdialog();
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
                my.setVisibility(View.VISIBLE);
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
        if(TextUtils.isEmpty(add13)){
        data=new String[]{"1",couu1,stt1,add12,mdd1,qnn1};
        }
        else if(TextUtils.isEmpty(add13) && TextUtils.isEmpty(add12)){
            data=new String[]{"1",couu1,stt1,mdd1,qnn1};
        }
        else{
            data=new String[]{"1",couu1,stt1,add12,add13,mdd1,qnn1};
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
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor box1 =sharedPreferences.edit();


        box1.putString(St1,selecttime1.getText().toString());
        box1.putString(Md1,medname1.getText().toString());
        box1.putString(Qn1,quanname1.getText().toString());
        box1.putString(Add12,addtime12.getText().toString());
        box1.putString(Add13,addtime13.getText().toString());
        box1.putString(Cou1,course1.getText().toString());
        savedata1.setText("Connect");




        box1.apply();
        makeText(this, "Data Saved To EMB App", LENGTH_LONG).show();


    }
    public  void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        sdd1= sharedPreferences.getString(Sd1,"");
        stt1= sharedPreferences.getString(St1,"");
        mdd1= sharedPreferences.getString(Md1,"");
        qnn1= sharedPreferences.getString(Qn1,"");
        add13= sharedPreferences.getString(Add13,"");
        add12= sharedPreferences.getString(Add12,"");
        couu1= sharedPreferences.getString(Cou1,"");}

    public void updateViews(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        selecttime1.setText(stt1);
        medname1.setText(mdd1);
        quanname1.setText(qnn1);
        if(TextUtils.isEmpty(add12)){
            addtime12.setVisibility(View.GONE);
        }else{
        addtime12.setText(add12);}
        if(TextUtils.isEmpty(add13)){
            addtime13.setVisibility(View.GONE);
        }else{
        addtime13.setText(add13);}
        course1.setText(couu1);
    }
    public void receiveadd(){
        SharedPreferences result = getSharedPreferences("sharedprefs", MODE_PRIVATE);
        addd=result.getString("add","");
        showadd.setText(addd);

    }

    public  void showanimation(){
        my.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                my.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                my.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                my.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                my.setVisibility(View.INVISIBLE);
            }


        });


    }





    }







