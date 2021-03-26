package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class NoInternetConnection extends AppCompatActivity {

    TextView refreshTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet_connection);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }

        refreshTxt = findViewById(R.id.refreshTxt);

        refreshTxt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                boolean connected = false;
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), Commons.context.getClass()));

                } else {
                    connected = false;

                    AppSyncToast.showToast(getApplicationContext(),"No Internet connection!!");
                }

            }
        });
    }
}
