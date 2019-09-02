package com.example.lesson2_passing_objects_between_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Dog d = (Dog)getIntent().getSerializableExtra(MainActivity.DOG);
        Log.d("elad", "dog: " + d);
    }
}
