package com.teamup.app_sync.Scrapping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.teamup.app_sync.AppSyncPleaseWait;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class AppSyncImagesFromWord {
    static Context contextThis = null;
    static String word_of_image = "";
    static ArrayList<String> list = new ArrayList<>();

    public static void get_images_of_word(Context context, String word_of) {

        contextThis = context;
        word_of_image = word_of;
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

                pageDocument = Jsoup.connect("https://www.shutterstock.com/search/" + word_of_image)
                        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                        .timeout(15000)
                        .get();


                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        int i = 0;
                        do {
                            try {
                                final Element elem = pageDocument.getElementsByClass("z_h_9d80b z_h_2f2f0").get(i);
                                Log.wtf("Hulk-53", elem.getAllElements().attr("src"));

                                ((Activity) contextThis).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        list.add(elem.getAllElements().attr("src"));
                                    }
                                });
                                i = i + 1;
                            } catch (Exception e) {
                                i = -1;
//                                Log.wtf("Hulk-err-56", e.getMessage());
                            }

                        } while (i != -1);

//                        Log.wtf("Hulk-i_value", i + "");

                        Translate tt = (Translate) contextThis;
                        tt.translated(list);

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

    public interface Translate {


        public void error_loading();

        public void translated(ArrayList<String> list_of_urls);

    }


}
