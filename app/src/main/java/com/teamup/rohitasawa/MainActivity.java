package com.teamup.rohitasawa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInstallation;
import com.teamup.app_sync.Scrapping.AppSyncImagesFromWord;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AppSyncImagesFromWord.Translate {

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

        AppSyncImagesFromWord.get_images_of_word(this, "water");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
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
    public void error_loading() {
        Log.wtf("Hulk-err-126", "Error");
    }

    @Override
    public void translated(ArrayList<String> list_of_urls) {
        Log.wtf("Hulk-61", list_of_urls.size() + "");
    }


}
