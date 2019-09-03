package com.example.lesson3_customed_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] cityNames = {"Ramat Gan", "Tel Aviv", "Hertselia", "Ramat HaSharon",
            "Kfar Saba", "Ashdod", "Ashkelon", "Hadera", "Gedera", "Eilat", "Jerusalem", "Yaffo",
            "Tveria", "Haifa", "Rishon", "Natanya"};
    private int[] cityImages = {
            R.drawable.ashkelon ,
            R.drawable.natanya,
            R.drawable.ramatgan,
            R.drawable.telaviv};
    private List<City> cities;


    private ListView lstCities;
    private CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cities = new ArrayList<>();
        for (int i = 0; i < cityNames.length; i++) {
            City city = new City(cityNames[i], cityImages[i%cityImages.length]);
            cities.add(city);
        }
        lstCities = findViewById(R.id.lstCities);
        adapter = new CityAdapter(this, cities);
        lstCities.setAdapter(adapter);
        lstCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "you clicked on: " + cityNames[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
