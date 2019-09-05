package com.example.lesson5_services;


import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private boolean go = true;
    private Thread thread;
    private int counter = 0;
    private IBinder binder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String key = intent.getStringExtra("key");
        Log.d("elad", "in onStartCommand() " + key);
        if(thread == null){
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (go){
                        Log.d("elad", "counter = " + counter++);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("elad", "in onCreate()");
        counter = getSharedPreferences("prefs", MODE_PRIVATE).getInt("counter", 0);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        go = false;
        thread = null;
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        prefs.edit().putInt("counter", counter).commit();
        Log.d("elad", "in onDestroy()");
    }
}
