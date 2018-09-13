package com.example.aliang.sendsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view)
    {
        SmsManager smsManager = SmsManager.getDefault();

        int per = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (per != PackageManager.PERMISSION_GRANTED)
        {
            String[] permissions = {Manifest.permission.SEND_SMS};

            ActivityCompat.requestPermissions(this, permissions, 33 );
        }


        smsManager.sendTextMessage("9498562673", null, "just a test", null, null);
    }
}
