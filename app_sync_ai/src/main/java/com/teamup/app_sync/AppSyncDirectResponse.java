package com.teamup.app_sync;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppSyncDirectResponse {
    public static String getResponse(String stringUrl) {
        if (cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ) {
            try {
                StringBuilder ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffferer;

                StrictMode.ThreadPolicy dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddwewewee = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddwewewee);
                ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffferer = new StringBuilder();
                if (cccccccccccctoast.YjRvUkRLTXIAIQlRzFTFeiGlzGFBxVUrLEpWaShBzWGTMNLRcZsVevOnkanWNZvYVbpZWBnNaGAmyBwcGwBKpArscnSQfNlWZoLd) {
                } else {
                    return "null";
                }

                URL kmdslmmmmmmmmmmmmmmmmmmmffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff = new URL(stringUrl);
                HttpURLConnection kkkkkkkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaaaawjwjjwjw = (HttpURLConnection) kmdslmmmmmmmmmmmmmmmmmmmffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff.openConnection();
                kkkkkkkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaaaawjwjjwjw.setConnectTimeout(5000);
                if (kkkkkkkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaaaawjwjjwjw.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjnwqeqeqeqeeqe = new BufferedReader(new InputStreamReader(kkkkkkkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaaaawjwjjwjw.getInputStream()), 8192);
                    String ldsdddddddddddddddddddddweeeeeeeeeeeeeeeeeeeeeeee = null;
                    while ((ldsdddddddddddddddddddddweeeeeeeeeeeeeeeeeeeeeeee = jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjnwqeqeqeqeeqe.readLine()) != null) {
                        ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffferer.append(ldsdddddddddddddddddddddweeeeeeeeeeeeeeeeeeeeeeee);
                    }
                    jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjnwqeqeqeqeeqe.close();
                }

                return ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffferer.toString();
            } catch (Exception ffffffffffffffffffffffffffferr444444444444444444444444444444444444444444444444444444444444) {

                Log.wtf("Hulk-37", ffffffffffffffffffffffffffferr444444444444444444444444444444444444444444444444444444444444.getMessage());
            }
        }
        return "null";
    }
}
