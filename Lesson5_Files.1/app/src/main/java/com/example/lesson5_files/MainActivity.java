package com.example.lesson5_files;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String URL_TO_PIZZA = "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe/recipe-image/2018/04/marghuerita.jpg?itok=t6YT57oR";


    private Button btnSave;
    private ImageView imgPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        imgPizza = findViewById(R.id.imgPizza);
    }


    private boolean writeSomethingToFile(){
        File file = new File(getFilesDir(), "myfile.txt");
        Log.d("elad", "path: " + file.getAbsolutePath());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            String s = "some content";
            outputStream.write(s.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


    private String readSomethingFromFile(){
        File file = new File(getFilesDir(), "myfile.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[256];
            int actuallyRead = inputStream.read(buffer);
            if(actuallyRead != -1){
                return new String(buffer, 0, actuallyRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    private static boolean downloadImageFromUrl(File destination){

        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(destination);
            Utils.sendHttpGetRequest(URL_TO_PIZZA, outputStream);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public void btnSaveToFile(View view) {
        btnSave.setEnabled(false);
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected Boolean doInBackground(Void... voids) {
                return writeSomethingToFile();
            }

            @Override
            protected void onPostExecute(Boolean success) {
                btnSave.setEnabled(true);
                Toast.makeText(MainActivity.this, success ? "success" : "failure",
                        Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public void btnLoadFromFile(View view) {
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                return readSomethingFromFile();
            }

            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(MainActivity.this, "content: " + s, Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public void btnLoadImage(View view) {
        new AsyncTask<Void, Void, Bitmap>(){
            @Override
            protected Bitmap doInBackground(Void... voids) {
                File file = new File(getFilesDir(), "pizza.jpg");
                if(downloadImageFromUrl(file)){
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    return bitmap;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if(bitmap != null) {
                    imgPizza.setImageBitmap(bitmap);
                }else{
                    Toast.makeText(MainActivity.this, "error!", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
}
