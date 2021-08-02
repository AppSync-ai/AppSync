package com.teamup.app_sync.Scrapping;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity;
import com.teamup.app_sync.AppSyncPleaseWait;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Reqs.SyncStatesReq;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AppSyncScrapQuotes {


    static Context contextThis = null;

    public static void getRanomQuote(Context context) {
        contextThis = context;
        new QuoteParser().execute();
    }

    static class QuoteParser extends AsyncTask<String, String, String> {

//    load states all with their links href

        @Override
        protected String doInBackground(String... params) {

//            String url = params[0];

            final Document pageDocument;

            try {
//            call url here

                pageDocument = Jsoup.connect("https://www.generatormix.com/random-inspirational-quotes")
                        .timeout(15000)
                        .userAgent("Mozilla")
                        .get();

                final Element quoteTxtElement = pageDocument.getElementsByClass("text-left").first();

//                Log.wtf("Hulk-54", pageDocument.getAllElements() + "");

                if (quoteTxtElement != null) {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            Quotes quotes = (Quotes) contextThis;
                            quotes.gotRandomQuote(quoteTxtElement.text(), "");


                        }
                    });
                } else {
                    Log.wtf("Hulk-78", "null jsoup Element");
                }
//            Load state data here

            } catch (Exception v) {
                Log.wtf("Hulk-err-62", v.getMessage());
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

    public interface Quotes {
        public void gotRandomQuote(String quote, String quoteBy);
    }
}
