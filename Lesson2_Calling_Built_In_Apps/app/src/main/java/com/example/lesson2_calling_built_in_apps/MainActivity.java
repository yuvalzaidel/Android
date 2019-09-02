package com.example.lesson2_calling_built_in_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Calling Maps:
        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:32.084769, 34.800973"));*/


        //Calling Google Play:
        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.waze&hl=iw"));*/


        //Sending an email
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"you@gmail.com", "me@gmail.com"};
        String[] cc = {"they@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_CC, cc);
        intent.putExtra(Intent.EXTRA_SUBJECT, "the subject");
        intent.putExtra(Intent.EXTRA_TEXT, "this is the message");
        intent.setType("message/rfc822");
        startActivity(intent);

        startActivity(intent);

    }
}
