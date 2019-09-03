package com.example.lesson3_telephony;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendingSMSprogramatically();
        //sendSMS();

        //makeCall();
    }

    private void sendSMS(){

        //do not run on the emulator, only on physical device
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("address", "036536746;7678478");
        intent.putExtra("sms_body", "Hi there!");
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }

    private void sendingSMSprogramatically(){
        if(checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.SEND_SMS} ,124);

            return;
        }
        Intent intent = new Intent("my_action");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 125, intent, 0);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("050435676", null, "hi there!", pendingIntent, null);

    }

    private void makeCall() {
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            return;
        }
        String phoneNumber = "03534542";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makeCall();
            }
        }else if(requestCode == 124){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                sendingSMSprogramatically();
        }
    }
}
