package com.teamup.rohitasawa;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import com.teamup.app_sync.AppSyncFromToDatePicker;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInputDialogs;
import com.teamup.app_sync.AppSyncJsonArray;
import com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity;
import com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity;
import com.teamup.app_sync.AppSyncMobileInfo;
import com.teamup.app_sync.AppSyncNewPleaseWait;
import com.teamup.app_sync.AppSyncNotification;
import com.teamup.app_sync.AppSyncPHPMailer;
import com.teamup.app_sync.AppSyncPaths;
import com.teamup.app_sync.AppSyncPermissions;
import com.teamup.app_sync.AppSyncPleaseWait;
import com.teamup.app_sync.AppSyncPost;
import com.teamup.app_sync.AppSyncSaveArrayList;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Reqs.SyncNewsReq;
import com.teamup.app_sync.Reqs.SyncStatesReq;
import com.teamup.app_sync.Scrapping.AppSyncNews;
import com.teamup.app_sync.Scrapping.AppSyncScrapQuotes;
import com.teamup.app_sync.cctoast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import static com.teamup.app_sync.AppSyncSaveArrayList.getListToJsonArray;


public class MainActivity extends AppCompatActivity implements AppSyncFromToDatePicker.DateSelected, AppSyncScrapQuotes.Quotes {

    Button button, button2;
    TextView txt1, txt2;
    ImageView img;
    RelativeLayout manage_reler;
    ImageView img_1;
    boolean f_img = true;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppSyncInitialize.init(MainActivity.this);

        img_1 = findViewById(R.id.img_1);
        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

        AppSyncScrapQuotes.getRanomQuote(this);

        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f_img) {
                    f_img = false;
                    img_1.setImageResource(R.drawable.img_2);
                } else {
                    img_1.setImageResource(R.drawable.img_1);
                    f_img = true;
                }
            }
        });

        AppSyncPermissions.READ_WRITE_STORAAGE(this, 444);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String path = AppSyncPaths.getDownloadFolderPath(MainActivity.this, "tp.txt");
                Toast.makeText(MainActivity.this, "" + path, Toast.LENGTH_SHORT).show();

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
    public void FromDate(String date) {
        Log.wtf("Hulk-131-from", date);
    }

    @Override
    public void ToDate(String date) {
        Log.wtf("Hulk-136-to", date);
    }

    @Override
    public void gotRandomQuote(String quote, String quoteBy) {
        AppSyncToast.showToast(this, quote);
    }
}
