package com.example.lesson4_shared_prefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS = "prefs";
    public static final String TXT = "txt";
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);

        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        String text = prefs.getString(TXT, null);
        if(text != null)
            txt.setText(text);

    }

    public void btnSave(View view) {
        String text = txt.getText().toString();

        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        prefs.edit().putString(TXT, text).commit();


    }
}
