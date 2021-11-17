package com.example.embapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class Main3Activity extends AppCompatActivity {
    Button scanButton,bton,btoff,pairedbtn,adddata;
    ListView scanListView,pairedlistview;
    ArrayList<String> stringArrayList=new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    BluetoothDevice[] btArray;


    private Set<BluetoothDevice> pairedDevices;
    BluetoothAdapter myAdapter=BluetoothAdapter.getDefaultAdapter();
    private static final String EXTRA_ADDRESS="devices_address";
    private static final UUID MY_UUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private boolean isBtConnected = false;
    BluetoothSocket btSocket = null;
    public ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        scanButton=(Button) findViewById(R.id.scanButton);
        scanListView=(ListView) findViewById(R.id.scannedListView);
        bton=findViewById(R.id.btnon);
        btoff=findViewById(R.id.btnoff);
        pairedlistview=findViewById(R.id.pairedlist);
        pairedbtn=findViewById(R.id.btndevice);
        adddata=findViewById(R.id.add);


        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main3Activity.this, navigationnew.class);
                startActivity(intent);
            }
        });

        pairedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<BluetoothDevice> bt=myAdapter.getBondedDevices();
                String[] strings=new String[bt.size()];
                btArray=new BluetoothDevice[bt.size()];
                int index=0;

                if( bt.size()>0)
                {
                    for(BluetoothDevice device : bt)
                    {
                        btArray[index]= device;
                        strings[index]=device.getName() +"\n"+ device.getAddress();
                        index++;
                    }
                    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strings);
                    pairedlistview.setAdapter(arrayAdapter);
                }
            }
        });




        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!myAdapter.isEnabled()) {
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);
                    Toast.makeText(getApplicationContext(), "Turned on",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
                }

            }
        });
        btoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.disable();
                Toast.makeText(getApplicationContext(), "Turned off" ,Toast.LENGTH_LONG).show();
            }
        });



        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(Main3Activity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},1001);
                myAdapter.startDiscovery();
                Toast.makeText(getApplicationContext(),"Searching For Nearby Devices",Toast.LENGTH_SHORT).show();
            }
        });
        pairedlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
                ConnectThread connectThread=new ConnectThread();
                connectThread.start();
            }
        });




        IntentFilter intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(myReceiver,intentFilter);

        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringArrayList);
        scanListView.setAdapter(arrayAdapter);




    }

    BroadcastReceiver myReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action))
            {
                BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                stringArrayList.add(device.getName()+"\n"+device.getAddress());
                arrayAdapter.notifyDataSetChanged();
            }
        }
    };
    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        public ConnectThread() {
            // Use a temporary object that is later assigned to mmSocket
            // because mmSocket is final.
            BluetoothSocket tmp = null;
            BluetoothDevice device=myAdapter.getRemoteDevice("AB:19:09:00:3E:13");
            mmDevice = device;

            try {
                // Get a BluetoothSocket to connect with the given BluetoothDevice.
                // MY_UUID is the app's UUID string, also used in the server code.
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                System.out.println("Socket Method Failed");
            }
            mmSocket = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            myAdapter.cancelDiscovery();

            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocket.connect();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket.close();
                } catch (IOException closeException) {
                    System.out.println("could not close the client socket");
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.

        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                System.out.println("Could NOT CLOSE THE CLIENT SOCKET");
            }
        }
    }

}


