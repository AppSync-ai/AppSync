package com.teamup.app_sync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AppSyncPinSecurity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppSyncChangeNavigationColor.change(this);
        setContentView(R.layout.activity_app_sync_pin_security);
    }
}