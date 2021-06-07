package com.teamup.app_sync;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AppSyncDirectResponseListen {

    public static ResponseListener listener;
    public Context contextThis;
    public String datakeyIs = "";


    public interface ResponseListener {
        public void responser(String response, String datakey);
    }

    public AppSyncDirectResponseListen(Context context) {
        this.listener = null;
        contextThis = context;
    }

    public void getResponseFromUrl(ResponseListener listener) {
        this.listener = listener;
    }

    public void getResponseFromUrlMethod(String url, String datakey) {
        datakeyIs = datakey;
        new getResponse().execute("" + url);
    }

    public class getResponse extends AsyncTask<String, String, String> {


        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                java.net.URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(50);
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

            if (cctoast.intializedMethod) {
                try {


                    listener.responser(result, datakeyIs);
                    if (!cctoast.intialized) {
                        Log.e("A.S.", "ExceptionParsing: app is not in sync of gradle");
                    }


                } catch (Exception c) {

//                Admin.fetchListen2.setValue("" + RohitRandomNumber.generateRandomNumber(5));

                }
            }
        }
    }


}
