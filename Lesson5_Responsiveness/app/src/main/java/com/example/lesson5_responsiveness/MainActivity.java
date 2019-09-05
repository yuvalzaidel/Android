package com.example.lesson5_responsiveness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String COUNTER = "counter";
    private int counter;
    private TextView lblCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER, 0);
        }

        lblCounter = findViewById(R.id.lblCounter);
        updateLabel();
    }

    private void updateLabel(){
        lblCounter.setText(String.valueOf(counter));
    }

    public void btnIncrement(View view) {
        counter++;
        updateLabel();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("elad", "in onSaveInstanceState()");
        outState.putInt(COUNTER, counter);
        super.onSaveInstanceState(outState);
    }
}
