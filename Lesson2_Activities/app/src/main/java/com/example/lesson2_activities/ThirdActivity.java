package com.example.lesson2_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

    }

    public void buttonClicked(View view) {
        String goTo = (String)view.getTag();
        Intent data = new Intent();
        data.putExtra(MainActivity.GO_TO, goTo);
        setResult(RESULT_OK, data);
        finish();
    }
}
