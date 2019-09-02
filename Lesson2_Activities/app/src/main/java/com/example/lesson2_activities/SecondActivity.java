package com.example.lesson2_activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String goTo = (String)getIntent().getStringExtra(MainActivity.GO_TO);
        goTo(goTo);
    }

    private void goTo(String goTo){
        switch (goTo){
            case "1":
                finish();
                break;
            case "2":

                break;
            case "3":
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String goTo = data.getStringExtra(MainActivity.GO_TO);
            goTo(goTo);
        }
    }

    public void buttonClicked(View view) {
        String goTo = (String)view.getTag();
        goTo(goTo);
    }
}
