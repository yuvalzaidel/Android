package com.example.lesson4_dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NameDialogFragment.NameDialogFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShowFragment(View view) {
        NameDialogFragment nameDialogFragment = new NameDialogFragment();
        nameDialogFragment.setListener(this);
        nameDialogFragment.show(getSupportFragmentManager(), "");
    }

    @Override
    public void onComplete(String firstName, String lastName) {
        Toast.makeText(this, "your name: " + firstName + " " + lastName,
                Toast.LENGTH_SHORT).show();
    }
}
