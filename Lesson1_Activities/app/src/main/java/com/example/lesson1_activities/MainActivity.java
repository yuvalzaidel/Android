package com.example.lesson1_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String X = "x";
    public static final String S = "s";
    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = 5;
        String s = "hello";
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(X, x);
        bundle.putString(S, s);
        intent.putExtras(bundle);
        //intent.putExtra(X, x);
        //intent.putExtra(S, s);
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            int z = data.getIntExtra(SecondActivity.Z, -1);
            Toast.makeText(this, "z: " + z, Toast.LENGTH_SHORT).show();

        }
    }
}
