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
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import com.teamup.app_sync.AppSyncFilter;
import com.teamup.app_sync.AppSyncFromToDatePicker;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInputDialogs;
import com.teamup.app_sync.AppSyncInstallation;
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
import com.teamup.app_sync.AppSyncWebviewDialog;
import com.teamup.app_sync.AppSyncWorldSelector;
import com.teamup.app_sync.Reqs.SyncNewsReq;
import com.teamup.app_sync.Reqs.SyncStatesReq;
import com.teamup.app_sync.Scrapping.AppSyncDictionary;
import com.teamup.app_sync.Scrapping.AppSyncNews;
import com.teamup.app_sync.Scrapping.AppSyncScrapQuotes;
import com.teamup.app_sync.cctoast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import static com.teamup.app_sync.AppSyncSaveArrayList.getListToJsonArray;


public class MainActivity extends AppCompatActivity implements AppSyncDictionary.DictionaryCode, AppSyncFilter.OptionSelected, AppSyncWorldSelector.Country_selected {

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

        AppSyncInstallation.set_instaltion(this);

        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

        ArrayList<String> list = new ArrayList<>();
        list.add("Sort by Ascending");
        list.add("Sort by Descending");
        list.add("Sort by Date ASC");
        list.add("Sort by Date DESC");
        AppSyncFilter.setFilterOptions(list);

        AppSyncPermissions.READ_WRITE_STORAAGE(this, 444);

        AppSyncDictionary.get_meaning(MainActivity.this, "Bottle");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppSyncWorldSelector.get_all_countries(MainActivity.this);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public void short_meaning(String result) {
        txt1.setText("" + result);
    }

    @Override
    public void long_meaning(String result) {
        txt1.append("\n\n" + result);
    }

    @Override
    public void defenation_meaning(String child, String result) {
        txt1.append("\n\n" + child + "\n" + result);
    }

    @Override
    public void error_loading() {
        AppSyncToast.showToast(getApplicationContext(), "Error loading");
    }

    @Override
    public void option_selected(String selected_option, int option_position) {
        AppSyncToast.showToast(getApplicationContext(), "Selected : " + selected_option + " at : " + option_position);
    }

    @Override
    public void closed() {
        AppSyncToast.showToast(getApplicationContext(), "Closed");
    }

    @Override
    public void selected(String name_of_country, String flag_img_url, String country_code) {
        AppSyncToast.showToast(getApplicationContext(), name_of_country);
    }
}
