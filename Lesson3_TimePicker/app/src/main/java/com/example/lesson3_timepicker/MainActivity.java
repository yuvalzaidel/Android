package com.example.lesson3_timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
    }

    public void btnClick(View view) {
        int h = timePicker.getHour();
        int m = timePicker.getMinute();
        String time = (h < 10 ? "0" : "") + h + ":" + (m < 10 ? "0" : "") + m;
        Toast.makeText(this, "time: " + time, Toast.LENGTH_SHORT).show();
    }
}
