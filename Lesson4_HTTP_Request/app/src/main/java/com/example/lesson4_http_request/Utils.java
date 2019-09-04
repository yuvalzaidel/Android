package com.example.lesson4_http_request;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {


    public static String sendHttpGetRequest(String spec){
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
            StringBuilder stringBuilder = new StringBuilder();
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(buffer)) != -1){
                String s = new String(buffer, 0, actuallyRead);
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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


        return null;
    }
}
