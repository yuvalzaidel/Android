package com.example.ex1_yuval;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    public static final String X = "x";
    public static final String S = "S";
    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SecondActivity.class);

        int x = 5;
        String s = "hello";

     //   intent.putExtra(X,x);
     //   intent.putExtra(S,s);
     //   startActivity(intent);

        Bundle bundle = new Bundle();
        bundle.putInt(X,x);
        bundle.putString(S,s);
        intent.putExtras(bundle);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            int z = data.getIntExtra(SecondActivity.Z, -1);
            Toast.makeText(this, "z = "+ z, Toast.LENGTH_SHORT).show();
        }
    }
}
