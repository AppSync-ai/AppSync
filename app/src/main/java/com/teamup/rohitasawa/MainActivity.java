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

import com.teamup.app_sync.AppSyncChatBot;
import com.teamup.app_sync.AppSyncDirectResponseListen;
import com.teamup.app_sync.AppSyncDirectResponseListenOffline;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInstallation;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Scrapping.AppSyncHashTags;
import com.teamup.app_sync.Scrapping.AppSyncImagesFromWord;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AppSyncHashTags.Hashtags {

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

        img_1 = findViewById(R.id.img_1);
        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        AppSyncDirectResponseListenOffline appSyncDirectResponseListen = new AppSyncDirectResponseListenOffline(this);
        appSyncDirectResponseListen.getResponseFromUrl(new AppSyncDirectResponseListenOffline.ResponseListener() {
            @Override
            public void responser(String response, String datakey) {
                if (datakey.equalsIgnoreCase("KKK")) {
                    Log.wtf("Hulk-68", response);
                }
            }
        });
        appSyncDirectResponseListen.getResponseFromUrlMethod("http://adminapp.tech/matka/api/markets?userid=2", "KKK");


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
    public void error_loading() {
        Log.wtf("Hulk-err-126", "Error");
    }

    @Override
    public void loaded_hashtags(ArrayList<String> list_of_hashtags) {
        Log.wtf("Hulk-88", list_of_hashtags.get(0) + " ");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 55) {
            if (data != null) {

                AppSyncToast.showToast(getApplicationContext(), "Chat Complete : \n" + data.getStringExtra("result"));

            }
        }
    }
}
