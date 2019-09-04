package com.example.lesson4_http_request;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btnGetMyIp;
    private TextView lblMyIp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetMyIp = findViewById(R.id.btnGetMyIp);
        lblMyIp = findViewById(R.id.lblMyIp);
    }

    public void btnGetMyIp(View view) {
        btnGetMyIp.setEnabled(false);
        lblMyIp.setText("please wait...");
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                String response = Utils.sendHttpGetRequest("https://httpbin.org/ip");
                if(response == null)
                    return null;
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    return jsonObject.getString("origin");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String origin) {
                btnGetMyIp.setEnabled(true);
                lblMyIp.setText(origin == null ? "error" : origin);
            }
        }.execute();
    }
}
