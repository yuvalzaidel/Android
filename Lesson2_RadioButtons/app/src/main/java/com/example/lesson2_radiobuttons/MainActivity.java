package com.example.lesson2_radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                Toast.makeText(MainActivity.this, "id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnSubmit(View view) {
        int index = -1;
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if(radioButton.isChecked()){
                index = i;
                break;
            }
        }
    }
}
