package com.example.lesson3_intercepting_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = null;
        String str = "message from ";
        Object[] pdus = (Object[])bundle.get("pdus");
        messages = new SmsMessage[pdus.length];
        for (int i = 0; i < pdus.length; i++) {
            messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
            if(i==0)
                str += messages[i].getOriginatingAddress() + ": ";
            str += messages[i].getMessageBody();
        }
        Log.d("elad", str);
    }
}
