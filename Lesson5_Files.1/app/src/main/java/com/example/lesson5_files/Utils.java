package com.example.lesson5_files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {


    public static void sendHttpGetRequest(String spec, OutputStream outputStream) throws IOException{
        URL url = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            url = new URL(spec);
            connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(false);
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.connect();
            inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, actuallyRead);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

    }
}
