package com.teamup.rohitasawa_library;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;

public class RohitInternetCheck {

    public static void checkInternet(Context context) {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {


        } else {
            connected = false;
            Commons.context = context;
            ((AppCompatActivity) context).finish();
            context.startActivity(new Intent(context, NoInternetConnection.class));

        }
    }
}
