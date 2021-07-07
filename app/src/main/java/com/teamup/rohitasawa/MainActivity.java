package com.teamup.rohitasawa;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.teamup.app_sync.AppSyncAlertWithList;
import com.teamup.app_sync.AppSyncBackPressed;
import com.teamup.app_sync.AppSyncBitmapsTheory;
import com.teamup.app_sync.AppSyncCalendarView;
import com.teamup.app_sync.AppSyncCopyPaste;
import com.teamup.app_sync.AppSyncCurrentDate;
import com.teamup.app_sync.AppSyncCustomNotification;
import com.teamup.app_sync.AppSyncDaysTheory;
import com.teamup.app_sync.AppSyncDirectResponse;
import com.teamup.app_sync.AppSyncEncryptDecrypt;
import com.teamup.app_sync.AppSyncFigerShow;
import com.teamup.app_sync.AppSyncFileManager;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInputDialogs;
import com.teamup.app_sync.AppSyncJsonArray;
import com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity;
import com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity;
import com.teamup.app_sync.AppSyncMobileInfo;
import com.teamup.app_sync.AppSyncNotification;
import com.teamup.app_sync.AppSyncPHPMailer;
import com.teamup.app_sync.AppSyncPermissions;
import com.teamup.app_sync.AppSyncPleaseWait;
import com.teamup.app_sync.AppSyncSaveArrayList;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Reqs.SyncStatesReq;
import com.teamup.app_sync.cctoast;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import static com.teamup.app_sync.AppSyncSaveArrayList.getListToJsonArray;


public class MainActivity extends AppCompatActivity implements AppSyncLoadAllStatesDistTalCity.Loaded {

    Button button, button2;
    TextView txt1, txt2;
    ImageView img;
    RelativeLayout manage_reler;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        AppSyncInitialize.init(MainActivity.this);


        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

        AppSyncPermissions.READ_WRITE_STORAAGE(this, 444);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppSyncLoadAllStatesDistTalCity.getAllStates(MainActivity.this);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSyncLoadAllStatesDistTalCity.getAllCities(MainActivity.this, "sub-district/04204.html");
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void statesLoaded(ArrayList<SyncStatesReq> list) {

        AppSyncLoadAllStatesDistTalCity.DiloagShow(list, "States", "select state", "state");

    }

    @Override
    public void districtLoaded(ArrayList<SyncStatesReq> list) {
        AppSyncLoadAllStatesDistTalCity.DiloagShow(list, "District", "select district", "district");
    }

    @Override
    public void talukaLoaded(ArrayList<SyncStatesReq> list) {
        AppSyncLoadAllStatesDistTalCity.DiloagShow(list, "Taluka", "select taluka", "taluka");
    }

    @Override
    public void cityLoaded(ArrayList<SyncStatesReq> list) {
        AppSyncLoadAllStatesDistTalCity.DiloagShow(list, "City", "select city", "city");
    }

    @Override
    public void stateSelected(String state, String link) {
        button.setText("" + state);
    }

    @Override
    public void districtSelected(String district, String link) {
        button2.setText("" + district);

    }

    @Override
    public void talukaSelected(String district, String link) {

    }

    @Override
    public void citySelected(String city, String link) {

    }

}
