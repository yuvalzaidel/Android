package com.example.lesson2_broadcast_receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    int x = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        //int x = intent.getIntExtra("x", -1);
        x++;
        Toast.makeText(context, "received broadcast " + x, Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
