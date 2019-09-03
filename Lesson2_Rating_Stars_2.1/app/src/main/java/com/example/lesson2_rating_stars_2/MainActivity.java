package com.example.lesson2_rating_stars_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLayout);

        RatingView ratingView = new RatingView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mainLayout.addView(ratingView, layoutParams);
        ratingView.setOnRatingChangedListener(new RatingView.OnRatingChangedListener() {
            @Override
            public void onRatingChanged(RatingView ratingView) {
                Toast.makeText(MainActivity.this, "changed to: " + ratingView.getValue(), Toast.LENGTH_SHORT).show();
            }
        });


        /*LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.HORIZONTAL);
        TextView textView = new TextView(this);
        textView.setText("created in the Java code");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layout1.addView(textView, layoutParams);

        */

        /*LinearLayout layout1 = (LinearLayout) getLayoutInflater().inflate(R.layout.layout1, mainLayout, false);

        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        mainLayout.addView(layout1, layoutParams1);*/
    }
}
