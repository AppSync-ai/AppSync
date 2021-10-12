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

public class AppSyncDirectResponseListen {

    public static ResponseListener listener;
    public Context grdrtetrt54;
    public String sedffsdbdgt89 = "";


    public interface ResponseListener {
        public void responser(String response, String datakey);
    }

    public AppSyncDirectResponseListen(Context errrggd334555) {
        this.listener = null;
        grdrtetrt54 = errrggd334555;
    }

    public void getResponseFromUrl(ResponseListener listener) {
        this.listener = listener;
    }

    public void getResponseFromUrlMethod(String url, String dataKey) {
        sedffsdbdgt89 = dataKey;
        new getResponse().execute("" + url);
    }

    public class getResponse extends AsyncTask<String, String, String> {


        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected String doInBackground(String... params) {

            HttpURLConnection rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe = null;
            BufferedReader ereterbtetevt4435353h3r = null;

            try {
                java.net.URL grgrdvtewravrtrt34 = new URL(params[0]);
                rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe = (HttpURLConnection) grgrdvtewravrtrt34.openConnection();
                rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe.setConnectTimeout(5000);
                rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe.connect();

                InputStream werwerwevrwrwerv2342 = rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe.getInputStream();

                ereterbtetevt4435353h3r = new BufferedReader(new InputStreamReader(werwerwevrwrwerv2342));

                StringBuffer ertebterbyummmujyhythythyhyttut = new StringBuffer();
                String yr5ttrnrtynyrtnyrtyrtyrty = "";

                while ((yr5ttrnrtynyrtnyrtyrtyrty = ereterbtetevt4435353h3r.readLine()) != null) {
                    ertebterbyummmujyhythythyhyttut.append(yr5ttrnrtynyrtnyrtyrtyrty + "\n");
                    Log.d("Response: ", "> " + yr5ttrnrtynyrtnyrtyrtyrty);   //here u ll get whole response...... :-)

                }

                return ertebterbyummmujyhythythyhyttut.toString();

            } catch (MalformedURLException tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt556) {
                tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt556.printStackTrace();
            } catch (IOException uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu) {
                uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu.printStackTrace();
            } finally {
                if (rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe != null) {
                    rrrrrrrrrrrrrrrrrrrrrrefsdfsdvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwe.disconnect();
                }
                try {
                    if (ereterbtetevt4435353h3r != null) {
                        ereterbtetevt4435353h3r.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String njjjnjnjhbsdhfgysdftysdfgsdf) {
            super.onPostExecute(njjjnjnjhbsdhfgysdftysdfgsdf);

            if (cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ) {
                try {


                    listener.responser(njjjnjnjhbsdhfgysdftysdfgsdf, sedffsdbdgt89);
                    if (!cccccccccccctoast.YjRvUkRLTXIAIQlRzFTFeiGlzGFBxVUrLEpWaShBzWGTMNLRcZsVevOnkanWNZvYVbpZWBnNaGAmyBwcGwBKpArscnSQfNlWZoLd) {
                        Log.e("A.S.", "ExceptionParsing: app is not in sync of gradle");
                    }


                } catch (Exception c) {

//                Admin.fetchListen2.setValue("" + RohitRandomNumber.generateRandomNumber(5));

                }
            }
        }
    }


}
