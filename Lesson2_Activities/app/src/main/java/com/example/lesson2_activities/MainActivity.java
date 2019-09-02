package com.example.lesson2_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String GO_TO = "goTo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(GO_TO, (String)view.getTag());
        startActivity(intent);
    }
}
