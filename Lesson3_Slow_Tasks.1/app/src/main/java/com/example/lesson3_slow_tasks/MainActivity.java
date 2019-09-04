package com.example.lesson3_slow_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMessage = findViewById(R.id.lblMessage);
    }

    public void btnClick(View view) {
        lblMessage.setText("please wait...");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                slowRunnigTask();
            }
        });
        thread.start();
    }


    private void slowRunnigTask(){
        int x = 3;

        for (int i = 0; i < 10000; i++) {
            if(x > i)
                x--;
            for (int j = 0; j < 100000; j++) {
                if(x % 3 == 2)
                    x++;
            }
        }
        Log.d("elad", "done " + x);
    }
}
