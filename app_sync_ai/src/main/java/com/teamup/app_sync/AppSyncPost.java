package com.teamup.app_sync;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppSyncPost {
    public static void sendPost(final JSONObject obj, final String urlAdress, final Context context, final String datakey) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlAdress);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    Log.wtf("JSON", obj.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
                    os.writeBytes(obj.toString());

                    os.flush();
                    os.close();

                    Log.wtf("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.wtf("MSG", conn.getResponseMessage());

                    BufferedReader br = null;
                    if (conn.getResponseCode() == 200) {
                        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String strCurrentLine;
                        while ((strCurrentLine = br.readLine()) != null) {

                            try {
                                PostResponse rr = (PostResponse) context;
                                rr.responseInReturn(strCurrentLine, datakey);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
//                            Log.wtf("Hulk-43", strCurrentLine);
                        }
                    } else {
                        br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                        String strCurrentLine;
                        while ((strCurrentLine = br.readLine()) != null) {
                            try {
                                PostResponse rr = (PostResponse) context;
                                rr.responseInReturn(strCurrentLine, datakey);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

//                            Log.wtf("Hulk-49", strCurrentLine);
                        }
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public interface PostResponse {
        public void responseInReturn(String response, String datakey);
    }
}
