package com.example.lesson1_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String Z = "z";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String s = getIntent().getStringExtra(MainActivity.S);
        int x = getIntent().getIntExtra(MainActivity.X, -1);

        Toast.makeText(this, "x: " + x + ", s: " + s, Toast.LENGTH_SHORT).show();





        //Intent intent = new Intent("ThirdActivity");
        //startActivity(Intent.createChooser(intent, "please choose..."));
    }

    public void btnGoBack(View view) {

        Intent data = new Intent();
        int z = 18;
        data.putExtra(Z,z);
        setResult(RESULT_OK, data);

        finish();
    }
}
