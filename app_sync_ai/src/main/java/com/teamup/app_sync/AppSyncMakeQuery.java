package com.teamup.app_sync;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.EntityUtils;

public class AppSyncMakeQuery {

    static String ServerURL1 = "";
    public static MutableLiveData<String> queryResponse = new MutableLiveData<>();

    public static void query(final String query, final Context context) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("query", query));
                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL1);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    httpResponse.setHeader("Content-Type", "text/html; charset=utf-8");

                    HttpEntity httpEntity = httpResponse.getEntity();

                    return EntityUtils.toString(httpEntity);

                } catch (ClientProtocolException e) {
                    Log.wtf("Hulk-AppSync-47", e.getMessage());
                } catch (IOException e) {
                    Log.wtf("Hulk-AppSync-49", e.getMessage());
                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                try {
                    queryResponse.setValue("" + result);
                    QueryResponse qr = (QueryResponse) context;
                    qr.gotResult(result);

                } catch (Exception v) {

                }

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(query);
    }

    public interface QueryResponse {
        public void gotResult(String reult);
    }

    public static void setServerUrl(String full_server_url) {
        ServerURL1 = full_server_url;
    }
}
