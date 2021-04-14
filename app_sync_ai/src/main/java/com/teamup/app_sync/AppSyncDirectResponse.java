package com.teamup.app_sync;

import android.os.StrictMode;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppSyncDirectResponse {
    public static String getResponse(String stringUrl) {
        try {
            StringBuilder response;

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            response = new StringBuilder();
            if (cctoast.intialized) {
            } else {
                return "null";
            }

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
