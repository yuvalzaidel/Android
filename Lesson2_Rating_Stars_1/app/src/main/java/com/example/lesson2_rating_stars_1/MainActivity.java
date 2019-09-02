package com.example.lesson2_rating_stars_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewGroup mainLayout;
    private CheckBox[] chkStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLayout);
        chkStars = new CheckBox[5];
        for (int i = 1; i <= 5; i++) {
            CheckBox chkStar = mainLayout.findViewWithTag(String.valueOf(i));
            chkStar.setOnClickListener(starListener);
            chkStars[i-1] = chkStar;
        }

    }

    private View.OnClickListener starListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int tag = Integer.valueOf((String)view.getTag());
            for (int i = 1; i <= 5; i++) {
                //CheckBox chkStar = mainLayout.findViewWithTag(String.valueOf(i));
                chkStars[i-1].setChecked(i <= tag);
            }
        }
    };
}
