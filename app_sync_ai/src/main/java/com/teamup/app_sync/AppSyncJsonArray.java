package com.teamup.app_sync;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AppSyncJsonArray {

    public static JSONArray jsonArray;
    public static Context context;
    public static String dataKey = "public";

    public static void setContext(Context contextOfActivity) {
        context = contextOfActivity;
    }

    public static void setDataFor(String dataFor) {
        dataKey = dataFor;
    }

    public static class getResponse extends AsyncTask<String, String, String> {


        protected void onPreExecute() {
            super.onPreExecute();
            jsonArray = new JSONArray();

        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                java.net.URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                jsonArray = new JSONArray(result);
                JsonResponded green = (JsonResponded) context;
                green.gotResponse(jsonArray, dataKey);


            } catch (Exception c) {

//                Admin.fetchListen2.setValue("" + RohitRandomNumber.generateRandomNumber(5));

            }
        }
    }

    public interface JsonResponded {
        public void gotResponse(JSONArray response, String dataKey);

    }

}
