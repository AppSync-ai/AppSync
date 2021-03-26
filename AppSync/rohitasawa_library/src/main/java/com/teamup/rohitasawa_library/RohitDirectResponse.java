package com.teamup.rohitasawa_library;

import android.content.Context;
import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RohitDirectResponse {
    public static String getResponse(String stringUrl) {
        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            StringBuilder response = new StringBuilder();

            URL url = new URL(stringUrl);
            HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
            if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()), 8192);
                String strLine = null;
                while ((strLine = input.readLine()) != null) {
                    response.append(strLine);
                }
                input.close();
            }

            return response.toString();
        } catch (Exception v) {

        }

        return "null";
    }
}
