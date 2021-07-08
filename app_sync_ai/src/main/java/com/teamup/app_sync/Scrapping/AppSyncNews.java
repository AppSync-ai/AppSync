package com.teamup.app_sync.Scrapping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.teamup.app_sync.AppSyncPleaseWait;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Reqs.SyncNewsReq;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class AppSyncNews {

    static Context contextThis = null;
    static ArrayList<SyncNewsReq> list = new ArrayList<>();

    public static void getAllNews(Context context) {

        contextThis = context;
        new NewsParser().execute();
    }

    static class NewsParser extends AsyncTask<String, String, String> {

//    load states all with their links href

        @Override
        protected String doInBackground(String... params) {

//            String url = params[0];

            final Document pageDocument;

            try {
//            call url here
                list.clear();

                pageDocument = Jsoup.connect("https://economictimes.indiatimes.com/topic/rates")
                        .timeout(15000)
                        .get();

                int i = 0;
                do {
                    try {

                        final Element quoteTxtElement = pageDocument.select("ul.data").select("li").select("div").get(i);

                        final int finalI = i;
                        ((Activity) contextThis).runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
//                                Log.wtf("Hulk-56-news-" + finalI, quoteTxtElement.select("a").select("meta").attr("content") +
//                                        "\n Description : " + quoteTxtElement.select("p").text() +
//                                        "\n Img : " + quoteTxtElement.select("a").select("img").attr("data-original"));

                                list.add(new SyncNewsReq("" + quoteTxtElement.select("a").select("meta").attr("content"),
                                        "" + quoteTxtElement.select("p").text(),
                                        "" + quoteTxtElement.select("time").text(),
                                        quoteTxtElement.select("a").select("img").attr("data-original")
                                ));
                            }
                        });


                        i++;

                    } catch (Exception c) {
                        Log.wtf("Hulk-err-62", c.getMessage());
                        i = -1;
                    }
                } while (i != -1);

                News news = (News) contextThis;
                news.gotNews(list);


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

    public interface News {
        public void gotNews(ArrayList<SyncNewsReq> list);
    }
}
