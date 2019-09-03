package com.example.lesson3_listview_step2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private String[] cityNames = {"Ramat Gan", "Tel Aviv", "Hertselia", "Ramat HaSharon",
            "Kfar Saba", "Ashdod", "Ashkelon", "Hadera", "Gedera", "Eilat", "Jerusalem", "Yaffo",
            "Tveria", "Haifa", "Rishon", "Natanya"};
    private boolean[] cityChecked;
    private ListView lstCities, lstCities2;
    private ArrayAdapter<String> adapter;
    private Set<String> checkedCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstCities = findViewById(R.id.lstCities);
        lstCities2 = findViewById(R.id.lstCities2);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityNames);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, cityNames);
        lstCities.setAdapter(adapter);
        lstCities2.setAdapter(adapter);
        cityChecked = new boolean[cityNames.length];
        checkedCities = new HashSet<>();
        lstCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this,
                        "you clicked on: " + cityNames[position], Toast.LENGTH_SHORT).show();
                CheckedTextView checkedTextView = (CheckedTextView)view;
                boolean isChecked = checkedTextView.isChecked();
                if(isChecked)
                    checkedCities.add(cityNames[position]);
                else
                    checkedCities.remove(cityNames[position]);
                cityChecked[position] = isChecked;
            }
        });
        lstCities.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public void btnChangeCities(View view) {
        cityNames[cityNames.length-1] += "!";
        adapter.notifyDataSetChanged();
    }
}
