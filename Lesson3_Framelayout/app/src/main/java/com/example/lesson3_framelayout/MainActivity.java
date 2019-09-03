package com.example.lesson3_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        current = 1;
    }

    public void btnNext(View view) {
        frameLayout.findViewWithTag(String.valueOf(current)).setVisibility(View.INVISIBLE);
        current = (current % 3) + 1;
        frameLayout.findViewWithTag(String.valueOf(current)).setVisibility(View.VISIBLE);
    }
}
