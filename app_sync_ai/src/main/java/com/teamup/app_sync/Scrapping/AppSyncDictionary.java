package com.teamup.app_sync.Scrapping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.teamup.app_sync.AppSyncPleaseWait;
import com.teamup.app_sync.Reqs.SyncNewsReq;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AppSyncDictionary {
    static Context contextThis = null;
    static String meaning_of = "";

    public static void get_meaning(Context context, String meaning_of_text) {

        contextThis = context;
        meaning_of = meaning_of_text;
        new MeaningParser().execute();
    }

    static class MeaningParser extends AsyncTask<String, String, String> {

//    load states all with their links href

        @Override
        protected String doInBackground(String... params) {

//            String url = params[0];

            final Document pageDocument;

            try {
//            call url here

                pageDocument = Jsoup.connect("https://www.vocabulary.com/dictionary/" + meaning_of)
                        .timeout(15000)
                        .get();

                final Element elem = pageDocument.getElementsByClass("short").first();
                final Element long_elem = pageDocument.getElementsByClass("long").first();
                final Element definations_elem = pageDocument.getElementsByClass("definition").first();

                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        DictionaryCode dc = (DictionaryCode) contextThis;
                        if (elem != null) {
                            dc.short_meaning(elem.text());
                        }

                        if (long_elem != null) {
                            dc.long_meaning(long_elem.text());
                        }

                        try {
                            if (definations_elem != null) {
                                if (definations_elem.child(0) != null) {
                                    dc.defenation_meaning(definations_elem.child(0).text(), definations_elem.ownText());
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (elem == null && long_elem == null) {
                                dc.error_loading();
                            }
                        }

                        if (elem == null && long_elem == null) {
                            dc.error_loading();
                        }
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

    public interface DictionaryCode {
        public void short_meaning(String result);

        public void long_meaning(String result);


        public void defenation_meaning(String defination_type, String result);

        public void error_loading();

    }

    public static String endoOfHtml = "</body>\n" +
            "\n" +
            "</html>";

    public static String startOfHtml = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<body>\n";


}
