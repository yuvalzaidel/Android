package com.example.lesson4_dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NameDialogFragment.NameDialogFragmentListener, YesNoDialogFragment.YesNoDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShowFragment(View view) {
        /*NameDialogFragment nameDialogFragment = new NameDialogFragment();
        nameDialogFragment.setListener(this);
        nameDialogFragment.show(getSupportFragmentManager(), "");*/

        YesNoDialogFragment yesNoDialogFragment = new YesNoDialogFragment();
        yesNoDialogFragment.setQuestion("delete file");
        yesNoDialogFragment.setListener(this);
        yesNoDialogFragment.setCancelable(false);
        yesNoDialogFragment.show(getSupportFragmentManager() ,"");

    }

    @Override
    public void onComplete(String firstName, String lastName) {
        Toast.makeText(this, "your name: " + firstName + " " + lastName,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDecision(boolean yes) {
        Toast.makeText(this, (yes ? "yes" : "no"), Toast.LENGTH_SHORT).show();
    }
}
