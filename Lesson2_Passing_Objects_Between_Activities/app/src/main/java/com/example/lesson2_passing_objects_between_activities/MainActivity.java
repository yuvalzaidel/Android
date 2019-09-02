package com.example.lesson2_passing_objects_between_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String DOG = "dog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dog d = new Dog("Buldog", 5);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(DOG, d);
        startActivity(intent);
    }
}
