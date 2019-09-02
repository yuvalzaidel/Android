package com.example.lesson2_broadcast_receivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String MY_ACTION = "MY_ACTION";
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter(MY_ACTION);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //unregisterReceiver(broadcastReceiver);
    }

    public void btnSendBroadcast(View view) {
        Intent intent = new Intent(MY_ACTION);
        int x = 8;
        intent.putExtra("x", x);
        sendBroadcast(intent);
    }
}
