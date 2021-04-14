package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AppSyncInitialize {


    public static void init(final Context context) {

        AppSyncDirectResponseListen as = new AppSyncDirectResponseListen(context);
        as.getResponseFromUrl(new AppSyncDirectResponseListen.ResponseListener() {
            @Override
            public void responser(String response, String datakey) {

                if (datakey.equalsIgnoreCase("Fuck")) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        if (jsonArray.length() > 0) {
                            JSONObject obj = jsonArray.getJSONObject(0);
                            int status = obj.getInt("status");

                            Log.e("Hulk40", status + " is the status");

                            if (status == 1) {
                                cctoast.intialized = true;
                            } else {
                                ((Activity) context).finishAffinity();
                            }

                        } else {
                            ((Activity) context).finishAffinity();
                        }
                    } catch (JSONException e) {
                        cctoast.intialized = false;
                        AppSyncToast.showToast(context, "Exception : Internet A.S.");
                        e.printStackTrace();
                    }
                }
            }
        });
        as.getResponseFromUrlMethod("http://novoagri.in/Other/Forms_mySql/api_apps.php?pkg=" + context.getPackageName(), "Fuck");

        Log.e("Hulk60", "http://novoagri.in/Other/Forms_mySql/api_apps.php?pkg=" + context.getPackageName());
    }
}
