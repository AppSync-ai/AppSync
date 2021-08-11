package com.teamup.app_sync;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AppSyncDirectResponseListenOffline {

    public static ResponseListener listener;
    public Context contextThis;
    public String datakeyIs = "";
    static AppSyncStorage appSyncStorage;

    public interface ResponseListener {
        public void responser(String response, String datakey);
    }

    public AppSyncDirectResponseListenOffline(Context context) {
        this.listener = null;
        contextThis = context;
        appSyncStorage = new AppSyncStorage(context);
    }

    public void getResponseFromUrl(ResponseListener listener) {
        this.listener = listener;
    }

    public void getResponseFromUrlMethod(String url, String datakey) {
        datakeyIs = datakey;
        if (AppSyncInternet.isConnectionAvailable(contextThis)) {

            new getResponse().execute("" + url);
        } else {
            listener.responser(appSyncStorage.getString(datakey), datakeyIs);
        }
    }

    public class getResponse extends AsyncTask<String, String, String> {


        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
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

                listener.responser(result, datakeyIs);
                appSyncStorage.putString(datakeyIs, result);


            } catch (Exception c) {


            }
        }
    }


}
