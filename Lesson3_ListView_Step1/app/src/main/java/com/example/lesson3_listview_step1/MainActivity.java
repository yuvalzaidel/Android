package com.example.lesson3_listview_step1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] cityNames = {"Ramat Gan", "Tel Aviv", "Hertselia", "Ramat HaSharon",
        "Kfar Saba", "Ashdod", "Ashkelon", "Hadera", "Gedera", "Eilat", "Jerusalem", "Yaffo",
        "Tveria", "Haifa", "Rishon", "Natanya"};

    private LinearLayout layoutCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutCities = findViewById(R.id.layoutCities);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);
        for (int i = 0; i < cityNames.length; i++) {
            TextView lblCity = new TextView(this);
            lblCity.setText(cityNames[i]);
            lblCity.setTextSize(30);
            lblCity.setTag(i);
            lblCity.setOnClickListener(cityClickListener);
            layoutCities.addView(lblCity, layoutParams);
        }
    }

    private View.OnClickListener cityClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int i = (Integer)view.getTag();
            Toast.makeText(MainActivity.this, "you clicked on " + cityNames[i], Toast.LENGTH_SHORT).show();
        }
    };
}
