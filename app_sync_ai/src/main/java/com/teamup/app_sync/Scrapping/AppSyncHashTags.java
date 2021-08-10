package com.teamup.app_sync.Scrapping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.teamup.app_sync.AppSyncPleaseWait;
import com.teamup.app_sync.AppSyncRandomNumber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class AppSyncHashTags {
    static Context contextThis = null;
    static String start_from = "301";
    static ArrayList<String> list = new ArrayList<>();

    public static void get_all_hashtags(Context context) {

        contextThis = context;
        new TranslateParser().execute();
    }

    static class TranslateParser extends AsyncTask<String, String, String> {

//    load states all with their links href

        @Override
        protected String doInBackground(String... params) {

//            String url = params[0];

            final Document pageDocument;

            try {
//            call url here

                list.clear();
                start_from = AppSyncRandomNumber.generateRandomNumber(2) + "01";

                Log.wtf("Hulk-rand", start_from);

                pageDocument = Jsoup.connect("https://top-hashtags.com/instagram/" + start_from)
                        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                        .timeout(15000)
                        .get();


                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        int i = 0;
                        do {
                            try {
                                final Element elem = pageDocument.getElementsByClass("i-row").get(i);
//                                Log.wtf("Hulk-53", elem.getElementsByClass("i-tag").text());

                                ((Activity) contextThis).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        list.add(elem.getElementsByClass("i-tag").text());
                                    }
                                });
                                i = i + 1;
                            } catch (Exception e) {
                                i = -1;
                            }

                        } while (i != -1);


                        Hashtags tt = (Hashtags) contextThis;
                        tt.loaded_hashtags(list);

                    }
                });


//            Load state data here

            } catch (Exception v) {
                Log.wtf("Hulk-err-50", v.getMessage());
            }

            return null;
        }

        @SuppressLint("RestrictedApi")
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ((Activity) contextThis).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AppSyncPleaseWait.stopDialog(contextThis);
                }
            });


        }
    }

    public interface Hashtags {


        public void error_loading();

        public void loaded_hashtags(ArrayList<String> list_of_hashtags);

    }


}
