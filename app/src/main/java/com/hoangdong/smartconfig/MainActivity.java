package com.hoangdong.smartconfig;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.espressif.iot.esptouch.EsptouchTask;
import com.espressif.iot.esptouch.IEsptouchListener;
import com.espressif.iot.esptouch.IEsptouchResult;
import com.espressif.iot.esptouch.IEsptouchTask;
import com.espressif.iot.esptouch.task.__IEsptouchTask;
import com.espressif.iot.esptouch.util.ByteUtil;
import com.espressif.iot.esptouch.util.EspAES;
import com.espressif.iot.esptouch.util.EspNetUtil;
//import com.espressif.iot_esptouch_demo.R;

import java.lang.ref.WeakReference;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    // Global Variable
    EditText editName, editPassword;
    TextView result;
    Button   buttonSend;
    WifiInfo info;
    String   ssid, bssid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link variables and view in xml
        editName     = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonSend   = (Button)   findViewById(R.id.buttonSend);
        result       = (TextView) findViewById(R.id.result);

        // Get Wifi Information
        wifiInformation();
        // Send button
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get Text from editName-SSID
                String name = editName.getText().toString();
                int nameLength = name.length();
                //get Text from editPassword
                String pass = editPassword.getText().toString();
                int passLength = pass.length();
                //Show result

                result.setText("Name:\t" + nameLength + "\nPass:\t" + passLength);
                // TEST
                Log.d("HoangDong","Dong");

                // Prepare to send out

                // byte[] deviceCount = mDeviceCountET.getText().toString().getBytes();





                //

            }
        });



    }






    public void wifiInformation () {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        ssid = wifiInfo.getSSID();
        if(ssid.startsWith("\"") && ssid.endsWith("\"")){
            ssid = ssid.substring(1,ssid.length()-1);
        }
        bssid = wifiInfo.getBSSID();
        //Enter Wifi name
        editName.setText(ssid);

        result.setText(ssid + "\t" + bssid);

    }





}
